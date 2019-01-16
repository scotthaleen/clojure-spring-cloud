(ns spring.cloud.models.greeting
  (:import
   [com.fasterxml.jackson.annotation JsonIgnoreProperties])
  (:gen-class
   ;; ignore clojure internal `.state` field during serialization
   :name ^{com.fasterxml.jackson.annotation.JsonIgnoreProperties ["state"]} spring.cloud.models.Greeting
   :init init
   :state state
   :constructors {[long String] []}
   :methods [[getId [] long]
             [getContent [] String]]))

(defn -init [id content]
  [[] {:id id :content content}])

(defn -getId [this]
  (:id (.state this)))

(defn -getContent [this]
  (:content (.state this)))
