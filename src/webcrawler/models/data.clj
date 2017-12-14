(ns webcrawler.models.data
  (:require [net.cgrand.enlive-html :as enlive]
            [webcrawler.views.layout :as layout]
            [webcrawler.utils.util :as util]
            [cheshire.core :refer :all]))

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

(defn getComments []
  (filter util/checkNotComments (map enlive/text (enlive/select (getUrl url) [:td.subtext enlive/last-child]))))

(defn listOfNews [] (map (fn [rank title source points comments] {:rank rank :title title :source source :points points :comments comments}) (getRank) (getTitle) (getSource) (getPoints) (getComments)))

;(defn print-headlines-and-points [] (prn titleUnit) (layout/common (parse-string (generate-string titleUnit))))
