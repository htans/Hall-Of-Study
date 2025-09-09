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
        // React 관련 import (기본 JSX 지원을 위해 필요)
        import React from 'react'

        // [RF-AUTH] /home 레이아웃 (인증 로직 없음)
        // 설명: 이 파일은 /home 이하 페이지를 PostLoginLayout(레이아웃/네비 스킨)으로 감싼다.
        // 실제 인증 가드는 middleware.ts 또는 상위(서버) 레이아웃/가드에서 수행된다.
        import PostLoginLayout from '@/components/layouts/PostLoginLayout'

        // ReactNode 타입: children 으로 어떤 React 요소든 받을 수 있게 타입 정의
        import { ReactNode } from 'react'
        
        const Layout = async ({ children }: { children: ReactNode }) => {
            return <PostLoginLayout>{children}</PostLoginLayout>
        }

        export default Layout
        ```
        - 그럼 아예 처음에 랜딩페이지에서 하지 않을까?? 인증관련도 섞여일을텐데 Next.js가 이렇게 꽁꽁 일리가 없는데??
        ```tsx
        // layout.tsx

        // import auth.ts 
        import { auth } from '@/auth' 
        
        import AuthProvider from '@/components/auth/AuthProvider'
        import ThemeProvider from '@/components/template/Theme/ThemeProvider'
        import pageMetaConfig from '@/configs/page-meta.config'
        import NavigationProvider from '@/components/template/Navigation/NavigationProvider'
        import { getNavigation } from '@/server/actions/navigation/getNavigation'
        import { getTheme } from '@/server/actions/theme'
        import type { ReactNode } from 'react'
        import '@/assets/styles/app.css'

        export const metadata = {
            ...pageMetaConfig,
        }

        export default async function RootLayout({
            children,
        }: Readonly<{
            children: ReactNode
        }>) {
            const session = await auth()
            const navigationTree = await getNavigation()
            const theme = await getTheme()

            return (
                <AuthProvider session={session}>
                    <html
                        className={theme.mode === 'dark' ? 'dark' : 'light'}
                        dir={theme.direction}
                        suppressHydrationWarning
                    >
                        <body suppressHydrationWarning>
                            <ThemeProvider theme={theme}>
                                <NavigationProvider navigationTree={navigationTree}>
                                    {children}
                                </NavigationProvider>
                            </ThemeProvider>
                        </body>
                    </html>
                </AuthProvider>
            )
        }
        ```
        - `import { auth } from '@/auth'` 가 있긴한데, 이건 NextAuth에서 섹션 가져오는 전용 함수
        - `@/auth` 가 인증관련 라이브러리 이니까, 여기를 탐구해봐야겠음
        ```tsx
        // @auth/core/src/index.js

        console.log("STEP 1 ::: ");

        export async function Auth(request, config) {
            const logger = setLogger(config);
            const internalRequest = await toInternalRequest(request, config);

            console.log("STEP 2 ::: ");

            // There was an error parsing the request
            if (!internalRequest)
                return Response.json(`Bad request.`, { status: 400 });
            const warningsOrError = assertConfig(internalRequest, config);
            if (Array.isArray(warningsOrError)) {
                warningsOrError.forEach(logger.warn);
            }
            else if (warningsOrError) {
                // If there's an error in the user config, bail out early
                logger.error(warningsOrError);
                const htmlPages = new Set([
                    "signin",
                    "signout",
                    "error",
                    "verify-request",
                ]);
                if (!htmlPages.has(internalRequest.action) ||
                    internalRequest.method !== "GET") {
                    const message = "There was a problem with the server configuration. Check the server logs for more information.";
                    return Response.json({ message }, { status: 500 });
                }
                const { pages, theme } = config;
                // If this is true, the config required auth on the error page
                // which could cause a redirect loop
                const authOnErrorPage = pages?.error &&
                    internalRequest.url.searchParams
                        .get("callbackUrl")
                        ?.startsWith(pages.error);
                // Either there was no error page configured or the configured one contains infinite redirects
                if (!pages?.error || authOnErrorPage) {
                    if (authOnErrorPage) {
                        logger.error(new ErrorPageLoop(`The error page ${pages?.error} should not require authentication`));
                    }
                    const page = renderPage({ theme }).error("Configuration");
                    return toResponse(page);
                }
                const url = `${internalRequest.url.origin}${pages.error}?error=Configuration`;

                return Response.redirect(url);
            }

            const isRedirect = request.headers?.has("X-Auth-Return-Redirect");
            const isRaw = config.raw === raw;
            try {

                console.log("STEP 4 ::: before AuthInternal");
                const internalResponse = await AuthInternal(internalRequest, config);
                console.log("STEP 4 ::: after AuthInternal");

                if (isRaw)
                    return internalResponse;
                const response = toResponse(internalResponse);
                const url = response.headers.get("Location");

                if (!isRedirect || !url)

                    console.log("STEP 5 ::: return response");
                    console.log("response : " + response);
                    // 해당 사용자는 인증된 사용자도 아니기 때문에, 보낼 URL이 없다! 라고 response 로 던짐

                    return response;
                return Response.json({ url }, { headers: response.headers });
            }
            catch (e) {

                const error = e;
                logger.error(error);
                const isAuthError = error instanceof AuthError;
                if (isAuthError && isRaw && !isRedirect)
                    throw error;
                // If the CSRF check failed for POST/session, return a 400 status code.
                // We should not redirect to a page as this is an API route
                if (request.method === "POST" && internalRequest.action === "session")
                    return Response.json(null, { status: 400 });
                const isClientSafeErrorType = isClientError(error);
                const type = isClientSafeErrorType ? error.type : "Configuration";
                const params = new URLSearchParams({ error: type });
                if (error instanceof CredentialsSignin)
                    params.set("code", error.code);
                const pageKind = (isAuthError && error.kind) || "error";
                const pagePath = config.pages?.[pageKind] ?? `${config.basePath}/${pageKind.toLowerCase()}`;
                const url = `${internalRequest.url.origin}${pagePath}?${params}`;
                if (isRedirect)
                    return Response.json({ url });

                return Response.redirect(url);
            }
        }
        ```
        - 결국에 @auth 에서는 이 사용자는 인증된 사용자도 아니니까, URL로 없어! 라고 뱉어버리고 그걸 미들웨어에서 `sign-in`으로 뱉어버리는거같은데
        ```ts
        import NextAuth from 'next-auth'

        import authConfig from '@/configs/auth.config' // 인증 라이브러리 설정
        import {
            authRoutes as _authRoutes, // 인증 관련 경로 목록
            publicRoutes as _publicRoutes, // 공개 경로 목록
        } from '@/configs/routes.config'
        import { REDIRECT_URL_KEY } from '@/constants/app.constant' // 리다이렉트 쿼리 키 이름
        import appConfig from '@/configs/app.config' // 앱 설정 (로그인/비로그인 진입 경로 등)

        const { auth } = NextAuth(authConfig) // NextAuth 미들웨어 함수 추출

        // 공개 및 인증 경로에서 경로(pathname)만 배열로 추출
        const publicRoutes = Object.entries(_publicRoutes).map(([key]) => key)
        const authRoutes = Object.entries(_authRoutes).map(([key]) => key)

        // API 인증 경로 접두어 (예: '/api/auth')
        const apiAuthPrefix = `${appConfig.apiPrefix}/auth`

        // 미들웨어 기본 함수: 요청 객체 받음
        export default auth((req) => {
            const { nextUrl } = req // 요청의 URL 정보 추출
            const isSignedIn = !!req.auth // 인증 여부 판단 (로그인 시 req.auth가 있음)

            // API 인증 경로인지 확인 (ex. /api/auth/*)
            const isApiAuthRoute = nextUrl.pathname.startsWith(apiAuthPrefix)
            // 공개 경로인지 판별 (회원가입, 로그인 등)
            const isPublicRoute = publicRoutes.includes(nextUrl.pathname)
            // 인증 전용 경로인지 판별 (예: 로그인 페이지 등)
            const isAuthRoute = authRoutes.includes(nextUrl.pathname)

            /** API 인증 경로는 미들웨어 적용 안 함 (인증 자체가 API에서 처리되므로) */
            if (isApiAuthRoute) return

            // 여기서 요청한 nextUrl이 나옴
            console.log("nextUrl : " + nextUrl);
            // nextUrl : http://localhost:3000/sign-in?redirectUrl=%2F 찾았다 이놈
            
            /** 
            * 인증 전용 경로(로그인, 회원가입 페이지 등)에 로그인 상태로 접근 시
            * 이미 로그인했으므로 인증 성공 진입 경로로 리다이렉트
            */
            if (isAuthRoute) {
                if (isSignedIn) {
                    return Response.redirect(
                        new URL(appConfig.authenticatedEntryPath, nextUrl), // 예: /home
                    )
                }
                return // 로그인 안 됐으면 인증 경로 접근 허용 (로그인 페이지 보여줌)
            }

            /** 
            * 로그인하지 않은 사용자가 비공개 페이지 접근 시
            * 로그인 페이지로 리다이렉트하면서 원래 요청 경로를 쿼리로 전달
            */
            if (!isSignedIn && !isPublicRoute) {
                // 원래 요청 경로 + 쿼리 문자열을 callbackUrl 변수로 저장
                let callbackUrl = nextUrl.pathname
                if (nextUrl.search) {
                    callbackUrl += nextUrl.search
                }

                // 로그인 페이지로 리다이렉트 (예: /sign-in?redirectUrl=원래경로)
                return Response.redirect(
                    new URL(
                        `${appConfig.unAuthenticatedEntryPath}?${REDIRECT_URL_KEY}=${callbackUrl}`,
                        nextUrl,
                    ),
                )
            }

            /** 
            * (주석 처리됨) 역할 기반 접근 제어 예시
            * 로그인 상태이며 접근 권한 없는 경우에는
            * /access-denied 페이지로 리다이렉트 처리
            */
            // if (isSignedIn && nextUrl.pathname !== '/access-denied') {
            //     const routeMeta = protectedRoutes[nextUrl.pathname]
            //     const includedRole = routeMeta?.authority.some((role) => req.auth?.user?.authority.includes(role))
            //     if (!includedRole) {
            //         return Response.redirect(
            //             new URL('/access-denied', nextUrl),
            //         )
            //     }
            // }
        })

        // 이 미들웨어가 적용될 경로 설정
        export const config = {
            matcher: ['/((?!.+\\.[\\w]+$|_next).*)', '/', '/(api)(.*)'],
            // 설명:
            //  - 정적 파일이나 _next 내부 리소스를 제외
            //  - 루트 경로('/') 포함
            //  - /api 경로 및 그 하위도 포함
        }
        ```
        - 해당 요청값으로 `nextUrl : http://localhost:3000/sign-in?redirectUrl=%2F` 이렇게 나오는데, 이는 `@auth` 에서 `Null`로 뱉었으니까, 인증된 사용자가 아니니까! 리다이렉트할 URL도 없어! 하니까 미들웨어가 ㅇㅇㅇ ㅇㅋ 그럼 app.config.ts에 선언되어 있는 `unAuthenticatedEntryPath : /sign-in` 으로 떤진다!! 
        - ㄹㅇ 이 리다이렉트 문구 하나 찾을려고 일주일 걸렸음... ㅠㅠ.... ㅋㅋㅋㅋㅋㅋㅋ
        - 그래도 이 구조 자체가 일반적인 `Next.js + 인증 라이브러리 조합에서 권장되는 인증 처리 방식` 이라는거네 
            - 개쩐다