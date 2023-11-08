(ns solar-system-v2.components.datomic
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            ;[com.stuartsierra.component :as component]
            [datomic.api :as d]
            [solar-system-v2.protocols.db :as db]))

(def db-uri "datomic:mem://hello")




(def schema (-> "public/schema.edn"
                (io/resource)
                (slurp)
                (edn/read-string)))


(d/create-database db-uri)

(def conn (d/connect db-uri))

(d/transact conn schema)

#_((defn get-pika [name]
  (d/q '[:find ?id
         :in $ ?name
         :where [?id :planet/name ?name]] (d/db conn) name))
(println conn)
(get-pika "Earth")
)

