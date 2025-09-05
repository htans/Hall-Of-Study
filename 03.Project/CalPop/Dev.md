# Dev
React 기반의 Next.js 프로젝트 이기 때문에 개발하는것도 중요하지만, 다 똑같지는 않겠지만, Next.js는 정규화된 디렉토리가 존재하고 템플릿 디렉토리는 그걸 완벽하게 지키면서 UI를 개발해놓음
간단한 기능들 및 Mock 폴더로 되어있지만, 데이터 호출까지 붙어있기 때문에 이해하는데 편하겠지만, 처음 경험해보는 기술스택이기 때문에 궁금하고 이해안되는게 많을거같아서 부분부분을 기록하면서 쭉 해보고, 리버스 엔지니어링을 하면서 하나하나 의문을 갖고 접근하는게 맞는것 같음

---

## Issue
- Node.js로 템플릿을 올리면 로그인화면으로 바로 리다이렉트 되는데, Next.js 에서는 처음 대문여는 방법은 어떤식으로 구동되는거지?
    ```tsx
    // index_page.tsx

    // app.config.ts 에서 설정값을 불러옴 (예: 인증 후 이동할 경로)
    import appConfig from '@/configs/app.config'

    // Next.js 전용 네비게이션 함수 (리액트 라우터랑 비슷한 느낌)
    // 서버 컴포넌트에서도 바로 redirect 할 수 있음
    import { redirect } from 'next/navigation'

    // 페이지 컴포넌트 정의
    // Next.js에서는 파일 이름(page.tsx)이 경로(`/`)랑 매핑됨
    const Page = () => {
        // 페이지가 렌더링되자마자 즉시 redirect 실행
        // appConfig.authenticatedEntryPath (예: '/dashboard') 로 강제 이동
        redirect(appConfig.authenticatedEntryPath)
    }

    // 위에서 만든 Page 컴포넌트를 export (Next.js가 자동으로 이걸 라우트로 사용)
    export default Page
    ```

    - 일단 app.config 을 import 해오는데!
        ```tsx
        import appConfig from '@/configs/app.config'
        // AppConfig 라는 타입 정의
        // 앞으로 appConfig 객체는 반드시 이 구조를 따라야 함
        export type AppConfig = {
            apiPrefix: string                // API 호출할 때 앞에 붙는 기본 경로
            authenticatedEntryPath: string   // 로그인된 사용자가 처음 들어갈 경로 (예: /home)
            unAuthenticatedEntryPath: string // 로그인 안 된 사용자가 가야 할 경로 (예: /sign-in)
            locale: string                   // 기본 언어 설정 (en, ko 등)
            activeNavTranslation: boolean    // 네비게이션 메뉴 다국어 번역 기능 켤지 여부
        }

        // 실제로 쓰일 설정 값들
        const appConfig: AppConfig = {
            apiPrefix: '/api',                // API는 /api/... 로 접근
            authenticatedEntryPath: '/home',  // 로그인 성공하면 /home으로 보냄
            unAuthenticatedEntryPath: '/sign-in', // 로그인 안 한 사람은 /sign-in으로 보냄
            locale: 'kr',                     // 기본 언어는 영어
            activeNavTranslation: false,      // 네비게이션 번역 기능은 꺼둠
        }

        // 다른 파일에서 import 할 수 있도록 export
        export default appConfig
        ```
    - 위에는 타입이 정의되어 있고, 밑에는 실제로 쓰는 값들이 자리잡고 있음
        - 처음에는 타입말고, 밑에 값들이 아! 이걸 가라는건가!? 했는데 ㄴㄴㄴ 그냥 정의해놓은거임
        - 정말 화면에 기본적인 설정들을 import만 함 실제로 뭐 하는건 없음

    - `import { redirect } from 'next/navigation'` 이 부분은 따로 내부소스에 있는줄 알았는데, Next.js 전용 네비게이션 함수이기 때문에, 내부에 소스를 놓고 뭘 하지는 않음! 라이브러리 같은 개념인듯
    공통적으로 사용되는 네비게이션을 사용하기 위한 준비임

    - 실제 페이지가 들어와서 첫번째 움직이는 부분
        ```tsx 
        const Page = () => {
                redirect(appConfig.authenticatedEntryPath)
            }
        ```
        - redirect() 는 Next.js에 내장되어 있는 내장 함수임
            - Next.js App Router 전용 함수임
            - 서버 컴포넌트에서만 동작
        - redirect(appConfig.authenticatedEntryPath) 처럼 authenticatedEntryPath: '/home', 이렇게 정의되어 있기때문에 일단 리다이렉트로 /home으로 보냄

    - `export default Page`에서 default는 layout이나 page 같이 기본적으로 라우팅되는 페이지에는 꼭 있어야함. 뭐 이거다! 깃발 꽂는 느낌인듯
    - Page 에서는 `/home`을 가져왔으니까, 일단 `/home` 디렉토리에 page.tsx로 던짐 
    - 그럼 해당화면으로 이동되면서 네비게이션 이랑 여러가지들을 해당 루트디렉토리에 layout.tsx 을 가져와서 화면에 뿌려주게 됨
        ```tsx
        // home/page.tsx
        const Page = () => {
            return <div>Home page</div>
        }

        export default Page
        ```
    - 해당 페이지에는 정말 home 화면만을 위한 컴포넌트만 존재함
    - 브라우저에서  `localhost:3000`으로 들어오면 `http://localhost:3000/sign-in?redirectUrl=/`로 리다이렉트 되는데, /home으로 던지는데 저기로 가는게 궁금함
        - 해당 home 디렉토리에 `page.tsx`로 가지만, 네비게이션 레이아웃을 루트디렉토리에서 가져오고 있음 
        - 아마 여기서 인증관련된 무언가를 해주는게 아닐까 생각함
        ```tsx
        // layout.tsx
        import React from 'react'
        import PostLoginLayout from '@/components/layouts/PostLoginLayout'
        import { ReactNode } from 'react'

        const Layout = async ({ children }: { children: ReactNode }) => {
            return <PostLoginLayout>{children}</PostLoginLayout>
        }

        export default Layout
        ```