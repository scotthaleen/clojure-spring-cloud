(ns spring.cloud.rest.hello
  (:import
   [org.springframework.web.bind.annotation RestController RequestMapping]
   [org.slf4j Logger LoggerFactory])
  (:gen-class
   :name ^{org.springframework.web.bind.annotation.RestController {}} spring.cloud.rest.HelloController
   :methods [[^{org.springframework.web.bind.annotation.RequestMapping ["/"]} index [] String]]))


;; import org.springframework.web.bind.annotation.RestController;
;; import org.springframework.web.bind.annotation.RequestMapping;

;; @RestController
;; public class HelloController {

;;     @RequestMapping("/")
;;     public String index() {
;;         return "Greetings from Spring Boot!";
;;     }

;; }

(def ^org.slf4j.Logger logger (LoggerFactory/getLogger spring.cloud.rest.HelloController))

(defn -index
  [this]
  (.info logger "index: Greetings")
  "Greetings from Clojure!")
