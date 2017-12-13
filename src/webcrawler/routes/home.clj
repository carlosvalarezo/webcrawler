(ns webcrawler.routes.home
  (:require [compojure.core :refer :all]
            [webcrawler.views.layout :as layout]
            [webcrawler.models.data :as data]))

(defn home []
(data/print-headlines-and-points) )

(defroutes home-routes
           (GET "/" [] (home)))


