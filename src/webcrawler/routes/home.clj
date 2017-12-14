(ns webcrawler.routes.home
  (:require [compojure.core :refer :all]
            [webcrawler.views.layout :as layout]
            [webcrawler.models.data :as data]
            [webcrawler.renders.renderHome :as renderHome]
            [webcrawler.renders.renderFirstSort :as firstSort]))

(defn home []
  (renderHome/renderListOfNewsUnordered (data/listOfNews) ))

(defn sortFirstCriteria []
  (firstSort/renderListOfFirstCriteria (data/listOfNewsFirstCriteria)))

(defroutes home-routes
           (GET "/" [] (home))
           (GET "/sortFirstCriteria" [] (sortFirstCriteria)))


