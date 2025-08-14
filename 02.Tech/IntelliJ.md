
# IntellliJ
## Next.js 기반 신규 프로젝트 디렉토리
```
CalPop/
 ├─ .idea/                          // IntelliJ 프로젝트 설정 (형은 이건 건들 일 거의 없음)
 ├─ calpop/                         // 실제 프로젝트 루트 폴더
 │   ├─ .next/                      // Next.js가 빌드하면서 생성하는 캐시/결과물 (자동 생성, 수정 X)
 │   ├─ node_modules                // 설치된 npm 패키지들 (자동 생성, 수정 X)
 │   ├─ public/                     // 정적 파일(이미지, 폰트, svg 등) 위치
 │   ├─ src/                        // 소스코드 (우리가 실제로 개발하는 부분)
 │   │   └─ app/                    // Next.js 13+ App Router 폴더
 │   │       ├─ globals.css         // 전역 스타일
 │   │       ├─ layout.tsx          // 공통 레이아웃 (header/footer 등)
 │   │       └─ page.tsx            // 기본 "/" 경로 페이지
 │   ├─ package.json                // 프로젝트 의존성, 스크립트 정의
 │   ├─ tsconfig.json               // TypeScript 설정
 │   ├─ next.config.ts              // Next.js 설정
 │   └─ ...기타 설정파일
 ```

## 주요 폴더 및 파일 역할
- 📁 .next/
    - Next.js가 빌드할 때 자동으로 생성하는 폴더.
    - 빌드된 HTML, JS, CSS 캐시가 들어있음.
    - 절대 직접 수정하지 않고, .gitignore에 포함되어 보통 Git에 안 올림.

- 📁 node_modules/
    - npm install로 설치된 모든 라이브러리.
    - 용량이 크고 자동 관리됨 → 직접 수정 X.

- 📁 public/
    - 정적 파일 저장소.
    - /public/file.svg → 브라우저에서 /file.svg로 접근 가능.
    - favicon, 이미지, 아이콘 파일 등을 여기에 두면 빌드에 포함됨.

- 📁 src/app/
    - Next.js 13+ App Router의 핵심.
    - 여기에 있는 폴더/파일이 라우트가 됨.
        - app/page.tsx → /
        - app/about/page.tsx → /about
        - app/post/[id]/page.tsx → /post/123 (동적 라우팅)
        - layout.tsx는 공통 레이아웃, globals.css는 전역 스타일.

- 📄 globals.css
    - Tailwind CSS 초기화, 폰트, 색상 등 전역 스타일 정의.
    - 모든 페이지에 자동 적용

- 📄 layout.tsx
    - 모든 페이지에서 공통으로 쓰이는 틀 (header, footer, meta 태그 등).
    - App Router에서는 필수.
        - 전체 화면 규격틀

- 📄 page.tsx
    - 실제 페이지 컴포넌트. 여기서 JSX/TSX 문법으로 화면 구성.

## .tsx 확장자? 
- .ts = TypeScript (JS + 타입 검사)
- .tsx = TypeScript + JSX (React 문법을 같이 사용)
- 화면을 그리는 React 컴포넌트를 TypeScript로 작성할 때 .tsx를 사용

```tsx
// page.tsx 예시
export default function Home() {
  return <h1>Hello Next.js!</h1>;
}
```

## layout.tsx 가 규격틀인데, 각 페이지 별로 다른 layout.tsx를 사용할 수 있나?
- layout.tsx 는 같은 디렉토리나 상위 디렉토리에 있는 layout이 자동적용
```tsx
app/
 ├─ layout.tsx              // 기본 레이아웃 (ex: 메인 사이트)
 ├─ page.tsx                // 홈 페이지
 ├─ about/
 │   ├─ page.tsx
 │   └─ layout.tsx          // about 전용 레이아웃
 ├─ dashboard/
 │   ├─ page.tsx
 │   └─ layout.tsx          // dashboard 전용 레이아웃
```
- 이런식으로 규격별로 디렉토리 관리 되어야함

