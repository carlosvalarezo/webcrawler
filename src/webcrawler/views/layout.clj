(ns webcrawler.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn componer [lines]
  (map (fn [line] (str "<div> " line "</div><br/>")) lines))

(defn common [lines]
  (let [_lines (componer lines)]
    (html5
      (include-css "/css/screen.css")
      [:body [:div {:class "leftMenu"}
              [:div [:a { :href "/"} "Home"]]
              [:div [:a { :href "/sortFirstCriteria"} "Sort first criteria"]]
               [:div [:a { :href "/sortSecondCriteria"} "Sort second criteria"]]]
               [:div {:class "container"} _lines]])
    ))




