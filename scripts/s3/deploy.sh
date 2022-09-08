#!/bin/bash

sudo apt-get update
sudo apt install unzip
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install

sudo -i -u ubuntu aws s3 cp s3://nextstep-infra-workshop/orgojy/deploy.sh /home/ubuntu
sudo -i -u ubuntu chmod 755 /home/ubuntu/deploy.sh
sudo -i -u ubuntu /bin/bash /home/ubuntu/deploy.sh
