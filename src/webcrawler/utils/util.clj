(ns webcrawler.utils.util
  (:require [net.cgrand.enlive-html :as enlive]))

(defn checkNotComments [_string]
  (not (.contains _string "ago")))

(defn is-valid [_string]
  (if (= (clojure.string/blank? _string) true) false true))

(defn parse-int [_string]
  (Integer/parseInt _string))

(defn toNumber [_string]
  (let [strNumber (str (re-find #"\d+" _string))]
    (if (= (is-valid strNumber) true) (parse-int strNumber) 0)))

(defn is-valid-points [_string]
  (prn "string a validar " _string)
  (.contains _string "point"))

(defn checkValidPoints [_string]
  (if (= (is-valid-points _string) true) (toNumber (enlive/text _string)) 0))






