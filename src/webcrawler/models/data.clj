(ns webcrawler.models.data
  (:require [net.cgrand.enlive-html :as enlive]
            [webcrawler.views.layout :as layout]))

(def url "https://news.ycombinator.com/")

(defn getUrl [url]
  (enlive/html-resource (java.net.URL. url)))

(defn getRank []
  (map enlive/text (enlive/select (getUrl url) [:td.title :span.rank])))

(defn getTitle []
  (map enlive/text (enlive/select (getUrl url) [:td.title :a.storylink])))

(defn getSource []
  (map enlive/text (enlive/select (getUrl url) [:td.title :span :a :span.sitestr])))

(defn getPoints []
  (map enlive/text (enlive/select (getUrl url) [:td.subtext :span.score])))

(defn checkNotComments [element]
  (.contains  element "ago"))


(defn getComments []
  (filter checkNotComments (map enlive/text (enlive/select (getUrl url) [:td.subtext enlive/last-child]))))



(defn print-headlines-and-points []
  (prn (getComments) )
  (let [lista (concat (getRank) (getTitle) (getPoints) (getSource) (getComments))]
    (prn lista)
    (layout/common lista)
    ))
