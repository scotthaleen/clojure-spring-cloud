(ns spring.cloud.app
  (:require [clojure.string :as s])
  (:import
   [java.util Arrays]
   [org.springframework.boot CommandLineRunner SpringApplication]
   [org.springframework.boot.autoconfigure SpringBootApplication]
   [org.springframework.context ApplicationContext]
   [org.springframework.context.annotation Bean]
   [org.slf4j Logger LoggerFactory])
  (:gen-class
   :name ^{org.springframework.boot.autoconfigure.SpringBootApplication {}} spring.cloud.App
   :methods [[^{org.springframework.context.annotation.Bean {}} commandLineRunner
              [org.springframework.context.ApplicationContext] org.springframework.boot.CommandLineRunner]]))

;; Updated example Spring 2.2.5

;; import java.util.Arrays;

;; import org.springframework.boot.CommandLineRunner;
;; import org.springframework.boot.SpringApplication;
;; import org.springframework.boot.autoconfigure.SpringBootApplication;
;; import org.springframework.context.ApplicationContext;
;; import org.springframework.context.annotation.Bean;

;; @SpringBootApplication
;; public class Application {

;;  public static void main(String[] args) {
;;    SpringApplication.run(Application.class, args);
;;  }

;;  @Bean
;;  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
;;    return args -> {

;;      System.out.println("Let's inspect the beans provided by Spring Boot:");

;;      String[] beanNames = ctx.getBeanDefinitionNames();
;;      Arrays.sort(beanNames);
;;      for (String beanName : beanNames) {
;;        System.out.println(beanName);
;;      }

;;    };
;;  }

;; }


(set! *warn-on-reflection* true)

(def ^org.slf4j.Logger logger (LoggerFactory/getLogger spring.cloud.App))

(defn print-clojure []
  (letfn [(fn-str [& args] (s/join \newline args))]
    (.info logger (fn-str
            ""
            "   ____ _       _                "
            "  / ___| | ___ (_)_   _ _ __ ___ "
            " | |   | |/ _ \\| | | | | '__/ _ \\ "
            " | |___| | (_) | | |_| | | |  __/  "
            "  \\____|_|\\___// |\\__,_|_|  \\___| "
            "              |__/                "
            ""
            ""))

    ))

(defn -commandLineRunner
  [this ctx]
  (reify org.springframework.boot.CommandLineRunner
    (run [this args]
      (.info logger "The CommandLineRunner Bean")
      (doseq [bean (sort (.getBeanDefinitionNames ctx))]
        (.info logger bean)))))

(defn -main [& args]
  (print-clojure)
  (let [^ApplicationContext ctx (SpringApplication/run
                                  ^Object spring.cloud.App
                                  ^"[Ljava.lang.String;" (into-array String args))]))
