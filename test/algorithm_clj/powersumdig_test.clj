(ns algorithm-clj.powersumdig-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.powersumdig :refer :all]))

(defn do-test [n ans]
  (is (= (power-sum-dig-term n) ans)))

(deftest a-test1
  (testing "Basic Tests power-sum-dig-term"
    (do-test 1 81)
    (do-test 2 512)
    (do-test 3 2401)
    (do-test 4 4913)))