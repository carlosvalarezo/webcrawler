(ns webcrawler.renders.renderFirstSort
  (:require [webcrawler.views.layout :as layout]))

(defn renderListOfNewsFirstCriteria [listOfNews]
  (layout/common listOfNews))

