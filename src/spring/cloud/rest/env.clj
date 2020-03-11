(ns spring.cloud.rest.env
  (:import
   [spring.cloud.components IEnv]
   [org.springframework.beans.factory.annotation Autowired]
   [org.springframework.web.bind.annotation RequestMapping RequestParam RestController]
   [org.slf4j Logger LoggerFactory])
  (:gen-class
   :name ^{org.springframework.web.bind.annotation.RestController {}} spring.cloud.rest.EnvController
   :state state
   :init init
   :constructors {[^{org.springframework.beans.factory.annotation.Autowired {:required true}} spring.cloud.components.IEnv] []}
   :methods [[^{org.springframework.web.bind.annotation.RequestMapping ["/env"]} env [] String]]))


;;@RestController
;; public class EnvController {
;;
;;     private IEnv envComponent;
;;
;;     public EnvController(@Autowired IEnv env) {
;;         this.envComponent = env;
;;     }
;;
;;     @RequestMapping("/env")
;;     public String env() {
;;         return envComponent.env();
;;     }
;; }


(def ^org.slf4j.Logger logger (LoggerFactory/getLogger spring.cloud.rest.EnvController))

(defn -init [env]
  [[spring.cloud.components.IEnv] (atom env)])

(defn -env [this]
  (let [env (.env @(.state this))]
    (.info logger "Which Environment: {}" env)
    env))
