(ns webcrawler.utils.util)

(defn checkNotComments [_string]
  (not (.contains _string "ago")))