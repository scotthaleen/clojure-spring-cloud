(ns spring.cloud.rest.greeting
  (:import
   [org.springframework.web.bind.annotation RequestMapping RequestParam RestController]
   [org.slf4j Logger LoggerFactory]
   [spring.cloud.models Greeting])
  (:gen-class
   :name ^{org.springframework.web.bind.annotation.RestController {}} spring.cloud.rest.GreetingController
   :state state
   :init init
   :constructors {[] []}
   :methods [[^{org.springframework.web.bind.annotation.RequestMapping ["/greeting"]} greeting
              [^{org.springframework.web.bind.annotation.RequestParam
                 {:value "name"
                  :defaultValue "world"}} String]
              spring.cloud.models.Greeting]]))

;;import java.util.concurrent.atomic.AtomicLong;
;;import org.springframework.web.bind.annotation.RequestMapping;
;;import org.springframework.web.bind.annotation.RequestParam;
;;import org.springframework.web.bind.annotation.RestController;

;;@RestController
;; public class GreetingController {

;;     private static final String template = "Hello, %s!";
;;     private final AtomicLong counter = new AtomicLong();

;;     @RequestMapping("/greeting")
;;     public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
;;         return new Greeting(counter.incrementAndGet(),
;;                             String.format(template, name));
;;     }
;; }

(def ^org.slf4j.Logger logger (LoggerFactory/getLogger spring.cloud.rest.GreetingController))
(def ^{:private true} template "Hello, %s!")

(defn -init []
  [[] (atom 0)])

(defn -greeting [this name]
  (let [n (swap! (.state this) inc)
        s (format template name)]
    (.info logger (format "id %s, greeting: %s" n s))
    (Greeting. n s)))
