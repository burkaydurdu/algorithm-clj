(ns algorithm-clj.gapinprimes-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.gapinprimes :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is (= (gap 2,100,110) [101, 103]))
    (is (= (gap 4,100,110) [103, 107]))
    (is (= (gap 6,100,110) nil))
    (is (= (gap 8,300,400) [359, 367]))
    (is (= (gap 11 30000 100000) nil))
    (is (= (gap 10,300,400) [337, 347]))))
