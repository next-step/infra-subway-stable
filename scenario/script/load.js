import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
    stages: [
        { duration: '20s', target: 12 },
        { duration: '10m', target: 12 },
        { duration: '20s', target: 0 },
    ],
    thresholds: {
        http_req_duration: ['p(99)<200'], // 99% of requests must complete below 0.1s
    },
};

const BASE_URL = 'https://becky-infra.r-e.kr/';
const USERNAME = 'becky-test@test.com';
const PASSWORD = 'test';

export default function ()  {
    main();
    loginPage();
    let token = login();
    let authHeaders = {
        headers: {
            Authorization: `Bearer ${token.json('accessToken')}`,
        },
    };
    findPath();
    sleep(1);
};

function login() {
    const payload = JSON.stringify({
        email: USERNAME,
        password: PASSWORD,
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const loginRes = http.post(`${BASE_URL}/login/token`, payload, params);

    check(loginRes, {
        'login() status is 200': (r) => r.status === 200,
        'logged in successfully': (resp) => resp.json('accessToken') !== '',
    });

    return loginRes;
}

function main() {
    const res = http.get(BASE_URL);

    check(res, {
        'main status is 200': (r) => r.status === 200
    });
}

function loginPage() {
    const res = http.get(`${BASE_URL}/login`);

    check(res, {
        'loginPage status is 200': (r) => r.status === 200
    });
}

function findPath() {

    let source = Math.floor(Math.random() * 257) + 1;
    let target = Math.floor(Math.random() * 257) + 1;
    while(source == target) {
        target = Math.floor(Math.random() * 257) + 1;
    }
    const res = http.get(`${BASE_URL}/paths?source=${source}&target=${target}`);
    check(res, {
        'findPath status is 200': (resp) => resp.status === 200,
    });
}
