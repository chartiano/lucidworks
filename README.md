# Lucidworks customer Code

## Steps to run this app
### Db creation
docker run --rm=true --name postgres-img -e POSTGRES_USER=user -e POSTGRES_PASSWORD=lucidpass -e POSTGRES_DB=customer -p 5432:5432 postgres:13.1

### Back End

./mvnw compile quarkus:dev

