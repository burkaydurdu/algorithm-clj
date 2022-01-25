(ns algorithm-clj.twisted-sum-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.twisted-sum :refer :all]))

(deftest simple-tests
  (is (= (compute-sum 1) 1))
  (is (= (compute-sum 2) 3))
  (is (= (compute-sum 3) 6))
  (is (= (compute-sum 4) 10))
  (is (= (compute-sum 10) 46)))