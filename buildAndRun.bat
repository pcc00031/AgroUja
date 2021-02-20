@echo off
call mvn clean package
call docker build -t agrouja/agrouja .
call docker rm -f agrouja
call docker run -d -p 9080:9080 -p 9443:9443 --name agrouja agrouja/agrouja