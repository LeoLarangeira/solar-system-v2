(ns solar-system-v2.CRUD.search
  (:require [datomic.api :as d]
            [solar-system-v2.components.datomic :as compo]))

(def conn nil)

;maneiro
(def get-all-planets '[:find (count ?name) ?id
                       :where [_ :planet/name ?name]
                              [_ :planet/id ?id]])


(d/q '[:find  ?e 
       :where [?e :planet/name "Earth"]] (d/db compo/conn))

(defn get-name [name]
  (d/q '[
         :find ?id
         :in ?name 
         :where [?id :planet/name ?name]]
       (d/db compo/conn) name))

(defn get-all []
  (d/q  '[:find (count ?name) ?id
         :where [_ :planet/name ?name]
         [_ :planet/id ?id]] (d/db compo/conn)))

;  (search-by-name  "Earth" 9.98)
(get-all)
(get-name "Venus")



