<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-%3E%3D%205.5.0-blue">
  <img alt="node" src="https://img.shields.io/badge/node-%3E%3D%209.3.0-blue">
  <a href="https://edu.nextstep.camp/c/R89PYi5H" alt="nextstep atdd">
    <img alt="Website" src="https://img.shields.io/website?url=https%3A%2F%2Fedu.nextstep.camp%2Fc%2FR89PYi5H">
  </a>
  <img alt="GitHub" src="https://img.shields.io/github/license/next-step/atdd-subway-service">
</p>

<br>

# 인프라공방 샘플 서비스 - 지하철 노선도

<br>

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew clean build
```
<br>

## 미션

* 미션 진행 후에 아래 질문의 답을 작성하여 PR을 보내주세요.


### 1단계 - 화면 응답 개선하기
####  목표 설정
- latency : 100ms 이하
- throughput
    - MAU : 583만 ( 카카오맵 MAU(729만) 대비 80%로 설정 )
    - DAU : 19.4만
    - 1명당 1일 평균 접속 수 : 2회 (출/퇴근시 접속으로 가정)
    - 1일 총 접속 수 : 38.8만
    - 1일 평균 rps : 38.8만/86400 = 4.49
    - 1일 최대 rps : 4.49 * 6 = 26.94
- 부하 유지기간
    - smoke : 1m
    - load : 25m
    - stress : 4.2m
- VUser
    - 요청수 : 4회 (메인, 로그인페이지, 로그인 요청, 검색)
    - T : 4 * 0.2s + 1s =  1.8s
    - 최대 VUser : (26.94 * 1.8) / 4 = 12.12
    - 최소 VUser : (4.49 * 1.8) / 4 = 2.02
- 부하 테스트 시 저장될 데이터 건수 및 크기
    - 조회
        - 노선 : 23개
        - 구간 : 340개
    - 역 : 616개
    - 사용자 : 1개
  
1. 성능 개선 결과를 공유해주세요 (Smoke, Load, Stress 테스트 결과)
- 스크립트
  - scenario/script
- 결과
  - 개선 전 : scenario/before
  - reverse proxy 개선 : scenario/reverse_proxy
  - redis cache : scenario/WAS

2. 어떤 부분을 개선해보셨나요? 과정을 설명해주세요
- nginx gzip 적용
- TLS, HTTP/2 설정
- nginx cache 압축 적용
- redis 적용

---

### 2단계 - 스케일 아웃

1. Launch Template 링크를 공유해주세요.

2. cpu 부하 실행 후 EC2 추가생성 결과를 공유해주세요. (Cloudwatch 캡쳐)

```sh
$ stress -c 2
```

3. 성능 개선 결과를 공유해주세요 (Smoke, Load, Stress 테스트 결과)

---
### [추가] 1단계 - 쿠버네티스로 구성하기
1. 클러스터를 어떻게 구성했는지 알려주세요~ (마스터 노드 : n 대, 워커 노드 n대)

2. 스트레스 테스트 결과를 공유해주세요 (기존에 container 한대 운영시 한계점도 같이 공유해주세요)

3. 현재 워커노드에서 몇대의 컨테이너를 운영중인지 공유해주세요

---

### [추가] 2단계 - 클러스터 운영하기

1. kibana 링크를 알려주세요

2. grafana 링크를 알려주세요

3. 지하철 노선도는 어느정도로 requests를 설정하는게 적절한가요?

4. t3.large로 구성할 경우 Node의 LimitRange, ResourceQuota는 어느정도로 설정하는게 적절한가요?

5. 부하테스트를 고려해볼 때 Pod은 몇대정도로 구성해두는게 좋다고 생각하나요?

6. Spinaker 링크를 알려주세요.
