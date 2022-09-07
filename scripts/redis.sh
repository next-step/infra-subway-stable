#!/bin/bash

## Redis
docker stop redis && docker rm redis
docker pull redis
docker run -d -p 6379:6379 --name redis redis
