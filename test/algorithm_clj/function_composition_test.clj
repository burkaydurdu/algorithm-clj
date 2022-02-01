(ns algorithm-clj.function-composition-test
  (:require [clojure.test :refer :all]
            [algorithm-clj.function-composition :refer :all]))


; Sample function:
(defn id [n] (do n))

(deftest composition-example-test
  (is (= ((compose (partial + 1) id) 0) 1)))