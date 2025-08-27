# Dev
React 기반의 Next.js 프로젝트 이기 때문에 개발하는것도 중요하지만, 다 똑같지는 않겠지만, Next.js는 정규화된 디렉토리가 존재하고 템플릿 디렉토리는 그걸 완벽하게 지키면서 UI를 개발해놓음
간단한 기능들 및 Mock 폴더로 되어있지만, 데이터 호출까지 붙어있기 때문에 이해하는데 편하겠지만, 처음 경험해보는 기술스택이기 때문에 궁금하고 이해안되는게 많을거같아서 부분부분을 기록하면서 쭉 해봐야겠음

---

## 개발 이슈
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

```tsx

```