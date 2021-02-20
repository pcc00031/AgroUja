#!/bin/sh
mvn clean package && docker build -t agrouja/agrouja .
docker rm -f agrouja || true && docker run -d -p 9080:9080 -p 9443:9443 --name agrouja agrouja/agrouja