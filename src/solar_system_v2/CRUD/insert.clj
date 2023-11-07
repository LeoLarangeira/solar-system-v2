(ns solar-system-v2.CRUD.insert
  (:require [datomic.api :as d]
            [solar-system-v2.components.datomic :as comp]))







(defn insert-planets [name diameter mass gravity]
  (d/transact comp/conn
              [{:db/id (d/tempid :db.part/user)
                :planet/id (java.util.UUID/randomUUID) 
                :planet/name name
                :planet/diameter diameter
                :planet/mass mass
                :planet/gravity gravity}]))

(insert-planets "Earth" 12742.20 5.24 9.81)
(insert-planets "Mercury" 4880.00 3.30 3.70)
(insert-planets "Venus" 12104.00 4.90 8.87)
(insert-planets "Mars" 6779.00 6.42 3.71)