(ns spring.cloud.rest.hello
  (:import
   [org.springframework.web.bind.annotation RestController RequestMapping])
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


(defn -index [this] "Greetings from Clojure!")
