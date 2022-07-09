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

|             |지하철 노선도(개선전)| 지하철 노선도(개선후)| 서울교통공사 | 네이버지도 | 카카오맵 |
|-------------|----------------|------------|-------------|-----------|---------|
| Performance |  33            | 49         |   43        | 59        | 69      |
| FCP         | 14.6s          | 2.5s       | 6.4s        | 2.2s      | 1.7s    |
| Speed Index | 14.6s          | 4.4s       | 7.7s        | 5.6s      | 6.4s    | 
| LCP         | 15.1s          | 5.7s       | 6.6s        | 8.3s      | 6.4s    |
| TTI         | 15.1s          | 5.8s       | 8.4s        | 5.9s      | 4.1s    | 
| TBT         | 490ms          | 860ms      | 420ms       | 290ms     | 30ms    |
| CLS         | 0.042          | 0.04       | 0           | 0.03      | 0.005   | 


<img width="1038" alt="pagespeed_desktop" src="https://user-images.githubusercontent.com/34808501/178098202-faf4981f-cbbe-4666-b763-d08e34fe711b.png">
<img width="1043" alt="pagespeed_mobile" src="https://user-images.githubusercontent.com/34808501/178098205-12768517-7c3b-4874-b61d-70810fd92b97.png">

* Smoke
* ![](k6/smoke/before_smoke_test.png)
* ![](k6/smoke/after_smoke_test.png)

* Load
* ![](k6/load/before_load_test.png)
* ![](k6/load/after_load_test.png)

* Stress
* ![](k6/stress/before_stress_test.png)
* ![](k6/stress/after_stress_test.png)

3. 어떤 부분을 개선해보셨나요? 과정을 설명해주세요
- @Transactional(readOnly=true) 읽기전용 트랜잭션 처리
- Spring Data Cache 적용
- nginx Reverse Proxy 개선
  - gzip 압축,
  - cache 적용
  - TLS, HTTP/2 설정
- js 파일에 async 속성 추가

---

### 2단계 - 스케일 아웃

1. Launch Template 링크를 공유해주세요.

2. cpu 부하 실행 후 EC2 추가생성 결과를 공유해주세요. (Cloudwatch 캡쳐)

```sh
$ stress -c 2
```

3. 성능 개선 결과를 공유해주세요 (Smoke, Load, Stress 테스트 결과)

