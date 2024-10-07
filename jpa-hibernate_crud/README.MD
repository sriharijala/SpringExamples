# Sample User Service #

## Overview ##

This example use the demonstrate the technologies
   - Swagger UI 
   - Deployment to Docker desktop
        * Nginx load balancer
        * Replication of service 

## URLS
End point to see environment variable using actuator:  http://localhost:8081/actuator/env
Swagger end point: http://localhost:8080/swagger-ui/index.html

## Replication
To replicate the services we need to solve the issue with host port conflict. The host machine can only bind an unallocated port to one container only, otherwise  we get an error "failed: port is already allocated error for additional XXX service".

- Use the load balancer will access the back end service without exposing the container ports and distribute the traffic across multiple containers.

```
nginx.conf

user  nginx;
events {
    worker_connections   1000;
}
http {
        server {
              listen 80;
              location / {
                proxy_pass http://user-reviews:8080;
              }
        }
}
```

- In docker-compose.yml expose only the container port

```
services:
  user-reviews:
    image: sjala/user-reviews:latest
    depends_on:
       - mysql
    expose:
      - "8080"
```

## Docker commands

- Build Docker image                      : ``docker build -t sjala/user-reviews:1.0 ``
- Push docker image to Docker Hub  : ``docker push sjala/user-reviews:1.0``
- Deploy in docker desktop 			   : ``docker compose --env-file=user-reviews.env up -d --scale user-reviews=3``


