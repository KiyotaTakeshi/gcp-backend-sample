# employee(spring test slice sample)

## Run local

### Setup

- set jdk 11

```shell
$ export JAVA_HOME=`/usr/libexec/java_home -v 11`

$ java -version                                                                                  
openjdk version "11.0.11" 2021-04-20 LTS
OpenJDK Runtime Environment Corretto-11.0.11.9.1 (build 11.0.11+9-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.11.9.1 (build 11.0.11+9-LTS, mixed mode)
```

- run postgres

```shell
docker-compose up -d
```

### Run

- build(create executable jar)

```shell
./gradlew build
```

- run application as a spring-boot

```shell
./gradlew bootRun
```

- run application as a jar

```shell
ARTIFACT_NAME=$(./gradlew properties -q | grep "name:" | awk '{print $2}')
ARTIFACT_VERSION=$(./gradlew properties -q | grep "version:" | awk '{print $2}')
java -jar build/libs/$ARTIFACT_NAME-$ARTIFACT_VERSION.jar
```

### Access

- you can use [postman collection](./postman)

```shell
$ curl --location --request GET 'http://localhost:8081/employees'
[{"id":1,"name":"taro","department":"sales"},{"id":2,"name":"jiro","department":"human resources"}]

$ curl --location --request GET 'http://localhost:8081/employees/1'
{"id":1,"name":"taro","department":"sales"}
```

---
### Build Docker image

- spring

```shell
./gradlew bootBuildImage

 $ docker image ls | grep employee
kiyotakeshi/employee                            0.0.1                                                   78336b9cd40f   41 years ago    296MB
```

### Run as container

- comment-out [docker-compose "employee" section](./docker-compose.yaml)

```shell
export ARTIFACT_VERSION=$(./gradlew properties -q | grep "version:" | awk '{print $2}')

$ docker compose up -d

$ docker compose ps   
NAME                COMMAND                  SERVICE             STATUS              PORTS
employee            "/cnb/process/web"       employee            running             0.0.0.0:8081->8081/tcp
employee-postgres   "docker-entrypoint.s…"   postgres            running             0.0.0.0:5432->5432/tcp
```
