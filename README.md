# Spring Cloud

Proof of concept Clojure Implementation of [Spring Boot Getting Started](https://spring.io/guides/gs/spring-boot/)

This project was created against 'Spring 2.0.0.RC1'

[Spring Boot](http://projects.spring.io/spring-boot/) uses its own JarLauncher `org.springframework.boot.loader.JarLauncher` Maven and Gradle have plugins to package the jar for you, Leiningen does not. So I had to create a custom bash script to make do.


## Compile

```bash
$ ./bin/package.sh
```

## Run

```bash
$ java -jar target/boot.jar
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
 :: Spring Boot ::            (v2.0.0.RC1)
...


$ curl localhost:8080
Greetings from Clojure!%
```


## TODO

- [ ] Spring Boot Lein Package Plugin



## License

Copyright © 2018

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

