# Lucidworks customer Code

## Steps to run this app
### Db creation
docker run --rm=true --name postgres-img -e POSTGRES_USER=user -e POSTGRES_PASSWORD=lucidpass -e POSTGRES_DB=customer -p 5432:5432 postgres:13.1

### Back End

./mvnw compile quarkus:dev

### Postman
import the  collection

postman_collection.json

###To scale to millions of users

- the getAllmethods , must have pagination, or a filter, 
- the getByID method, can be configured on redist , to cache the most used
- to retrieve the information, elasticsearch/mongoDB/cassandra would be an option to speed up.
- deploy the services on the cloud , AWS , azure. 
	- the service  has to be deployed over a docker image.
	- have load balancer by region,  
	- autoscaling  rules to create or kill instances based on methics (load, time to response,  number of connections, use of CPU, I/Os numbers )
	- for the push or updates a MariaDB (multi region DB) or  similar can be used. 
	
- the logger might push to Splunk or similar, the idea is having a single point to monitor the logs
