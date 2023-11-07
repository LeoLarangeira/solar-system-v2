(ns solar-system-v2.CRUD.insert
  (:require [datomic.api :as d]
            [solar-system-v2.components.datomic :as comp]))




(defn rand-str []
  (let [name (apply str (take 4 (repeatedly #(char (+ (rand 26) 65)))))
        num-str (rand-int 30)
        planet-str (str name "-" num-str)]
    planet-str))





(defn insert-planets []
  (let [db (d/transact comp/conn
                       [{:db/id (d/tempid :db.part/user)
                         :planet/id (java.util.UUID/randomUUID)
                         :planet/name (rand-str)
                         :planet/diameter (double (rand 555))
                         :planet/mass (double (rand 555))
                         :planet/gravity (double 555)}])]
    db
    ;não pode esquecer de colocar os campos aqui 
    ))



(insert-planets)