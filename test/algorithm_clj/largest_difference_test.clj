(ns algorithm-clj.largest-difference-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.largest-difference :refer :all]))

(deftest test-largest-difference
  (is (= (largestDifference [9 4 1 10 3 4 0 -1 -2]) 4))  ; data[1] <= data[5], so 5 - 1 = 4
  (is (= (largestDifference [3 2 1]) 0)))                ; never finds i<j such that data[i] <= data[j]