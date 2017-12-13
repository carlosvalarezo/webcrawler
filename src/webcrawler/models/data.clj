(ns webcrawler.models.data
  (:require [net.cgrand.enlive-html :as enlive]
            [webcrawler.views.layout :as layout]
            [webcrawler.utils.util :as util]))

(def url "https://news.ycombinator.com/")

(def _titles [{:title ""}])

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

(def titleUnit (map (fn [x y] {:title x :rank y}) (getTitle) (getRank)))

;(defn getTitlesMap []
;  (map #(prn (str %)) (getTitle)))

;(defn getTitlesMap []
;(doseq [title (getTitle)]
;  (prn (str title))) )


(defn print-headlines-and-points []
  (prn titleUnit)
  (let [lista (concat (getRank) (getTitle) (getPoints) (getSource) (getComments))]
    (layout/common lista)))
