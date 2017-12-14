(ns webcrawler.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn composeHtml [lines]
  (map (fn [line] [:div {:class "newsUnit"}
                   [:span {:class "rank"} (:rank line)]
                   [:span {:class "headline"} (:title line)]
                    [:span {:class "source"} (str "(" (:source line) ")")]
                    [:div {:class "subtext"}  [:span {:class "points"} (str "Points :" (:points line))]
                     [:span {:class "comments"} (str "Comments :" (:comments line))]]]) lines))

(defn common [lines]
  (let [_lines (composeHtml lines)]
    (html5
      (include-css "/css/screen.css")
      [:h1 (str "WebCrawler demo")]
      [:body [:div {:class "leftMenu"}
              [:div [:a {:href "/"} "Home"]]
              [:div [:a {:href "/sortFirstCriteria"} "Sort first criteria"]]
              [:div [:a {:href "/sortSecondCriteria"} "Sort second criteria"]]]
       [:div {:class "container"} _lines]])))



