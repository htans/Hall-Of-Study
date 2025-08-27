# Documentation
Next.js + Tailwind 기반 Admin Template.  
Starter 버전을 기반으로 커스터마이징하여 CalPop 프로젝트 개발

하나씩 공부하면서 하는게 맞는데, 나한테는 도큐멘테이션 토대로 이해하면서 필요한 부분을 공부하는것이 나한테 맞는 케이스 같아서 이렇게함 ㅋ;

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
          - 아 내가사용했던 방식은 `<div>`, `<button>` 처럼 하나씩 다 생성하고, 텍스트에 뭐에 뭐에 다 해서 뭐 하나 이슈생겨서 변경할려면 이곳저곳 돌아다니면서 수정해야되는데, Next.js는 해당 테마의 ui 폴더로부터 쭉쭉 내려와서 shared 폴더에서 한번 가공하고, 다 만들면 auth 폴더에 넣고 패키징 해서 그걸 화면에서 오 이건가!? 하고 뽁 쓰니까, 수정하기도 편하겠네
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
    디렉토리 짱 많다... 필요할때 문서를 참고하면서 찾아보면서 해야할듯

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
    기존 JSP에서 controller + interceptor + tiles layout 조합으로 페이지마다 권한이랑 레이아웃 다르게 준거랑 비슷한거같음 Next.js는 기본 라우팅은 단순이 경로만 연결해주는데, Ecme 라우팅 설정을 따르면 각 뚫려있는 경로에 권한,레이아웃,메타데이터까지 한방에 다 처리가 가능한거인듯 ㄹㅇ 쌉편하네 근데 생각보다 신경써야할게 엄청 많구나

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
    결국 내가 개발했던 환경에서는 화면별로 다 컨트롤러 작성해서 리다이렉션을 하고, SEO를 고려해서 메타데이터나 이미지파일을 생각하면서 구성하면서 가져오고, 어떤 화면에 접근할려면 로그인 여부/권한, 해당 접근가능한 id 체크 등 여러 로직을 집어넣어야 했는데 Next.js는 SSR, CSR 분리로 인해 화면을 분리해서 클라이언트에서 화면을 내려주기 때문에 SEO에서도 강력, 사용자 로딩면에서도 강력크하다. 그리고 `routes.config.ts`에 이미 메타데이터나 권한, 여러 조건들을 모아놓고 작성하기 때문에 화면별로 어떤 권한인지, 뭔지 파악하기 쉽고, 관리하기도 강려크하다. Next.js 짱짱
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

## Authentication
  - 기본 개념
    - NextAuth.js 
      - Next.js에서 쓰는 표준 인증 라이브러리
    - 지원
      - OAuth (구글, 깃허브 등), Credentials(커스텀), 이메일 링크 등
    - 보안
      - 세션 토큰 암호화, 환경변수 기반 설정
    - 위치
      - `src/configs/auth.config.ts`에서 중앙 관리
  - 환경변수 설정
    ```env
    AUTH_SECRET=랜덤한_문자열
    NEXTAUTH_URL=http://localhost:3000

    GOOGLE_AUTH_CLIENT_ID=xxxx
    GOOGLE_AUTH_CLIENT_SECRET=xxxx
    GITHUB_AUTH_CLIENT_ID=xxxx
    GITHUB_AUTH_CLIENT_SECRET=xxxx
    ```  
    - `AUTH_SECRET`
      - 세션 토큰 암호화
    - `NEXTAUTH_URL`
      - 콜백 리다이렉트용 (운영 배포 시 도메인으로 교체)
    - `*_CLIENT_ID, *_CLIENT_SECRET`
      - OAuth Provider 자격증명
    
  - Providers 설정
    - (1) Credentials Provider (커스텀 로그인)
      ```ts
      Credentails({
        async authorize(credentials) {
          const user = await validateCredential(credentials as SingInCredential);
          if (!user) return null;

          return {
            id: user.id,
            name: user.userName,
            email: user.email,
            image: user.avatar,
          };
        },
      })
      ```
      - `validateCredential()` -> DB 조회 or API 호출
      - 성공 시 `user` 객체 반환 -> 세션에 저장됨
    - (2) OAuth Provider (구글, 깃허브)
      ```ts
      Google({
        clientId: process.env.GOOGLE_AUTO_CLIENT_ID!,
        clientSecret: process.env.GOOGLE_AUTH_CLIENT_SECRET!,
      }),
      Github({
        clientId: process.env.GITHUB_AUTO_CLIENT_ID!,
        clientSecret: process.env.GITHUB_AUTO_CLIENT_SECRET!,
      })
      ```
    - Callback 확장 (세션에 커스텀 속성 추가)
      ```ts
      callbacks: {
        async session(payload) {
          return {
            ...payload.session,
            user: {
              ...payload.session.user,
              id: payload.token.sub,
              authority: ['admin', 'user'], // 예시
            }
          }
        }
      }
      ```
      - 이렇게 하면 session.user 안에 추가 필드 (`id`, `authority`) 를 붙일 수 있음
  - 클라이언트/서버에서 세션 접근
    - (1) 클라이언트
      ```tsx
      import userCurrentSession from '@/utils/hooks/userCurrentSession';

      const Component = () => {
        const { session } = userCurrentSession();

        return session ? (
          <h1> Welcome {session.user.name}</h1>
        ) : (
          <p>You are not logged in. </p>
        );
      };
      ```
    - (2) 서버
    ```ts
    import { auth } from "@/auth";

    export default async function Page() {
      const session = await auth();

      if (!session) return <p>You must be logged in</p>;
      return <h1>Welcome {ssion.user.name}</h1>
    }
    ```
    - SSR 환경에서 세션 확인 가능
      - 인증된 사용자만 접근 가능하도록 처리
  - NextAuth 제거 방법
    - 1. `npm uninstall next-auth`
    - 2. `src/configs/auth.config.ts` 삭제
    - 3. `pages/api/auth/[...nextauth].ts` 삭제
    - 4. `middleware.ts` 초기화/삭제
    - 5. 컴포넌트 내 `auth()`, `userCurrentSession()` 호출부 제거
      - 예: `layout.tsx`, `UserProfileDropdown.tsx` 등
    - * 이렇게 하면 다른 인증 방식으로 교체 가능
  ### 결론
    나한테는 너무 어렵게 적혀있는데, 결국에는 Next.js에서 권한관리, 세션관리를 한방에 다 이렇게 한다. 이런거같음, 전에는 세션관리나 권한관리 등은 전부 따로 관리 했어야하는데, 이렇게 라이브러리로 프로젝트 자체에서 관리하니까 훨씬 수월하고 개발/유지보수 차원에서도 엄청날듯

## State management
  - Zustand가 뭐냐?
    - React에서 전역 상태 관리를 하는 작고 빠른 라이브러리
    - Redux처럼 복잡한 보일러플레이트 코드 없이, 가볍게 전역 상태를 다룰 수 있음
    - React의 기본 `useState`, `userReducer` 보다 스케일 키우기 쉽고, 유지보수도 간단
  - 코드 흐름
    - 스토어 정의
    ```ts
    const userCountesStore = create ((set) => ({
      count: 0,
      increaseCount: () => set((state) => ({ count: state.count + 1 })),
      decreaseCount: () => set((state) => ({ count: state.count - 1 })),
    }))
    ```
    - `count`라는 전역 상태와 `increaseCount`, `decreaseCount`라는 액션의 정의
  - 컴포넌트에서 사용
  ```tsx
  const { count, increaseCount, decreaseCount } = userCounterStore()
  ```
  - 이걸 쓰면 `userState`처럼 값이 바뀔 때 UI가 자동으로 리렌더링 됨
    - 이게 부분적으로 DOM을 변경하는거구나 ㅇㅇㅇ
  ### 결론
    Zustand는 전역 상태관리 라이브러리이면서 Redux는 사용해본적 없지만, 무거운 툴 대신에 가벼운 툴 인거네.
      - 근데 Redux 라는툴은 괜히 무겁게 된게 아닐텐데 이유가 뭐지?
        - Redux
          - `모든 상태는 하나의 전역 Store에 있다` -> 중앙 집중식
          - 상태 업데이트는 반드시 `Action` -> `Reducer` -> `Store` -> `UI` 순서로 흘러야 함.
          - 코드 구조가 명확하고 예측 가능하지만, `보일러플레이트 코드(반복코드)`가 많음
          - 대규모 애플리케이션에 강점.
          ```tsx
          // store.ts
          import { configureStore, createSlice } from '@reduxjs/toolkit';

          const counterSlice = createSlice({
            name: 'counter',
            initialState: { count: 0 },
            reducers: {
              increment: (state) => { state.count++ },
              decrement: (state) => { state.count-- },
            }
          })

          export const { increment, decrement } = counterSlice.actions;
          export const store = configureStore({ reducer: { counter: counterSlice.reducer }});

          // Counter.tsx
          import { useDispatch, useSelector } from 'react-redux';
          import { increment, decrement } from './store';

          export default function Counter() {
            const count = useSelector((state: any) => state.counter.count);
            const dispatch = useDispatch();

            return (
              <>
                <h1>{count}</h1>
                <button onClick={() => dispatch(increment())}>+</button>
                <button onClick={() => dispatch(decrement())}>-</button>
              </>
            );
          }
          ```
        - Zustand
          - `필요한 만큼의 store만 만들어 쓰자` -> 분산 관리 기능
          - 그냥 훅처럼 `create()`해서 바로 쓰면 됨
          - Action, Reducer 같은 형식적 절차 필요 없음 -> 짧고 직관적
          - 중소규모나 개인 프로젝트에서 특히 빛남, 대규모에서도 충분히 쓰임
          ```tsx
          // store.ts
          import { create } from 'zustand';

          const useCounterStore = create((set) => ({
            count: 0,
            increment: () => set((s) => ({ count: s.count + 1 })),
            decrement: () => set((s) => ({ count: s.count - 1 })),
          }));

          export default useCounterStore;
          
          // Counter.tsx
          import useCounterStore from './store';

          export default function Counter() {
            const { count, increment, decrement } = useCounterStore();
            return (
              <>
                <h1>{count}</h1>
                <button onClick={increment}>+</button>
                <button onClick={decrement}>-</button>
              </>
            );
          }
          ```
        - ㅇㅎ 차이점이 엄청나긴하네 확실히 디버깅, 대규모 프로젝트는 Redux 가 좋은 쪽일거같고, 소규모는 Zustand 가 좋을거같음. 내 프로젝트는 소규모니까 Zustand를 쓰는데, 회사를 대비해서는 Redux도 참고 해야할듯

## App Config
  ```ts
  // app.config.ts
  export type AppConfig = {
      apiPrefix: string
      authenticatedEntryPath: string
      unAuthenticatedEntryPath: string
      locale: string
      activeNavTranslation: boolean
  }

  const appConfig: AppConfig = {
      apiPrefix: '/api',
      authenticatedEntryPath: '/home',
      unAuthenticatedEntryPath: '/sign-in',
      locale: 'en',
      activeNavTranslation: false,
  }

  export default appConfig
  ```
  - 앱의 전역 설정값을 관리
    - `apiPrefix`
      - 모든 API 요청 앞에 붙는 기본 경로
        - `apiPrefix = "/api"` -> `fetch("/api/users")` 이런 식으로 호출
        - 나중에 백엔드 주소 바뀌어도 여기만 바꾸면 됨
      - `authenticateEntryPath`
        - 로그인 성공했을 때 유저가 처음 가는 기본 페이지 경로
        - Demo는 `/dashboards/ecommerce`, Starter는 `/home`
      - `unAuthenticatedEntryPath`
        - 로그인이 안 된 유저가 접근하려고 할 때 보내버리는 경로
          - `/sign-in` (로그인 화면)
      - `locale`
        - 앱 기본 언어 `en`
          - 한국 서비스라면 `ko`
      - `activeNavTranslation`
        - 네비게이션 메뉴 다국어 지원 on/off
  ### 결론
    말그대로 기본 경로, 기본 전역설정을 하는 부분인거같음

## Layout
  - Post Logiun Layout (로그인 후 레이아웃)
    - `src/components/layouts/PostLoginLayout/components/*` 안에서 확인가능
      - `collapsibleSide` ->  접었다 펼 수 있는 사이드 메뉴
      - `stackedSide` -> 고정된 사이드 메뉴 (접기 없음)
      - `topBarClassic` -> 상단 네비게이션 메뉴
      - `framelessSide` -> 경계선 없는 사이드 메뉴
      - `contentOPverlay` -> 콘텐츠 위에 오버레이 되는 메뉴
      - `blank` -> 아무 레이아웃 없는 빈 화면
    - 기본값은 `theme.config.ts`에서 설정
      ```ts
      export const themeConfig = {
        layout: {
          type: 'framelessSide', // 여기서 타입 바꿀 수 있음
        },
      }

      // theme.config.ts
      import { THEME_ENUM } from '@/constants/theme.constant'
      import type { Theme } from '@/@types/theme'

      export const themeConfig: Theme = {
          themeSchema: '',
          direction: THEME_ENUM.DIR_LTR,
          mode: THEME_ENUM.MODE_LIGHT,
          panelExpand: false,
          controlSize: 'md',
          layout: {
              type: THEME_ENUM.LAYOUT_COLLAPSIBLE_SIDE,
              sideNavCollapse: false,
          },
      }
      ```
  - 특정 라우트에서 레이아웃 오버라이드
    - 전체 앱은 `theme.config.ts` 설정을 따르지만, 특정 페이지는 다르게 줄 수 있음
    ```ts
    // 무조건 blank 레이아웃으로 보여주기 
    export const protectedRoutes = {
      '/your-page-path': {
        key: 'keyForYourPage',
        authority: [ADMIN, USER],
        meta: {
          layout: 'blank',
        },
      },
    }
    ```
  - Auth Layout (로그인/회원가입 화면)
    - Auth Layout은 따로 설정해야 함 
      - 경로 : `src/app/(auth-pages)/layout.tsx`
      ```tsx
      import { ReactNode } from 'react'
      
      // <!-- 선택 부분 -->
      import Side from '@/components/layouts/AuthLayout/Side'
      import Simple from '@/components/layouts/AuthLayout/Simple'
      // import Split from '@/components/layouts/AuthLayout/Split'
      // <!-- !선택 부분 -->

      const Layout = ({ children }: { children: ReactNode }) => {
        return (
          <div className="flex flex-auto flex-col h-[100vh]">
            <Simple>
              {children}
            </Simple>
          </div>
        )
      }

      export default Layout
      ```
      - 여기서 `Side`, `Simple`, `Split` 중 원하는걸로 교체하면 됨
  ### 결론
    화면별로 layout 틀을 선정해서 사용하는것 같음. 원래도 import로 인해서 사이드랑 뭐 로그인 부분, 메뉴 부분을 전부 다 수동으로 import 했다면 Next.js는 Layout 별로 그리고 사용하는 틀 별로 뜯어서 수정하고, 호출할 수 있게 관리되는것 같음. 당연히 뷰에서는 통일성이 올라가고, 수정도 쉽고, 관리하기도 좋을듯

## Navigation Config
  - 네비게이션은 배열(Object 트리 구조) 로 구성 -> `src/configs/navigation.config/index.ts`에 정의
  - 각 메뉴 아이템은 `NavigationTree` 타입을 따름
  ```ts
  export interface NavigationTree {
      key: string                // 라우트 매칭용 키 (중복 X)
      path: string               // 이동할 URL
      isExternalLink?: boolean   // 외부 링크 여부 (true면 새 탭)
      title: string              // 메뉴에 표시되는 텍스트
      translateKey: string       // 다국어 번역용 키 (없으면 title 그대로 표시)
      icon: string               // 아이콘 키 (navigation-icon.config.tsx에 매핑 필요)
      type: 'title' | 'collapse' | 'item' // 메뉴 종류
      authority: string[]        // 접근 권한 (ex. ['admin', 'user'])
      subMenu: NavigationTree[]  // 하위 메뉴
      description?: string       // (선택) 메뉴 설명
      meta?: {                   // (선택) 추가 설정
          horizontalMenu?: HorizontalMenuMeta
          description?: {
              translateKey: string
              label: string
          }
      }
  }
  ```
  - Type별 의미
    - `title` : 구분자(큰 카테고리)
    - `collapse` : 펼칠 수 있는 그룹 메뉴
    - `item` : 실제 링크(페이지 이동)
  - Horizontal Menu 옵션
  ```ts
  export type HorizontalMenuMeta =
    | { layout: 'default' }
    | { layout: 'columns', showColumnTitle?: boolean, columns: 1 | 2 | 3 | 4 | 5 }
    | { layout: 'tabs', columns: 1 | 2 | 3 | 4 | 5 }
  ```
  - `default` : 일반 메뉴
  - `columns` : 컬럼 형태 드롭다운
  - `tabs` : 탭 형태
  - 예시 구조
  ```ts
  const navigationConfig = [
    {
      key: 'uiComponent',
      path: '',
      title: 'Ui Component',
      translateKey: 'nav.uiComponents',
      icon: 'uiComponents',
      type: 'title',
      authority: ['admin', 'user'],
      meta: {
        horizontalMenu: { layout: 'columns', columns: 4 }
      },
      subMenu: [
        {
          key: 'uiComponent.common',
          path: '',
          title: 'Common',
          type: 'collapse',
          authority: ['admin', 'user'],
          subMenu: [
            {
              key: 'uiComponent.common.button',
              path: '/button',
              title: 'Button',
              type: 'item',
              authority: ['admin', 'user'],
              subMenu: []
            },
            {
              key: 'uiComponent.common.typography',
              path: '/typography',
              title: 'Typography',
              type: 'item',
              authority: ['admin', 'user'],
              subMenu: []
            }
          ]
        }
      ]
    }
  ]
  ```
  - 아이콘 연결
    - 아이콘은 별도 파일 `src/configs/navigation-icon.config.tsx`에서 관리
    ```tsx
    // navigation-icon.config.tsx
    import {
        PiHouseLineDuotone,
        PiArrowsInDuotone,
        PiBookOpenUserDuotone,
        PiBookBookmarkDuotone,
        PiAcornDuotone,
        PiBagSimpleDuotone,
    } from 'react-icons/pi'
    import type { JSX } from 'react'

    export type NavigationIcons = Record<string, JSX.Element>

    const navigationIcon: NavigationIcons = {
        home: <PiHouseLineDuotone />,
        singleMenu: <PiAcornDuotone />,
        collapseMenu: <PiArrowsInDuotone />,
        groupSingleMenu: <PiBookOpenUserDuotone />,
        groupCollapseMenu: <PiBookBookmarkDuotone />,
        groupMenu: <PiBagSimpleDuotone />,
    }

    export default navigationIcon
    ```
  ### 결론
    원래는 별도에 JSP를 호출해서, 파라미터나 식별자로 인해서 아이콘, 이름을 가져다가 썼는데, 여긴 별도로 아예 네비게이션 관리 딴이 있기 때문에 추가 및 관리 하기가 엄청 편할것 같음 매핑형식이라서 틀만 따라서 관리해도 이슈가 없을 것 같음
    - navigation.config.ts → 메뉴 트리 구조만 정의
    - navigation-icon.config.tsx → 아이콘 매핑만 관리
    - 권한(authority), 다국어(translateKey), 레이아웃(meta) → 전부 옵션으로 붙일 수 있음

## Theming
  - CSS variables로 기본 테마 정의
    - `assets/styles/tailwend/index.css`에 라이트/다크 공통 변수를 정의
    - `:root` -> 라이트 모드 기본값
    - `.dark` -> 다크 모드 값
    - 이렇게 하면 Tailwind나 커스텀 CSS에서 `var(--primary)` 이런 식으로 불러다 쓸 수 있음
  - TypeScript Theme Schaema 설정
    - `theme.config.ts`에 타입과 테마 스키마 정의
    - `Variables` -> 관리할 컬러 변수 키
    - `ThemeVariables` -> 라이트/다크 모드별 변수 값 구조
    ```ts
    export type Variables = "primary" | "primaryDeep" | "primaryMild" | "primarySubtle" | "neutral"
    export type ThemeVariables = Record<"light" | "dark", Record<Variables, string>>
    ```
    - 기본 테마와 커스텀 테마 예시를 만들어서 `presetThemeSchemaConfig`에 등록 해놓음
  - Theme Switcher 컴포넌트
    - `userTheme` 훅으로 현재 테마 스키마와 모드 상태를 가져옴
    - `Object.entries(parsetThemeSchemaConfig)`를 돌면서 버튼 UI로 테마 선택
    - 선택된 테마는 `setSchema(key)`로 업데이트
    ```tsx
    <button
      key={key}
      className={classNames(
        'h-8 w-8 rounded-full flex items-center justify-center border-2 border-white',
        schema === key && 'ring-2 ring-primary',
      )}
      style={{ backgroundColor: value[mode].primary }}
      onClick={() => setSchema(key)}
    >
      {schema === key && <TbCheck className="text-neutral text-lg" />}
    </button>
    ```
  - 확장 포인트
    - 템플릿에서는 `primary` 계열이랑 `neutral`만 있지만, 필요하다면 `error`, `warning`, `success` 등도 `Variables` 타입에 추가해서 확장 가능
    - Tailwind theme 확장(`tailwiund.config.js`)와 연결하면 더 깔끔하게 `bg-primary`, `text-error` 이런 식으로 바로 쓸 수도 있음
  ### 결론
    템플릿 구조로면 CSS 변수로 런타임 테마 변경 + TypeScript로 안전하게 관리 수정할 수 있고, UI 스위치 제공까지 다 커버 가능하다는 거 같음 Next.js 자체가 모듈 단위로 찢어서 하나씩 만들어서 관리하는거라고 했으니까, CSS도 비슷하게 생각하면 될듯

## Internationalization (i18n)
  - 기본 개념
    - 라이브러리 : `next-intl` 사용
    - 구성 : 두 가지 방식 제공
      - 1. Without i18n Routing(기본) -> URL 구조 변경 없음 (`/about`)
      - 2. With i18n Routing -> 언어 prefix/domain 기반 (`/en/about`, `en.example.com`)
    - 네비게이션 번역 활성화 
      - `src/configs/app.config.ts`
      ```ts
      export type AppConfig = {
          apiPrefix: string
          authenticatedEntryPath: string
          unAuthenticatedEntryPath: string
          locale: string
          activeNavTranslation: boolean
      }

      const appConfig: AppConfig = {
          apiPrefix: '/api',
          authenticatedEntryPath: '/home',
          unAuthenticatedEntryPath: '/sign-in',
          locale: 'en',
          activeNavTranslation: false,
      }

      export default appConfig
      ```
    - Without i18n Routing (기본)
      - messages 폴더 구조
      ```pgsql
      messages/
      ├── en.json
      ├── es.json
      └── fr.json
      ```
    - 번역 JSON 예시
    ```json
    // messages/en.json
    { "title": "Home" }

    // messages/es.json
    { "title": "Inicio" }
    ```
  - 루트 레이아웃에 Provider 적용 (`src/app/layout.tsx`)
  ```tsx
  import LocaleProvider from "@/components/template/LocaleProvider"
  import { getLocale, getMessages } from "next-intl/server"

  export default async function RootLayout({ children }: { children: ReactNode }) {
    const locale = await getLocale()
    const messages = await getMessages()

    return (
      <html suppressHydrationWarning>
        <body suppressHydrationWarning>
          <LocaleProvider locale={locale} messages={messages}>
            <ThemeProvider locale={locale} theme={theme}>
              {children}
            </ThemeProvider>
          </LocaleProvider>
        </body>
      </html>
    )
  }
  ```
  - 컴포넌트에서 번역 사용
  ```tsx
  import { useTranslations } from "next-intl"

  export default function HomePage() {
    const t = useTranslations()
    return <h1>{t("title")}</h1>
  }
  ```
  - With i18n Routing
    - 언어별 경로 사용 가능
      - Prefix: `/en/about`, `fr/about`
      - Domain: `en.example.com`
    - 구조와 설정이 더 복잡함 -> 공식 문서 참고랑 구글링 해봐야할듯
  - 언어 변경 (Without i19n Routing)
    - `userTranslation`의 i18n 객체 활용
    - 서버 액션 `setLocale` 호출 예시
    ```tsx
    'use client'

    import { setLocale } from '@/server/actions/locale'

    const Component = () => {
      const handleUpdateLocale = async (locale: string) => {
        await setLocale(locale)
      }

      return (
        <button onClick={() => handleUpdateLocale('fr')}>
          Change language
        </button>
      )
    }

    export default Component
    ```
  - 기본 언어 설정
    - `src/configs/app.config.ts`
    ```ts
    export const appConfig: AppConfig = {
        ...
        locale: 'fr'
    }
    ```
  - 새로운 언어 추가
    - 1. message 폴더에 JSON 생성
    ```json
    // messages/fr.json
    {
      "HomePage": {
        "title": "Bonjour le monde!",
        "about": "Aller à la page à propos"
      }
    }
    ```
    - 2. `src/i18n/dateLocales.ts`에 등록
    ```ts
    export const dateLocales: {
      [key: string]: () => Promise<ILocale>
    } = {
      ...
      fr: () => import('dayjs/locale/fr'),
    }
    ```
    - 3. (i18n Routing 사용 시) -> 라우팅 설정 & middleware에도 추가 필요
  ### 결론
    간단하게 사용하는건 Without i18n Routing -> message JSON 관리 + Provider 래핑 이고, 글로벌 서비스면 With i18n Routing 경로 기반에 다국어 URL 셋팅을 해서 쓰는것 같음 내가 했던건 설정에서 언어 설정에서 선택된 언어로 전면 바꾸는건데, 아예 언어를 셋팅해서 관리하면 더 편할듯

## Dark / Light Mode
  - 초기 모드 설정
    - `src/configs/theme.config.ts` 에서 `mode` 필드 값 지정
    ```ts
    export const themeConfig = {
        ...
        mode: 'dark' // or 'light'
        // Demo - mode: THEME_ENUM.MODE_LIGHT,
    }
    ```
  - Hook 사용
    - `userTheme` 훅으로 현재 모드 가져오기 + 업데이트 기능
    - `Switcher` UI 컴포넌트와 연결해서 토글 구현
    ```tsx
    'use client'

    import useTheme from '@/utils/hooks/useTheme'
    import Switcher from '@/components/ui/Switcher'

    const ModeSwitcher = () => {
        const mode = useTheme((state) => state.mode)
        const setMode = useTheme((state) => state.setMode)

        const onSwitchChange = (checked: boolean) => {
            setMode(checked ? 'dark' : 'light')
        }
        
        return (
            <div>
                <Switcher
                    defaultChecked={mode === 'dark'}
                    onChange={onSwitchChange}
                />
            </div>
        )
    }

    export default ModeSwitcher
    ```
    - 동작 방식
      - `Switcher`에서 true/false를 받아 -> `userTheme`의 `setMode` 호출
      - `mode`값이 `dark`로 바뀌면 `body` 나 `html`에 `.dark` 클래스 적용됨
      - CSS 변수 (`--primary`, `--neutral` 등) 값도 `.dark`에서 정의된 값으로 자동 전환됨
  ### 결론
    theme.config.ts 가 뭐 거의 모든 초기설정을 물고 있는거같고, userTheme 훅이랑 Switcher로 런타임 다크/라이트 전환 가능하고, 기존에 CSS 구조 덕분에 모든게 다 색상이랑 스타일이 맞춰지는것 같음 와 이거 UI 담당자분들 개머리 아프겠네...

## Direction
  - 전역 기본값
    - 위치 : `src/configs/theme.config.ts`
    - 기본값
    ```ts
    export const themeConfig = {
      ...
      direction: 'ltr', // 기본 Left-to-Right
    }

    // theme.config.ts
    import { THEME_ENUM } from '@/constants/theme.constant'
    import type { Theme } from '@/@types/theme'

    /**
    * Since some configurations need to be match with specific themes,
    * we recommend to use the configuration that generated from demo.
    */
    export const themeConfig: Theme = {
        themeSchema: '',
        direction: THEME_ENUM.DIR_LTR,
        mode: THEME_ENUM.MODE_LIGHT,
        panelExpand: false,
        controlSize: 'md',
        layout: {
            type: THEME_ENUM.LAYOUT_COLLAPSIBLE_SIDE,
            sideNavCollapse: false,
        },
    }
    ```
    - `rtl`로 바꾸면 전체 앱이 오른쪽에서 왼쪽으로 UI가 뒤집혀서 렌더링됨.
  - 컴포넌트에서 접근/제어
    - `usetheme` 훅 사용
    ```tsx
    const direction = useTheme((state) => state.direction)       // 현재 방향
    const setDirection = useTheme((state) => state.setDirection) // 방향 변경 함수
    ```
  - DirectionSwitcher 컴포넌트
    - 버튼 클릭으로 방향 전환 가능
    ```tsx
    'use client'

    import Button from '@/components/ui/Button'
    import InputGroup from '@/components/ui/InputGroup'
    import useTheme from '@/utils/hooks/useTheme'
    import { THEME_ENUM } from '@/constants/theme.constant'
    import type { Direction } from '@/@types/theme'

    const dirList = [
      { value: THEME_ENUM.DIR_LTR, label: 'LTR' },
      { value: THEME_ENUM.DIR_RTL, label: 'RTL' },
    ]

    const DirectionSwitcher = () => {
      // 여기 부분
      const direction = useTheme((state) => state.direction)
      const setDirection = useTheme((state) => state.setDirection)
      
      const onDirChange = (val: Direction) => setDirection(val)
      // !여기 부분

      return (
        <InputGroup size="sm">
          {dirList.map((dir) => (
            <Button
              key={dir.value}
              active={direction === dir.value}
              onClick={() => onDirChange(dir.value)}
            >
              {dir.label}
            </Button>
          ))}
        </InputGroup>
      )
    }

    export default DirectionSwitcher
    ```
  ### 결론
   기존에 프로젝트에서는 아예 Left 메뉴바를 호출해서 import 하는 형식으로 사용했는데, 여기는 theme 자체에 왼쪽, 오른쪽을 지정해서 전체 툴을 사용할 수 있고, 해당 페이지에서 컴포넌트에서 원하는 메뉴바 형식으로 호출이 가능한것 같음. 확실히 엄청 편해보임

## Overall Theme Config
  - 위치 : `src/configs/theme.config.ts`
  - 템플릿의 기본 테마 설정 관리
  - 모든 값은 커스터마이징 가능하며, `useTheme` 훅으로 제어 가능
    - 이건 ts에서 개발하는 훅으로 다 건들수 있다 이런거인듯
  - 변경했는데 적용이 안되면 쿠키에 저장된 theme 키 삭제 필요
    - 아 여기도 쿠키랑 캐시 이슈가 있나보네
  ```ts
  import { THEME_ENUM } from '@/constants/theme.constant'
  import {
      Direction,
      Mode,
      ControlSize,
      LayoutType,
  } from '@/@types/theme'

  export type ThemeConfig = {
      themeSchema: string
      direction: Direction
      mode: Mode
      panelExpand: boolean
      controlSize: ControlSize
      layout: {
          type: LayoutType
          sideNavCollapse: boolean
      }
  }

  export const themeConfig: ThemeConfig = {
      themeSchema: '',
      direction: THEME_ENUM.DIR_LTR,
      mode: THEME_ENUM.MODE_LIGHT,
      panelExpand: false,
      controlSize: 'md',
      layout: {
          type: THEME_ENUM.LAYOUT_COLLAPSIBLE_SIDE,
          sideNavCollapse: false,
      },
  }
  ```
  - Configuration Properties
    - themeSchema 
      - 컬러 스키마 지정 (동적 테마 사용시 비움)
    - direction
      - 텍스트 방향
    - mode
      - 라이트/다크 모드 전환
    - panelExpand
      - 사이드 패널 기본 확정 여부
    - controlSize
      - 입력/컨트롤 기본 크기
    - layout.type
      - 앱 전체 레이아웃 스타일
    - layout.sideNavCollapse
      - 사이드 내비게이션 기본 접힘 여부
  - State Persistence
    - 테마 설정은 쿠키에 저장됨
    - 단, `usetheme` 훅을 통해 변경했을 때만 쿠키에 반영됨
    - 기본값은 항상 `theme.config.ts`에서 불러옴
  ### 결론
    결국에 configs 폴더에는 정말 앱에 모든 설정들과 기본설정 파일들이 다 들어있는것 같음. 문서를 계속 천천히 분석하고 있지만, 결론은적으로 기본 설정은 configs 폴더안에서 가져오고, 페이지 자체에서 훅으로 필요하면 쿠키에 저장되서 별로도 사용하는것 같음. 테마 뿐만이 아니라 모든 기능이나 페이지가 동일되게 돌아가는것 같음. 오;;;

## Build Production
  - 준비 단계 (Preparing for Deployment)
    - 환경 변수 확인
      - `.env`에 API 키, DB URL, Secret 값이 제대로 설정되어 있어야함
      - 운영/개발 분리 (`.env.production`, `.env.local` 등)
    - 프로덕션 빌드
    ```bash
    npm run build
    ```
      - 최적화된 프로덕션 빌드 생성
    - 로컬 테스트
    ```bash
    npm run start
    ```
      - 실제 운영 모드와 동일하게 실행해서 문제 없는지 확인
  - Vercel 배포
    - Next.js의 공식 호스팅 파트너  
      - 클릭 몇번이면 끝남
      - 1. Vercel 로그인 & Git 연동
        - GitHub/GitLab/Bitbucker 연결 -> 레포 선택
      - 2. Build 설정
        - Framework : Next.js
        - Build Command : `npm run build`
        - OutPut Directory : 기본값
      - 3. 환경 변수 설정
        - Vercel Dashboard 에서 직접 추가
        - `NEXT_PUBLICK_` 접두사 여부 확인
      - 4. 배포 실행
        - `DDeploy` 버튼 클릭
          - Vercel이 자동으로 빌드/배포
    - CI/CD 자동화
    - 도메인 연결 쉬움
    - Preview Deploy 제공
  - 커스텀 호스팅 (VPS, 자체 서버 등)
    - Vercel 대신 서버 직접 쓸 경우
      - 1. 서버에 Node.js 설치
        - 운영 서버 Node.js 버전 = 로컬 개발 버전 맞추기
      - 2. 프로덕션 빌드
        ```bash
        npm run build
        ```
      - 3. 앱 실행
        ```bash
        npm run start
        ```
        - 기본 포트 3000 에서 서비스 됨.
      - 4. 프로세스 매니저 사용 (추천)
        - pm2
          ```bash
          pm2 start npm --name "project-name" -- run start
          pm2 startup
          pm2 save
          ```
        - Docker (옵션)
          - Dockerfile 생성
            - `docker build` & `docker run`
  ### 결론
  개인 프로젝트/포폴은 Vercel 배포가 제일 빠르고 편한것 같음. 실무에서는 자체서버가 있을테니까, Docker 기반 배포가 일반적이니까, 운영서버에 docker 설치하고 개발 PC에서 패키징하고 운영서버에 옮겨서 패키징 풀고 도커에 올리고 k8s로 하잇하잇 하면 될것 같은데 음...

### Document 문서 마무리
  ```
  기존에도 여러 템플릿과 현업에서 문서화진행이나 타 프로젝트의 인수인계 문서를 볼 기회가 많았는데, 확실히 공식 템플릿의 문서는 퀄리티나 설명도 많이 다르다 라는걸 느낌.
  처음 사용해보고, 실제 Demo 디렉토리를 참조하면서 전체 구조를 이해하는데 큰 도움이 된것 같고, 확실히 디렉토리 구조가 정규화 되어있으면서 config 파일이 굉장히 많고 한 페이지를 작성할때 생각보다 신경써야할 부분이 굉장히 많고, 편의성은 증대 되고, 컴포넌트 형식이기 때문에 기존에 개발할때는 한 페이지에 집중했다면, 컴포넌트 하나에 큰 틀과 구조를 파악하고 거기에서 어떤것을 파생시켜야할지, 어떤식으로 훅을 넣어야할지 조금은 다르게 생각을 하면서 개발을 해야겠다는 생각이 듦. 
  배포역시 war 형식으로 톰캣이 뿌리는 형식이였다면, 이제는 패키징을 하고 운영서버에 Docker 등으로 배포해야 하기 때문에 빌드 와 배포까지 아키텍쳐를 생각하면서 해야하지 않을까 라는 직감이 옴.
  다행히 포유잡 아키텍쳐 구성과 문서를 작성하면서 많은 스킬업이 되긴 했지만, 전혀 다르기 때문에...
  처음부터 잘하는 사람은 없으니까, 어색하고 무서운건 사실이지만.... 시간이 해결해줄 문제고, 적극적이게 모든걸 해보는게 지금 해결방법이지 않을깡
  ```
  