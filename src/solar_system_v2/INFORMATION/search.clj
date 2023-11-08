(ns solar-system-v2.INFORMATION.search
  (:require [datomic.api :as d]
            [solar-system-v2.components.datomic :as compo] 
            [cheshire.core :refer :all]))

(def conn (d/db compo/conn))

;maneiro
;pega todos os planetas, porém só o id 
(def get-all-planets '[:find ?e
                       :where [?e :planet/name ]
                       ])
;pega todos os nomes 
(def get-all-planets-names '{
                             :find [?name]
                             :where [[_ :planet/name ?name]]
})
;pega todos os planetas com gravidade igual ou menor que 10

(def get-all-planets-gravity
  '{:find [?name]
    :where [[?e :planet/name ?name]
            [?e :planet/gravity ]] 
    })




;(search-by-name  "Earth" 9.98)
(d/q get-all-planets conn)
(def first-name (first (d/q get-all-planets-names conn)))
(d/q get-all-planets-gravity conn)



(defn get-pika [name]
  (d/q '[:find ?id
         :in $ ?name
         :where [?id :planet/name ?name]] conn name))


;isso aqui retorna todos os dados, fazendo a busca pelo nome!
(defn get-pika-map [name] 
  (let [planet (-> @(d/q '{:find [(pull ?id [*])]
                      :in [$ ?name]
                      :where [[?id :planet/name ?name]]} conn name))
        generated-string (generate-string planet)
        _ (println planet)
        ]
    (println name)
    (println generated-string)
    {:status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body generated-string}))

(get-pika "IECM-7")




;infelizmente esse aqui não esta funcionando, mas é para ser isso aqui:
(defn get-tx [name]
  (d/q '[:find ?name ?tx ?mass
         :in $ ?name ; Update this line to use ?name
         :where [(fulltext $ :planet/name ?name) [[?name ?tx ?mass]]]]
       conn name))

;(get-tx "NCNF-18")



