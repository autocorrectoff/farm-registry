# farm-registry

``set up a postgres db instance using Docker``
docker run --name farm-registry -v farm-registry:/var/lib/postgresql/data -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 5432:5432 postgres:12.1-alpine

``execute the scripts from src/data dir to create tables and populate those with some data``