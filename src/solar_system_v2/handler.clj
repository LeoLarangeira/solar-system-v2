(ns solar-system-v2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [solar-system-v2.CRUD.search :as search])
            )

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/planets" [] "<h1> Catapimbas </h1>"
    ;(search/get-all-planets)
    )
  (POST "/planets" [] "POST"
    ;aqui vai uma função create/planet
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
