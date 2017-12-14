(ns webcrawler.utils.util)

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
  :aqui usar attr? y validar que exista el atributo span.class = score
  (.contains _string "points"))

(defn checkValidPoints [_string]
  (prn (is-valid-points _string))
  (if (= (is-valid-points _string) true) (toNumber _string) 0))






