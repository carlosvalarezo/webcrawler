(ns webcrawler.renders.renderHome
  (:require [webcrawler.views.layout :as layout]))

(defn renderListOfNewsUnordered[listOfNews]
  (layout/common listOfNews))
