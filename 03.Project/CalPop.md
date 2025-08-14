# 📘 Cal Pop - 일정 알림 메모 서비스

## 📎 프로젝트 개요
- **목적**: 매일 사용하는 메모에 일정 알림 기능을 붙여 생산성을 높이는 도구
- **대상**: 일정 관리를 간편하게 하고 싶은 개인 사용자
- **기획 배경**: 단순 메모 앱을 넘어서, 알림까지 가능한 경량형 일정 툴

---

## 🏗️ 기술 스택

| 영역 | 스택 |
|------|------|
| 프론트엔드 | React, Next.js, TypeScript |
| 백엔드 | Node.js |
| 운영/배포 | Docker, Kubernetes |
| 메시징 시스템 | Kafka |
| 데이터베이스 | MongoDB |
| 외부 API | Kakao Open API (알림 전송용) |

---

## 🎯 주요 기능

- 메모 작성 및 등록 (MongoDB 저장)
- 카카오톡 알림 전송 (등록 시점 + 예약 알림)
- 일정 기준 푸시 알림:
  - 등록 시
  - 1달 전
  - 3일 전
  - 1일 전
  - 당일 아침

---

## ⚙️ 시스템 아키텍처 (요약)

```txt
사용자 → React/Next.js → Node.js API → MongoDB 저장
                                ↓
                Kafka Producer: 알림 스케줄 요청
                                ↓
                Kafka Consumer: 예약된 알림 처리
                                ↓
                  Kakao API → 푸시 알림 전송
