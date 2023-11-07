(ns solar-system-v2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [solar-system-v2.CRUD.search :as search]
            [solar-system-v2.CRUD.insert :as insert])
            )

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/planets/:name" [name] "<h1> Catapimbas </h1>"
    (search/get-pika-map name)
    )
  (POST "/planets" [] "Planeta gerado com sucesso!" 
    (insert/insert-planets)
    )
  (PUT "/planets" [] "PUT"
    ;aqui vai uma função up/planet
    )
  (DELETE "/planets" [] "DELETE"
    ;função delete/planet
    )
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
