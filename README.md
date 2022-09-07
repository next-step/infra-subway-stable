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
1. 성능 개선 결과를 공유해주세요 (Smoke, Load, Stress 테스트 결과)

| 테스트 | 개선전 | 개선후 |
|---------|---------|---------|
| smoke | ![](k6/images/before/before-smoke-grafana.png) | ![](k6/images/after/after-smoke-grafana.png) |
| load | ![](k6/images/before/before-load-grafana.png) | ![](k6/images/after/was/redis-grafana.png) |
| stress | ![](k6/images/before/before-stress-grafana.png) | ![](k6/images/after/after-stress-grafana.png) |

2. 어떤 부분을 개선해보셨나요? 과정을 설명해주세요<br>
   (Smoke 테스트 후 Load 테스트 결과 캡쳐)
- Reverse Proxy 개선하기
  - gzip 압축
    - ![](k6/images/after/reverseproxy/gzip-http.png) 
    - ![](k6/images/after/reverseproxy/gzip-grafana.png)
  - cache
    - ![](k6/images/after/reverseproxy/cache-http.png)
    - ![](k6/images/after/reverseproxy/cache-grafana.png)
  - TLS, HTTP/2 설정
    - ![](k6/images/after/reverseproxy/h2-http.png)
    - ![](k6/images/after/reverseproxy/h2-grafana.png)
- WAS 성능 개선하기
  - Spring Data Cache
    - ![](k6/images/after/was/redis-cli.png)
    - ![](k6/images/after/was/redis-grafana.png)

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
