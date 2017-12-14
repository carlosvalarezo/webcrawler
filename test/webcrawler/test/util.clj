(ns webcrawler.test.util
  (:require [clojure.test :refer :all]
            [webcrawler.utils.util :as util]))


(deftest test-util
  (testing "should return true because is a word without ago"
      (is (= (util/checkNotComments "comments") true )))

  (testing "should return false because is a word with ago"
    (is (= (util/checkNotComments "20 minutes ago") false )))

  (testing "should return false because is a blank string"
    (is (= (util/is-valid "") false )))

  (testing "should return false because is not a blank string"
    (is (= (util/is-valid "foo") true )))

  (testing "should return false because is not a blank string"
    (is (= (util/is-valid "foo") true )))

  (testing "should return 0 because is not a valid number"
    (is (= (util/toNumber "foo") 0 )))

  (testing "should return 10 because is a valid number"
    (is (= (util/toNumber "10") 10 ))))