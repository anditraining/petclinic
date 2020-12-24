##Assignment Test
#Changes
1. new project spring-petclinic-hospital-service connected with Zipkin, Discovery Service, Grafana, Config, API Gateway, Database
2. Change in docker-compose.yml for hospital-service
3. Change in spring-petclinic-config-service to connect with different github url containing new file hospital-service.yaml
4. Change in spring-petclinic-api-gateway with new endpoint that connected to hospital-service

Sample API Gateway Call
POST http://localhost:8080/api/hospital/appointment

curl --location --request POST 'localhost:8080/api/hospital/appointment' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "appointmentDate": "2020-12-23",
    "description": "Shoot rabies",
    "petId": 1
}'

GET http://localhost:8080/api/hospital/appointment/1

curl --location --request GET 'localhost:8080/api/hospital/appointment/1'
