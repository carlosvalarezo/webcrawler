(ns webcrawler.utils.util)

(defn checkNotComments [_string]
  (not (.contains _string "ago")))

(defn toNumber [_string]
  (read-string (re-find (re-pattern "\\d+") _string)))
