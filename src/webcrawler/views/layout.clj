(ns webcrawler.views.layout
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.core :refer [h]]))

(defn composeHtml [lines]
  (map (fn [line] [:div {:class "newsUnit"}
                   [:span {:class "rank"} (h (:rank line))]
                   [:span {:class "headline"} (h (:title line))]
                   [:span {:class "source"} (h (str "(" (:source line) ")"))]
                   [:div {:class "subtext"}
                    [:span {:class "points"} (h (str (:points line) " points"))]
                    [:span {:class "divider"} (h (str "|"))]
                    [:span {:class "comments"} (h (str (:comments line) " comments"))]]]) lines))


(defn itemMenu [tag url]
  (vec [:div [:a {:href url} (h (str tag))]]))


(defn composeMenu []
  (vec [:div (itemMenu "Home" "/" )
             (itemMenu  "Sort first criteria" "/sortFirstCriteria")
             (itemMenu "Sort second criteria" "/sortSecondCriteria")]))


(defn common [lines]
  (html5
    (include-css "/css/screen.css")
    [:h1 (str "WebCrawler demo")]
    [:body [:div {:class "leftMenu"} (composeMenu)]
     [:div {:class "container"} (composeHtml lines)]]))



