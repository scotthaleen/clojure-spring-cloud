(ns spring.cloud.components.ienv
  (:import
   [org.springframework.context.annotation Primary Profile]
   [org.springframework.stereotype Component]))

;; Setup components for autowiring magic based on active profiles

;; import org.springframework.context.annotation.Profile;
;; import org.springframework.stereotype.Component;

;; public interface IEnv {
;;     public String env();
;; }

(gen-interface
 :name spring.cloud.components.IEnv
 :methods [[env [] String]])

;; @Component
;; @Profile("dev")
;; public class DevEnv implements IEnv {
;;     @Override
;;     public String env() {
;;         return "dev";
;;     }
;; }

(gen-class
 :name ^{org.springframework.stereotype.Component {}
         org.springframework.context.annotation.Profile ["dev"]
         } spring.cloud.components.DevEnv
 :implements [spring.cloud.components.IEnv]
 :state state
 :init init
 :prefix "-dev-"
 :constructors {[] []})

(defn -dev-init []
  [[] "dev"]) ;; <- set state to "dev"

(defn -dev-env [this]
  (.state this))

;; @Component
;; @Profile("prod")
;; public class ProdEnv implements IEnv {
;;     @Override
;;     public String env() {
;;         return "prod";
;;     }
;; }

(gen-class
 :name ^{org.springframework.stereotype.Component {}
         org.springframework.context.annotation.Profile ["prod"]
         } spring.cloud.components.ProdEnv
 :implements [spring.cloud.components.IEnv]
 :state state
 :init init
 :prefix "-prod-"
 :constructors {[] []})

(defn -prod-init []
  [[] "prod"]) ;; <- set state to "prod"

(defn ^String -prod-env [this]
  (.state this))
