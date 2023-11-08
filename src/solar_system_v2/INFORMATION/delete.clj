(ns solar-system-v2.INFORMATION.delete
   (:require [datomic.api :as d]
            [solar-system-v2.components.datomic :as db]))

;ao colocar o ! nós indicamos que gera um side effect
(defn delete-planet! []
  (d/transact db/conn [[:db/retractEntity 17592186045418]]))

(delete-planet!)

#_(defn delete-planet! [name]
  (d/transact db/conn [[:db/retractEntity [:planet/name name]]]))