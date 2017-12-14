(ns webcrawler.renders.renderSecondSort
  (:require [webcrawler.views.layout :as layout]))

(defn renderListOfNewsSecondCriteria [listOfNews]
  (layout/common listOfNews))
