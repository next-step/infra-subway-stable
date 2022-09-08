#!/bin/bash

git clone https://github.com/orgojy/infra-subway-stable.git ;
cd ~/infra-subway-stable ;
git pull origin step2 ;
~/infra-subway-stable/scripts/main.sh step2 prod ~/infra-subway-stable/build/libs/subway-0.0.1-SNAPSHOT.jar
