(ns sicp.core-test
  (:require [clojure.test :refer :all]
            [sicp.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest addition-tests
    (is  (= 5  (+ 3 2)))
    (is  (= 10  (+ 5 5))))
