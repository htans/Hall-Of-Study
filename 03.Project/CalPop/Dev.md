# Dev
Next.js + Tailwind 기반 Admin Template.  
Starter 버전을 기반으로 커스터마이징하여 CalPop 프로젝트 개발

하나씩 공부하면서 하는게 맞는데, 나한테는 프로젝트를 실제 개발하면서 필요한 부분을 공부하는것이 나한테 맞는 케이스 같아서 이렇게함 ㅋ;

---

## 템플릿  
  - URL: https://preview.themeforest.net/item/ecme-nextjs-tailwind-admin-template-app-router/full_screen_preview/56475600  
  - 템플릿을 구매하면 크게 TypeScript, JavaScript 가 나오는데, TypeScript로 선정
    - Demo : 참고용
    - Starter : 개발 셋업용
    - documentation : index.html이 온라인 문서로 연동됨

## Installation
  - Node.js / npm 필요  
  - 압축 해제 후 `TypeScript/starter` 폴더에서 작업 시작  
  - 패키지 설치  
    ```bash
    npm install
    npm run dev
    ```

  ## TailWend CSS
  - 템플릿 전체가 TailWend 로 구성되어 있음
  - 일부 컴포넌트 에서는 @apply 디렉티브 구성으로 되어있음
  - 내가 수정할때도 @apply + import 구성으로 유틸리티 클래스를 재사용

## .env 
  - 환경변수 파일
    - 민감한 정보(API Key, DB 사용자 정보, 시크릿 값 ..)은 여기서 관리
      - 전자정부에 properties 같은 역할
      - 빌드/런타임 시점에서 접근
  - 파일위치
    - 프로젝트 루트 디렉토리에 존재
  - 변수 네이밍 규칙
    - Pubilc  
      - `NEXT_PUBLIC_` 접두사 붙음
      - 클라이언트 (JSX, 브라우저) 에서도 접근가능
      - 원하는 곳으로 자유롭게 이동가능
    - Private 
      - 접두사 없음
      - 서버에서만 접근 가능
  - 접근방법
    - 서버 사이드 (API Routes / 서버 컴포넌트)
      ```ts
      export async function GET() {
        const databaseUrl = process.env.DATABASE_URL;
        return new Response('Database URL: ' + databaseUrl);
      } 
      ```
    - 클라이언트 사이드 (React 컴포넌트)
      ```ts
      const apiBaseUrl = process.env.NEXT_PUBLIC_API_BASE_URL;

      useEffect(() => {
          console.log('API Base URL:', apiBaseUrl);
      }, []);
      ```

## 폴더 디렉토리
  - URL : https://ecme-next.themenate.net/guide/documentation/folder-structure
    - Ecme 폴도 구조 요약 (너무 많아서 이거 기억도 못함;;; 걍 필요할때 찾아봐야함;;;)
      - .dev
        - 환경변수 (DB, API 키 등)
      - next.config.mjs
        - Next.js 설정
      - tailwind.config.ts
        - TailWind 테마/스타일 설정
      - tsconfig.json
        - TypeScript 설정
      - package.json
        - 의존성 & 스크립트
    - 주요 디렉토리
      - `messages/`
        - 다국어 지원 메세지 JSON 파일 모음
      - `public/`
        - 정적파일 
          - 필드시 그대로 배포됨
      - `scr/`
        - 앱의 핵심 코드
          - `@types/`
            - 공용 타입 정의
              - 근데 왜 어떤건 .ts 이고, 어떤건 .tsx 지??
                - .ts - 타입스크립트 + JSX 없음
                - .tsx - 타입스크립트 + JSX 가능
                  - 기능상 차이는 JSX 뿐인데, 없으면 .ts 로 두는게 맞음
                - 근데 의도된건 아니고, 그냥 습관성으로 할 수도 있다네
                - 혹시 모를 JSX 대비  
                  - 걍 익숙한대로 쓰나보네
                    - JSX 가 정확하게 뭐지??
                      - JSX = JavaScript + XML
                        - 원래 리액트는 UI를 함수로만 구성했어야함
                          ```js
                          React.createElement("dev", null, "Hello");
                          ```
                          - 와 극혐이네
                        - 그래서 나온게 JSX(JSX = JavaScript + XML) 임
                          - JavaScript 안에서 XML/HTML 비슷한 문법을 쓸 수 있게 해주는 문법 확장
                            ```tsx
                            const Hemllo = () => <div>Hello</div>;
                            ```
                        ---
                        - 내가 익숙한 JSP랑 비교하면?
                          - JSP
                            - HTML 문서 안에 Java 코드를 섞어서 서버에서 실행 후 결과 HTML을 만들어 클라이언트에 넣어줌 
                              - 서버사이드 렌더링 느낌
                              ```jsp
                              <div>
                                Hello, <%= user.getName() %>
                              </div>
                              ```
                          - JSX
                            - JavaScript(React) 코드 안에 HTML 태그 같은 문법을 섞어서 브라우저에서 UI를 렌더링
                              - 클라이언트 사이드 렌더링 느낌
                              ```tsx
                              const Hello = ({ user}) => <div>Hello, {user.name}</div>;
                              ```
                          ---
                          - 차이 포인트
                            - 실행 위치
                              - JSP : 서버에서 실행 
                                - HTML 완성해서 클라이언트에 전송
                              - JSX : 클라이언트(브라우저)에서 실행
                                - JS가 HTML을 그려냄
                            - 역할
                              - JSP : 템플릿 엔진 같은 느낌 (서버에서 동적으로 HTML 생성)
                              - JSX : UI 컴포넌트를 선언하는 문법(React가 JS로 DOM을 그려줌)
                            - 결과물
                              - JSP : 최종 결과는 서버가 만든 HTML
                              - JSX : 최종 결과도 브라우자가 만든 HTML
                          - 결론
                            - 걍 JSP는 요리 다 만들어줘서 손님한테 주는거고, JSX는 손님이 레시피보고 만들어서 요리 탄생시키는거네
          - `app/`
            - Next.js App Router 메인 부분
            - 실제 앱에 페이지 api 들이 들어있는 디렉토리
              - `(auth-pages)`
                - 로그인/회원가입
              - `(protected-pages)`
                - 로그인 필요 페이지
                  - 로그인 필요 페이지가 뭐임??? 개인정보 수정 같은 페이지인가?
                    - 맞음 Public 이랑 Protected 페이지 경로가 나눠져 있음
                      - 큰 틀로 Public, Protected로 나눠서 관리 하는게 아니라, 작은 단위로 쪼개서 나누는구나
                      - 생각해보면 크게 나눠서 관리하면 오히려 더 불편하고, 경로 찾아가고 매칭하는것도 쉽지 않을듯
                      - 확장성, 관리성을 생각해보면 작은 모듈단위로 나눠서 관리하는게 훨씬 좋아보임
                        - Public Page (누구나 접근 가능)
                          - `/home`
                          - `/about`
                          - `/sign-up`, `/sign-in`
                        - Protected Page (로그인 필요)
                          - `/profile/edit`
                          - `/memo`
                          - `/admin`
                            - 여기는 섹션 or 토큰이 있어야 접근가능
                              - 당연할듯
                            - middleware.ts에서 로그인이 안되어 있으면 `/sign-in`으로 리다이렉트
                              - 오 권한관리랑 섹션관리도 하나로 뽁 하나보네
              - `publick-pages`
                - 공개 페이지
                  - 위에 페이지도 공개페이지가 있지만, 여기는 회원이랑 관련이 없는 공지사항, FAQ, 이벤트페이지 이런게 형상되어 있는 것 같음
              - `api`
                - Next.js API Routes (백엔드 역할)
                  - 간단한 백엔드 기능을 할 수 있는 js 들이 담겨 있는 곳
              - `layout.tsx`
                - 루트 레이아웃
                  - 루트 레이아웃인만큼 앱에 전체 틀을 볼 수 있는 곳인듯
                  - 각각 화면에 레이아웃은 쪼개서 관리할 수도 있음
              - `not-found.tex`
                - 404 페이지
                  - 404 극혐
              - `page.tsx`
                - 실제 랜딩페이지가 되는 페이지
                - 루트 디렉토리에 있는건 걍 대문, 대틀이라고 생각하면 될듯
      - `assets/`
        - static 자원 (CSS, MarkDown, SVG 등)
          - 템플릿에 공용자원 및 사진을 모아놓는 곳인듯
          - 그럼 내가 개발하다가 수정하는 것도 여기에 모아놓으면 되나??
            - ㅇㅇㅇ 각 이미지나 스타일에 맞는 부분으로 넣어놓으면 되는데, 커스텀이라고 따로 빼서 관리하는게 더 좋아보임
            - 원본을 건들면 수정이나 제거할때 ㄹㅇ 힘드니까용
      - `components/`
        - 앱을 구성하는 컴포넌트들이 살고있는 마을
          - 컴포넌트는 델파이 할때만 들을 수 있을것 같았는데, Next.js 에서 듣게 될줄이야... 역시 도움안되는 경험은 없따리
            - `ui/`
              - 버튼, 드롭다운 같은 기본 컴포넌트
            - `template/`
              - Header, Footer, Nav
                - 말그대로 규격틀을 관리하는 폴더인듯
            - `shared/`
              - 페이지 단위에서 재사용되는 상위 컴포넌트
            - `layouts/`
              - 레이아웃 컴포넌트
            - `view/`
              - 실제 페이지 뷰 조합
                - Demo 버전에는 `view/` 폴더가 존재하지 않음
                  - 실제 개발할때는 생성해서 demo 버전을 참조해서 개발해야할듯
            - `auth/`, `docs/`, ...
              - 목적별 컴포넌트
                - 헉.. 이런 디렉토리를 이해하려면 next.js 의 구성을 잘 이해하고 있어야 딱딱 빡빡 나올듯
        - 살짝 정리
          - `ui/`
            - 가장 작은 단위
              - Button, input, Checkbox 같은 원자 단위
              `ui/Button.tsx`
              ```tsx
              export default function Button({ children, ...props }) {
                return <button className="px-4 py-2 bg-blue-500 text-white" {...props}>{children}</button>
              }
              ```
          - `shared/`
            - ui 컴포넌트를 재가공해서 특정 목적에 재사용 가능한 블록
              - LoginForm, RegisterForm, ProfiuleCard
                - 아 Form 단위로 묶은 단위구나
                `shared/AuthButton.tsx`
                ```tsx
                import Button from '@/components/ui/Button'

                export default function AuthButton({ label, ...props }) {
                  return <Button className="w-full" {...props}>{label}</Button>
                }

                - 그럼 묶으면서 이런저런거를 바꿀 수 있는건가?
              
          - `auth/`, `view/` ... 
            - 실제 페이지에서 사용하는 최종 버전
              - 여긴 잘 안건드리겠네 그럼
              `auth/LoginForm.tsx`
              ```tsx
              import AuthButton from '@/components/shared/AuthButton'

              export default function LoginForm() {
                return (
                  <form>
                    <input type="email" />
                    <input type="password" />
                    <AuthButton label="로그인" />
                  </form>
                )
              }
              ```
          - 이렇게 사용하면???
            - 버튼 스타일은 `ui/Button` 하나로 통일
            - 로그인/회원가입 마다 새 버튼을 만드는게 아니라 shared 레벨에서 변형
            - 최종 페이지에서는 shared 컴포넌트만 조립
          - 아 내가사용했던 방식은 <div><button> 처럼 하나씩 다 생성하고, 텍스트에 뭐에 뭐에 다 해서 뭐 하나 이슈생겨서 변경할려면 이곳저곳 돌아다니면서 수정해야되는데, Next.js는 해당 테마의 ui 폴더로부터 쭉쭉 내려와서 shared 폴더에서 한번 가공하고, 다 만들면 auth 폴더에 넣고 패키징 해서 그걸 화면에서 오 이건가!? 하고 뽁 쓰니까, 수정하기도 편하겠네
      - `configs/`
        - AppConfig, ThemeConfig 같은 설정
          - 여기에 .ts에 뭐 타입 설정이라든가, 템플렛에 설정이라든가 이런것들이 다 들어가있는거같음
      - `i18n/`
        - 다국어 세팅
      - `mock/`
        - 목업데이터
          - 걍 테스트용이나 표시용 더미데이터 인듯
      - `server/`
        - 서버 전용 액션 (Server Action, DB처리)\
          - 삐용삐용
      - `services/`
        - API 호출 계층 (Axios, ApiService.ts)
          - 근데 server랑 services 랑 나눠놓는게 무슨이유지??
            - `server/`
              - 서버 전용 로직 (백엔드 역할)
                - Next.js Server Actions / DB 직접 처리 / 인증 / 파일 업로드 등
                - Node.js 환경에서만 실행됨 (클라이언트에 절대 노출 안됨)
                ```ts
                // src/server/actions/memo.ts
                import { db } from '@/server/db'

                export async function createMemo(data) {
                  return db.memo.insert(data) // MongoDB 직접 접근
                }
                ```
                - DB나 민감한 API Key를 직접 쓸 수도 있음 (서버만 아는 영역)
              - `services/`
                - 클라이언트에서 서버랑 통신 (Axios 계층)
                  - 브라우저(클라이언트)에서 API 호출하는 코드
                  - 보통 REST API / GraphQL 같은 엔드 포인트랑 통신
                  ```ts
                  // src/services/memoService.ts
                  import ApiService from './ApiService'

                  export async function getMemos() {
                    return ApiService.get('/api/memo')
                  }
                  ```
              - 굳이?
                - 보안/책임 분리
                  - `servers/`
                    - DB접근, 비즈니스 로직 (백엔드 담당)
                  - `services/`
                    - 프론트엔드가 호출할 API 정리 (클라 담당)
                - 확장성
                  - 나중에 별도 백엔드 서버로 분리되도 `servers/` 그대로 백엔드 이동, `services/` 프론트에서 API만 교체
                - 역할 명확화
                  - `server/`는 데이터를 만드는 곳
                  - `services`는 데이터를 가져다 쓰는 곳
                    - 결국에 역할 분담이 제일 큰 이유이고, 서로 작업파이에 구분과 권한이 젤 큰 이유이지 않을까 싶음
      - `utils/`
        - 훅, 재사용 함수 모음
          - 이 훅이 뭐임?? 훅! 훅! ㄹㅇ 뭔 랩도 아니고 훅이 뭐여
            - 훅 (Hook) in React / Next.js
              - React에서 훅은 상태 관리, 생명주기, 로직 재사용을 위한 특별한 함수
              - 보통 `use`로 시작 (`useState`, `useEffect`, `useCallback`, ...)
                - 기본 훅 (React 내장)
                  - `useState`
                    - 상태관리 (값 저장소)
                  - `useEffect`
                    - 특정 시점 (마운트, 업데이트, 언마운트)에 코드 실행
                  - `useRef`
                    - DOM 직접 접근
                  - `useContext`
                    - 전역 상태 관리
                  ```tsx
                  import { useState, useEffect } from "react"

                  export default function Counter() {
                    const [count, setCount] = useState(0)  // 상태 훅

                    useEffect(() => {
                      console.log("렌더링 될 때마다 실행됨")  // 효과 훅
                    }, [count])  // count 바뀔 때마다 실행

                    return (
                      <button onClick={() => setCount(count + 1)}>
                        {count}번 클릭함
                      </button>
                    )
                  }
                  ```
                - 커스텀 훅 (내가 만든 훅)
                  - 공통 로직을 묶어서 재사용할 때
                  - 이름 규칙 : `useSomething`
                  ```tsx
                  import { useState, useEffect } from "react"

                  export function useWindowSize() {
                    const [size, setSize] = useState({ width: 0, height: 0 })

                    useEffect(() => {
                      const updateSize = () => setSize({ width: window.innerWidth, height: window.innerHeight })
                      window.addEventListener("resize", updateSize)
                      updateSize()
                      return () => window.removeEventListener("resize", updateSize)
                    }, [])

                    return size
                  }
                  ``` 
                  - 이제 아무곳에서나 const { width, height } = useWindowSize() 호출
                - utils/의 훅
                  - `utils/hooks/`에 커스텀 훅들이 들어있음
                    - `useAuth` 
                      - 로그인 여부 확인
                    - `useDarkMode`
                      - 다크모드 상태 관리
                    - `useFetch`
                      - API 데이터 가져오기
                - 정리
                  - 컴포넌트 생명주기/상태에 걸어서 로직을 실행하는 함수
                  - `utils/hooks/` == 프로젝트 전역에서 재사용 가능한 훅 모음집
                  - 요청-진행-출력 할때 타이밍 맞게 밀어넣어서 로직을 실행하게 해주는 거임 그래서 훅 들어가서 훅임? ㅋㅋㅋ ㅈㅅ;
                  ```tsx
                  import { useState } from 'react'

                  export default function Counter() {
                    const [count, setCount] = useState(0)

                    return (
                      <div>
                        <p>현재 카운트: {count}</p>
                        <button onClick={() => setCount(count + 1)}>+1</button>
                      </div>
                    )
                  }
                  ```
                  - `userState` 라는 Hook을 밀어넣어서 count라는 상태 로직이 붙음
                  ```tsx
                  import { useEffect } from 'react'

                  export default function Hello() {
                    useEffect(() => {
                      console.log("컴포넌트가 화면에 나타났음!")
                    }, [])

                    return <h1>Hello</h1>
                  }
                  ```
                  - `useEffect` 를 밀어넣어서 마운트될 때!! 콘솔 찍는 로직이 실행됨
                  ```tsx
                  // hooks/useAuth.ts
                  import { useState, useEffect } from 'react'

                  export function useAuth() {
                    const [user, setUser] = useState(null)

                    useEffect(() => {
                      // 예: localStorage 에서 유저 정보 불러오기
                      const userData = localStorage.getItem('user')
                      if (userData) setUser(JSON.parse(userData))
                    }, [])

                    return user
                  }

                  // LoginPage.tsx
                  import { useAuth } from '@/utils/hooks/useAuth'

                  export default function LoginPage() {
                    const user = useAuth()
                    return <div>{user ? `${user.name}님 환영합니다` : '로그인 해주세요'}</div>
                  }
                  ```
                  - 로직을 함수처럼 재사용할 수 있게 해주는 도구
                  - 기존이라면 요청 > 진행 > 출력 을 각 화면마다 다 써야하는데, Hook으로 정의해놓으면 필요할때 훅 넣어서 사용가능 ㅋㅋ                   
                - 그럼 같은 디렉토리에 hoc 은 뭐임?
                  - Hoc(Higher-Order Component) 
                    - 컴포넌트를 감싸서 기능을 확장해주는 패턴
                      - 함수영 컴포넌트에 추가 긴으을 덧씌우는 느낌
                      - 마치 함수에 다른 함수를 넣어 새로운 함수를 반환하는 것처럼, 컴포넌트를 넣으면 새로운 기능이 붙은 컴포넌트를 반환함
                      ```tsx
                      // hoc/withAuth.tsx
                      import React from 'react'

                      export function withAuth(Component) {
                        return function ProtectedPage(props) {
                          const isLoggedIn = false // 예시: 실제로는 auth 상태 체크
                          if (!isLoggedIn) return <p>로그인 필요</p>
                          return <Component {...props} />
                        }
                      }

                      // pages/Profile.tsx
                      import { withAuth } from '@/utils/hoc/withAuth'

                      function Profile() {
                        return <h1>내 프로필</h1>
                      }

                      export default withAuth(Profile)
                      ```
                      - Profile은 그냥 화면컴포넌트인데 `withAuth` HOC으로 감싸면 로그인 안했을때는 접근 차단 기능이 자동 추가
                - 음..... ㅇㅋ
                  - 치킨 기름에 넣을때, 치킨 튀길때, 치킨 배달나갈때!!!
                    - Hook : 무를 훅 넣는게 훅임 ㅇㅇㅇ - 필요할때 넣음
                    - Hoc : 아예 주문받을때 무를 넣을건데, 카운팅 하는 시스템을 만듦 - 시작부터 구조적으로 묶음
                      - 각자 독립적인 개념
                  - ㅋㅋㅋㅋㅋㅋㅋㅋㅋ 아니 이렇게 이해하는 애가 어디있음 대체 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 나에요 ㅠ
      - `auth.ts`
        - NextAuth 설정
          - 지금 next-auth 라이브러리 설정 파일
          - Next.js에서 로그인/섹션 관리를 쉽게 해주는 인증 라이브러리
            - 로그인 방식 연결
              - 구글, 깃허브, 카카오 같은 OAuth 제공자
              - 이메일/비밀번호
              - JWT 토큰 기반 로그인
            - 세션 관리
              - 로그인 상태를 쿠키나 JWT로 유지
              - `useSeeion()`같은 Hook으로 현재 로그인한 사용자 가져올 수 있음
            - 보안 처리
              - API 호출 시 로그인 여부 확인
              - 특정 페이지 접근 차단 가능
          - 로그인/로그아웃/세션을 관리하는 전체 인증 설정 파일
      - `middleware.ts`
        - 인증/리다이렉트 제어
          - 요청할때 가로채서 뭔가 처리하는 역할
            - 클럽 앞에 문지기 역할
  ### 결론
  - 디렉토리 짱 많다... 필요할때 문서를 참고하면서 찾아보면서 해야할듯

## Routing
  - Next.js 기본 라우팅
    - 파일 기반 라우팅
      - `/app` 폴더 안의 파일 = URL 경로
        - `/app/page.tsx` -> `/`
        - `/app/articles/page.tsx` -> `/articles`
        - `/app/articles/[slug]/page.tsx` -> `/articles/anything`
      - 중첩 라우팅 -> 하위 폴더 = 서브경로
      - 이게 ㄹㅇ 신기술인듯, 포유잡은 하나하나 다 컨트롤러 만들어주고, 리다이렉션 해줘야하는데 여긴 디렉토리에 넣어주면 바로 뽁뽁 가짐 == 신세계
  - Ecme 커스텀 라우팅 (src/configs/routes.cinfig/index.ts)
    - Ecme는 Next.js 라우팅에 추가 설정 레이어들 둠
      - 각 페이지에서 권한/레이아웃/메타데이터를 붙일 수 있음
    - 라우트 그룹
      - `publicRoutes`
        - 로그인 안해도 접근 가능 
          - 회사 소개, 메인 페이지 등
      - `protectedRoutes`
        - 로그인 필요
          - 마이페이지, 대시보드 등
      - `authRoutes`
        - 인증 관련 페이지
          - 로그인, 회원가입 등
  - 라우팅 설정 구조
    ```tsx
    export const protectedRoutes = {
      '/articles': {
        key: 'articles',
        authority: ['admin', 'user'],
        meta: {
          pageContainerType: 'contained',
        },
      },
      '/articles/[slug]': {
        key: 'articles.articleDetails',
        authority: ['admin', 'user'],
        meta: {
          pageContainerType: 'contained',
        },
        dynamicRoute: true,
      },
    }
    ```
    - key : 라우트 식별자 (네비게이션 메뉴랑 매칭용)
    - authority : 접근 가능한 역할 (RBAC, Role-Based Access Control)
      - `['admin', 'user']` -> 관리자와 일반 유저만 접근
      - `[]` 모든 권한 가능
    - meta : 페이지 레이아웃/헤더/푸터 등 부가 설정
    - dynamicRoute : `true`면 동적 라우트 (`/articles/[slug]`)
  - Meta 속성 정리
    ```tsx
    meta: {
      pageContainerType: 'gutter',   // 'default' | 'gutterless' | 'contained'
      pageBackgroundType: 'plain',   // 'default' | 'plain'
      header: {
        title: 'My title',
        description: 'Some description',
        contained: false,
        extraHeader: lazy(() => import('@/components/SomeComponent')),
      },
      footer: false,                 // 기본 true, false면 안 보여줌
      layout: 'blank',               // 레이아웃 override
    }
    ```
    - pageContainerType : 화면 레이아웃 여백 스타일
    - pageBackGroundType : 배경 스타일
    - header : 페이지 상단 헤더 설정 (타이틀, 설명, extraHeader)
    - footer : 푸터 표시 여부
    - layout : 페이지별 레이아웃 지정 (사이드바, 탑바 등)
  ### 결론
    - 기존 JSP에서 controller + interceptor + tiles layout 조합으로 페이지마다 권한이랑 레이아웃 다르게 준거랑 비슷한거같음 Next.js는 기본 라우팅은 단순이 경로만 연결해주는데, Ecme 라우팅 설정을 따르면 각 뚫려있는 경로에 권한,레이아웃,메타데이터까지 한방에 다 처리가 가능한거인듯 ㄹㅇ 쌉편하네 근데 생각보다 신경써야할게 엄청 많구나

## Create New Page
  - 페이지 위치 정하기
    - `src/app/(protected-pages)` -> 로그인 필요
      - 마이페이지, 대시보드 등
    - `src/app/(public-pages)` -> 누구나 접근 가능
      - 회사소개, 공고리스트 등

  - 파일 생성
    - 정적 라우트 : `src/app/new-page/page.tsx` -> `/new-page`
    - 동적 라우트 : `src/app/new-page/[id]/page.tsx` -> `/new-page/123`

  - 신규 페이지 컴포넌트 작성
    ```tsx
    const Page = () => {
        return (
            <div>
                <h1>Welcome to the New Page</h1>
                <p>This is a custom page.</p>
            </div>
        );
    };

    export default Page;
    ```
  - 라우팅 설정 추가
    - `src/configs/routes.config/index.js` 수정 -> 접근권한 / 메타데이터 붙이기
    ```ts
    import { ADMIN, USER } from '@/constants/roles';

    export const protectedRoutes = {
        ...protectedRoutes,
        '/new-page': {
            key: 'newPage',
            authority: [ADMIN, USER],
            meta: {
                pageContainerType: 'contained',
            },
        },
    };
    ```
    - key : 네비게이션 매칭용 식별자
    - authority : 접근 권한 ([`ADMIN, USER`])
    - meta : 레이아웃 및 헤더/푸터 설정
  - Client Component 분리 (SSR 최적화)
    - Next.js App Router에서는 페이지 파일을 서버 컴포넌트를 두고, 클라이언트 로직은 따로 분리하는게 베스트 프랙티스
    ```tsx
    // src/app/(protected-pages)/new-page/page.tsx
    import ClientComponent from './_components/ClientComponent';

    const NewPage = () => {
        return (
            <div>
                <h1>New Page</h1>
                <ClientComponent />
            </div>
        );
    };

    export default NewPage;

    // src/app/(protected-pages)/new-page/_components/ClientComponent.tsx
    'use client';

    const ClientComponent = () => {
        return <p>This component runs on the client.</p>;
    };

    export default ClientComponent;
    ```
    - 디렉토리에 `page.tsx` 만들면 곧바로 라우트 됨 (Next.js 기본)
    - Ecme 는 `routes.config`에 권한/메타까지 한번에 묶어서 관리 가능
    - 클라이언트 로직은 별도 컴포넌트 분리하면 SSR + CSR 깔끔 분리 가능
  ### 결론
    - 결국 내가 개발했던 환경에서는 화면별로 다 컨트롤러 작성해서 리다이렉션을 하고, SEO를 고려해서 메타데이터나 이미지파일을 생각하면서 구성하면서 가져오고, 어떤 화면에 접근할려면 로그인 여부/권한, 해당 접근가능한 id 체크 등 여러 로직을 집어넣어야 했는데 Next.js는 SSR, CSR 분리로 인해 화면을 분리해서 클라이언트에서 화면을 내려주기 때문에 SEO에서도 강력, 사용자 로딩면에서도 강력크하다. 그리고 `routes.config.ts`에 이미 메타데이터나 권한, 여러 조건들을 모아놓고 작성하기 때문에 화면별로 어떤 권한인지, 뭔지 파악하기 쉽고, 관리하기도 강려크하다. Next.js 짱짱
    ++ 이미지도 자동최적화 준다네.. 크흐...

## API Integration
  - Next.js API Routes 특징
    - 파일 기반 라우팅
      - `/app/api/` 디렉토리 안에 파일을 만들면 자동으로 API 엔드포인트가 됨
        - `src/app/api/hello/route.ts` -> `/api/hello`
      - req / res (Node.js 스타일)
        - `Request` 객체에서 body, query 등 파싱
        - `NextResponse`로 JSON 반환
      - 서버 전용 실행 (SSR)
        - DB접근, 인증로직, 외부 API 연동 등 보안에 필요한 로직을 안전하게 처리 가능
  - 예시: 간단한 API Route
    ```ts
    // src/app/api/hello/route.ts
    import { NextResponse } from 'next/server';

    const mockMethodThatSavesToDatabase = async (data: any) => {
        console.log('Data saved to database:', data);
    };

    export async function POST(request: Request) {
        try {
            const externalApiResponse = await fetch('https://jsonplaceholder.typicode.com/posts/1');
            const externalData = await externalApiResponse.json();

            await mockMethodThatSavesToDatabase(externalData);

            return NextResponse.json({ message: 'Data saved successfully', data: externalData });
        } catch (error: any) {
            return NextResponse.json({ error: 'Failed to save data', details: error.message }, { status: 500 });
        }
    }
    ```
  - Ecme의 ApiService (클아이언트 호출용 래퍼)
    - Axios 기반 유틸리티 제공
      - Axios 가 뭐임?
        - Http 통신 라이브러리 (브라우저 & Node.js 둘 다 지원)
        - 쉽게 말해서 Ajax의 업그레이드 버전
        - `fetch` Api도 있지만, `axios`는 그걸 더 편하게 쓰게 해주는 라이브러리

        - 기본 fetch
        ```ts
        // fetch 사용
        const resp = await fetch('/api/hello', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ name: '형' })
        });
        const data = await resp.json();
        ```

        - axios 사용
        ```ts
        import axios from 'axios';

        const resp = await axios.post('/api/hello', { name: '형' });
        console.log(resp.data);
        ```
        - 차이점
          - `fetch`는 `.json()` 같은 파싱을 직접 해야함
          - `axios`는 자동으로 파싱 (`resp.data`)
          - 에러 처리, 인터셉터, 토큰 헤더 붙이기 같은 고급 기능이 훨씬 편함

        - Ecme에서 말한 Axios 기반 유틸리티 
          - Ecme는 ApiService 라는걸 만들어서 
            - axios를 한번 감싸고 (wrapper)
            - 에러 처리, 응답 포맷 형식
            - JWT 토큰 자동 붙이기 등 공통 로직 처리 등등
          - 같은것을 처리 해놓음
            - JSP/서블릿에서 쓰는 HttpClient 유틸 같은거 인듯
            ```java
            // 자바 예시 (형식만 비슷하게)
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create("/api/hello"))
                .POST(HttpRequest.BodyPublishers.ofString("{\"name\":\"형\"}"))
                .build();
            HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
            ```
            - 이런 형식 포맷인데, axios는 개 깔끔함 
            - 정리
              - axios = HTTP 통신을 더 쉽게 해주는 JS 라이브러리
              - Ecme는 axios를 감싼 ApiService를 제공해서
                - 모든 API 호출이 일정한 포맷으로 관리
                - try/catch, 응답 구조, 에러 전부 통일됨
              - `fetch`
                - 브라우저에 기본 내장된 Ajax 기능 (JS 표준 API)
              - `axios`
                - `fetch`를 더 쓰기 편하고 강력하게 만든 외부 라이브러리
              - ajax 랑 비슷한건데, JS 기본 도구가 `fetch`이고, 실무에서는 `axios`를 이용해서 사용함
                - 기존에 포유잡은 HNttpsServletRequest / Response 같은걸 직접 쓰면서 개 귀찮았는데, `RestTemplate` 같은걸 쓰면 개편해짐
              - 결국 정해진 규격이 있으니까, 사용법을 이해하고, 어떤식으로 던지는데, 어떤식으로 받는지, 어떤걸 체크해야하는지를 파악해야함
    - 공통된 에러 처리 / 응답 파싱 로직을 자동화
      - 이게 아마 이런 툴과 외부 라이브러리를 쓰는 이유 중 하나 인듯
    - 제네릭 타입(`Response`, `Request`)으로 타입 안전성 확보
    - 서비스 예시
    ```ts
    // services/UserManagementService.ts
    import ApiService from './ApiService';

    type MyApiResponse = {
        someResponseData: string
        someResponseData2: boolean
    };

    type MyApiRequest = {
        someRequestData: string
    };

    export async function myApi(data: MyApiRequest) {
        return ApiService.fetchData<MyApiResponse, MyApiRequest>({
            url: '/my-api-url',
            method: 'post',
            data
        });
    }
    ```
    -- 컴포넌트에서 활용
    ```tsx
    import { myApi } from '@/services/UserManagementService';
    import { useEffect } from 'react';

    const MyComponent = () => {
        const fetchData = async () => {
            try {
                const resp = await myApi({ someRequestData: 'hello' });
                if (resp.data) {
                    console.log(resp.data.someResponseData);
                }
            } catch (err) {
                console.error(err);
            }
        };

        useEffect(() => {
            fetchData();
        }, []);

        return <div>My Component</div>;
    };
    ```
    - 추가적으로
      - 더 고급스럽게 하려면 SWR 또는 TanStack Query 같은 데이터 패칭 라이브러리랑 붙여서 캐싱 / 리페치 처리 가능
      - 결국 구조는
        - Next.js API Route -> 서버 전용 로직
        - ApiService -> 프론트 공통 Axios Wrapper
        - 컴포넌트 -> 서비스 함수 호출
    - 기존에 JSP/서블릿에서 하던 Controller -> Service -> DAO 구조랑 비슷한데,
      - Controller = `Next.js API Route`
      - Service = `ApiService 래퍼 + 서비스 함수`
      - View = `해당 컴포넌트`
  ### 결론
    - 솔직히 글로만 읽었을때는 ??? 뭐징 뭐가 어떻게 된다는거지?! 했는데, Ajax라고 생각하고 접근하니까 이해가 가기 시작했음. 결국에 Service 딴에서 활용하는 axios를 활용해서 주고받기 때문에 조금 더 규격화 되고, TyprSciprt 인 만큼 강점이 더욱 더 될거라고 생각함. 물론. 아직 입으로만 털수 있음 ㅎㅎ ㅠ...