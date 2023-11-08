(ns solar-system-v2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [solar-system-v2.INFORMATION.search :as search]
            [solar-system-v2.INFORMATION.insert :as insert]
            [solar-system-v2.INFORMATION.fun :as fun])
            )

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/test/:arg1/:arg2" [arg1 arg2] "<h1>Testando passar várias vals </h1>"
    (fun/test-vals-multy arg1 arg2))
  (GET "/planets/:name" [name] "<h1> Catapimbas </h1>"
    (search/get-pika-map name)
    )
  (POST "/post-planets" [] "<h1>Planeta gerado com sucesso! Vamos que vamos!</h1>" 
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
