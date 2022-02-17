(ns algorithm-clj.powersumdig
  (:require [clojure.string :as str]))

; The number 81 has a special property, a certain power of the sum of its digits is equal to 81 (nine squared).
; Eighty one (81), is the first number in having this property (not considering numbers of one digit).
; The next one, is 512. Let's see both cases with the details
;
; 8 + 1 = 9 and 92 = 81
;
; 512 = 5 + 1 + 2 = 8 and 83 = 512
;
; We need to make a function, power_sumDigTerm(), that receives a number n and may output the n-th term of this sequence of numbers.
; The cases we presented above means that
;
; power_sumDigTerm(1) == 81
;
; power_sumDigTerm(2) == 512


(defn power-number [x]
  (-> x
      str
      (str/split #"")
      ((fn [e] (map #(Integer/parseInt %1) e)))
      (#(apply + %1))
      (#(map (fn [e] (reduce * (repeat e %1))) (range 2 (-> x str count inc))))
      (#(some (fn [e] (= x e)) %1))))

(defn power-sum-dig-term [n]
  (nth (filter power-number (range 81 100000000)) (dec n)))