#!/bin/bash

docker stop proxy && docker rm proxy
docker build -t nextstep/reverse-proxy:0.0.2 .
docker run -d -p 80:80 -p 443:443 --name proxy -v /var/log/nginx:/var/log/nginx nextstep/reverse-proxy:0.0.2
