(ns webcrawler.routes.home
  (:require [compojure.core :refer :all]
            [webcrawler.views.layout :as layout]
            [webcrawler.models.data :as data]
            [webcrawler.renders.renderHome :as renderHome]
            [webcrawler.renders.renderFirstSort :as firstSort]
            [webcrawler.renders.renderSecondSort :as secondSort]))

(defn home []
  (renderHome/renderListOfNewsUnordered (data/listOfNews) ))

(defn sortFirstCriteria []
  (firstSort/renderListOfNewsFirstCriteria (data/listOfNewsFirstCriteria)))

(defn sortSecondCriteria []
  (secondSort/renderListOfNewsSecondCriteria (data/listOfNewsSecondCriteria)))

(defroutes home-routes
           (GET "/" [] (home))
           (GET "/sortFirstCriteria" [] (sortFirstCriteria))
           (GET "/sortSecondCriteria" [] (sortSecondCriteria)))


