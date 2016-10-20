(ns spring.cloud.app
  (:import
   [java.util Arrays]
   [org.springframework.boot SpringApplication]
   [org.springframework.boot.autoconfigure SpringBootApplication]
   [org.springframework.context ApplicationContext])
  (:gen-class
   :name ^{org.springframework.boot.autoconfigure.SpringBootApplication {}} spring.cloud.App))


;; import java.util.Arrays;

;; import org.springframework.boot.SpringApplication;
;; import org.springframework.boot.autoconfigure.SpringBootApplication;
;; import org.springframework.context.ApplicationContext;

;; @SpringBootApplication
;; public class Application {

;;     public static void main(String[] args) {
;;         ApplicationContext ctx = SpringApplication.run(Application.class, args);

;;         System.out.println("Let's inspect the beans provided by Spring Boot:");

;;         String[] beanNames = ctx.getBeanDefinitionNames();
;;         Arrays.sort(beanNames);
;;         for (String beanName : beanNames) {
;;             System.out.println(beanName);
;;         }
;;     }

;; }


(defn -main [& args]
  (println "-- Clojure --")
  (let [ctx (SpringApplication/run ^Object spring.cloud.App (into-array String args))]
    (doseq [bean (sort (.getBeanDefinitionNames ctx))]
      (println bean))))
