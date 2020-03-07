# farm-registry
``Tech stack: Angular, Spring Boot, Java 11, Postgres``

``The frontend is basic and allows loging in, loging out and viewing lists``
``The backend has has fetch and create apis for customers, farms and users, but only login and fetch farms are wired to the frontend``

### local setup
``set up a postgres db instance using Docker``
docker run --name farm-registry -v farm-registry:/var/lib/postgresql/data -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 5432:5432 postgres:12.1-alpine

``execute the scripts from src/data dir to create tables and populate those with some data``
``run with maven``
mvn spring-boot:run

``the app will run at: http://localhost:8081``