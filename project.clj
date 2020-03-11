(def SPRING-BOOT-VERSION "2.2.5.RELEASE")

(defproject spring-cloud "0.2.0-SNAPSHOT"
  :description ""
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.springframework.boot/spring-boot-starter-web ~SPRING-BOOT-VERSION
                  :exclusions [org.springframework.boot/spring-boot-starter-tomcat]]
                 [org.springframework.boot/spring-boot-starter-jetty ~SPRING-BOOT-VERSION]
                 [org.springframework.boot/spring-boot-starter-actuator ~SPRING-BOOT-VERSION]]
  :repositories [["spring-milestone" "https://repo.spring.io/milestone"]]
  :main spring.cloud.App
  :spring-boot-loader-version "2.2.5.RELEASE"
  :plugins [[lein-spring-boot-jar "0.1.0"]
            [lein-ancient "0.6.15"]]
  :aliases {"build" ["do" ["clean"] ["spring-boot-jar"]]}
  :aot :all)
