FROM openjdk:11-jdk-slim

WORKDIR /app

COPY . /app

RUN apt-get update && apt-get -y dist-upgrade && \
    mkdir -p /usr/share/man/man1 && \
	apt-get -y --no-install-recommends install maven dumb-init libtcnative-1 curl procps && \
	mvn clean compile && mvn package && apt autoclean && \
	rm -rf /root/.m2* && apt -y autoremove && apt-get -y autoremove maven && \
    mv target/farm-registry-0.0.1-SNAPSHOT.jar /root/app.jar && find /app/ -type f -exec rm {} \; && \
	mv /root/app.jar /app/app.jar && rm -rf /var/lib/apt/lists/*

COPY docker-entrypoint.sh /app/

EXPOSE 8081

ENTRYPOINT ["/usr/bin/dumb-init", "sh", "/app/docker-entrypoint.sh"]