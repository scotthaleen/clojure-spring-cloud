# Spring Cloud
[![Actions Status](https://github.com/scotthaleen/clojure-spring-cloud/workflows/Clojure%20CI/badge.svg)](https://github.com/scotthaleen/clojure-spring-cloud/actions)


Proof of concept Clojure Implementation of [Spring Boot Getting Started](https://spring.io/guides/gs/spring-boot/)

This project was created against 'Spring 2.2.5.RELEASE'

## Setup

[Spring Boot](http://projects.spring.io/spring-boot/) uses its own JarLauncher `org.springframework.boot.loader.JarLauncher`
Maven and Gradle have plugins to package the jar for you, Leiningen does not. So I had to create a custom lein plugin.

Goto - [https://github.com/scotthaleen/lein-spring-boot-jar] and install the plugin locally to compile this project.

Note: for history I have left the custom bash script (`./bin/package.sh`) used before I created the lein plugin.

## Compile

```bash
lein spring-boot-jar
```

## Run

Choose a profile either `dev` and `prod` and specify it using the
`spring.profiles.active` parameter. There is no `default` (intentionally) the
application will fail to start when no valid profile is not specified.

```bash
$ java -jar -Dspring.profiles.active=dev target/boot-spring-cloud-0.1.0-SNAPSHOT.jar
16:04:58.120 [main] INFO spring.cloud.App -
   ____ _       _
  / ___| | ___ (_)_   _ _ __ ___
 | |   | |/ _ \| | | | | '__/ _ \
 | |___| | (_) | | |_| | | |  __/
  \____|_|\___// |\__,_|_|  \___|
              |__/



  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.5.RELEASE)
...


$ curl localhost:8080
Greetings from Clojure!%

$  curl http://localhost:8080/greeting
{"id":1,"content":"Hello, world!"}%

$ curl "http://localhost:8080/greeting?name=User"
{"id":2,"content":"Hello, User!"}%

# Depending on -Dspring.profiles.active={dev,prod}
# Without an active profile the server will fail to start
$ curl http://localhost:8080/env
dev

```


## TODO

- [x] Spring Boot Lein Package Plugin
- [x] Spring Profiles [example](src/spring/cloud/components/ienv.clj)
- [x] Spring Autowiring [magic](src/spring/cloud/rest/env.clj)

## License

Copyright © 2020

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

