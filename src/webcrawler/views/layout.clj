(ns webcrawler.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn componer [lines]
  (map (fn [line] (str "<div> " line "</div><br/>")) lines))

(defn common [lines]
  (let [_lines (componer lines)]
    (html5
      (include-css "/css/screen.css")
      [:body _lines])
    ))




