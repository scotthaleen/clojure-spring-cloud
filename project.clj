(defproject spring-cloud "0.1.0-SNAPSHOT"
  :description ""
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [org.springframework.boot/spring-boot-starter-web "1.4.1.RELEASE"
                  :exclusions [org.springframework.boot/spring-boot-starter-tomcat]]
                 [org.springframework.boot/spring-boot-starter-jetty "1.4.1.RELEASE"]
                 [org.springframework.boot/spring-boot-starter-actuator "1.4.1.RELEASE"]
                 ;;[org.springframework.boot/spring-boot-loader "1.2.3.RELEASE"]
                 ]
  :main org.springframework.boot.loader.JarLauncher
  :manifest {"Start-Class" "spring.cloud.App"
             "Spring-Boot-Classes" "BOOT-INF/classes/" 
             "Spring-Boot-Lib" "BOOT-INF/lib/"}
  :libdir-path "target/spring-boot/BOOT-INF/lib"
  :plugins [[lein-libdir "0.1.1"]]
  :aot :all)
