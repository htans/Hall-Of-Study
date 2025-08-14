# Next.js
## 정의
- React 기반의 프레임워크 (React 위에서 동작하는 상위 레벨 도구)

## 특징
- 서버사이드 렌더링(SSR) 지원
    - SEO(검색 최적화)와 초기 로딩속도 개선
        - 기존 방식 (React + CSR)
        ``` jsx
        // App.jsx
        import React, { useEffect, useState } from 'react';

        function App() {
        const [message, setMessage] = useState('');

        useEffect(() => {
            fetch('/api/message')
            .then(res => res.json())
            .then(data => setMessage(data.message));
        }, []);

        return (
            <div>
            <h1>CSR 예시</h1>
            <p>{message}</p>
            </div>
        );
        }

        export default App;
        ```
        - message는 js가 실행되고나서야 보임
        - 검색 엔진은 호라락 하고 나가서 안가져갈수도 있음
        - 인터넷이 느리면 검색엔진은 물론이고, 사용자도 로딩속도가 느림
        ---
        - 개선된 방식 (Next.js + SSR)
        ```tsx
        // pages/index.tsx
        import React from 'react';

        type Props = {
        message: string;
        };

        const Home = ({ message }: Props) => {
        return (
            <div>
            <h1>SSR 예시</h1>
            <p>{message}</p>
            </div>
        );
        };

        export async function getServerSideProps() {
        const res = await fetch('https://your-api.com/message');
        const data = await res.json();

        return {
            props: {
            message: data.message,
            },
        };
        }

        export default Home;
        ```
        - 서버가 완성된 HTML 을 전달하기 때문에 한방에 다 가져갈 수 있음
        - 검색엔진, 사용자에게 빠르게 전달가능
            - 주로 리스트 화면에서 사용
    - 정적 사이트 생성(SSG), 하이브리드 렌더링 가능.
        - 정적 사이트 생성(SSG)
            - 똑같이 서버에서 완성된 HTML을 주기 때문에 가능
                - 주로 회사소개, 설명화면 같은 정적인 화면에 사용
        - 하이브리드 렌더링 기능
            - 화면별로 SSR, SSG, CSR을 지정해서 유연하게 장단점을 지정할 수 있음 
                - SSR 
                    - Server Side Rendering
                    - 사용자마다 다른 데이터를 보여줄때, 뉴스 페이지, 실시간 통계 화면이 주로 지정됨
                - SSG 
                    - Static Site Generation
                    - 정적인 상세페이지, 회사소개 화면이 주로 지정됨
                - CSR
                    - Client Side Rendering
                    - ㄹㅇ js동작이 필요한 장바구니, 관리자 페이지, 마이페이지 화면이 주로 지정됨
    - 파일 기반 라우팅 
        - pages/ 폴더에 파일만 만들면 URL 자동 생성.
        - 포유잡에서는 매번 컨트롤러 만들어주고 화면 연결시키고 했는데, 그냥 넣어만 두면 알아서 뽁뽁감
        - 사진은 경로이동이 원래 가능했지만, 이건 페이지 자체에 라우팅이니까 전혀다름
    - API Routes
        - 간단한 백엔드 API도 같이 구현 가능.
        - 조회, 수정, 등록, 삭제 다 가능
            - DB 트랜잭션, 인증/인가 기능, 대규모 비지니스, 실시간 처리는 딱 봐도 하면 큰일날거같은 기능들은 넘어가면 안됨;
            - 프로젝트 자체에 DB 사용자 정보가 저장되어 있으니까, 제한된 권한이 있을테니 어차피 못함 ㅋ;

## 왜 쓰지?
- 순수 React 보다 SEO 친화적이고, 프로젝트 구조랑 빌드/배포가 체계적임
    - 블로그, 포트폴리오, 대시보드 같은 서비스에서 SEO가 필요한 경우 필수
