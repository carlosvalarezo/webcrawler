(ns webcrawler.routes.home
  (:require [compojure.core :refer :all]
            [webcrawler.views.layout :as layout]
            [webcrawler.models.data :as data]
            [webcrawler.renders.renderHome :as home]))

(defn home []
  (home/renderListOfNewsUnordered (data/listOfNews) ))

(defn sortFirstCriteria []
  ())

(defroutes home-routes
           (GET "/" [] (home))
           (GET "/sortFirstCriteria" [] (sortFirstCriteria)))


