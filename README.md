# employee(spring test slice sample)

## Run local

- set jdk 17

```shell
$ export JAVA_HOME=`/usr/libexec/java_home -v 17`

$ java -version                                     
openjdk version "17" 2021-09-14 LTS
OpenJDK Runtime Environment Corretto-17.0.0.35.2 (build 17+35-LTS)
OpenJDK 64-Bit Server VM Corretto-17.0.0.35.2 (build 17+35-LTS, mixed mode, sharing)
```

- run postgres

```shell
docker-compose up -d
```

- build

```shell

```

- run application as a spring-boot

```shell

```

- run application as a jar using ~~maven~~

```shell
#ARTIFACT_VERSION=$(./mvnw org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout)
# TODO: gradle
```

### Access [localhost:8081](http://localhost:8081/)

---
## Build Docker image

- spring

```shell
# TODO: gradle
#./mvnw spring-boot:build-image
```
