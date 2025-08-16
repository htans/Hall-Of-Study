# Dev
템플릿 URL: https://preview.themeforest.net/item/ecme-nextjs-tailwind-admin-template-app-router/full_screen_preview/56475600  

Next.js + Tailwind 기반 Admin Template.  
Starter 버전을 기반으로 커스터마이징하여 CalPop 프로젝트 개발

하나씩 공부하면서 하는게 맞는데, 나한테는 프로젝트를 실제 개발하면서 필요한 부분을 공부하는것이 나한테 맞는 케이스 같아서 이렇게함 ㅋ;

---

## 템플릿 
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
      - messages/
        - 다국어 지원 메세지 JSON 파일 모음
      - public/
        - 정적파일 
          - 필드시 그대로 배포됨
      - scr/
        - 앱의 핵심 코드
          - @types/
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
          - app/
            - Next.js App Router 메인 부분
