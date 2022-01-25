(ns algorithm-clj.twisted-sum)

;; Question: Find the sum of the digits of all the numbers from 1 to N (both ends included).

;; Example

;; # N = 4
;; 1 + 2 + 3 + 4 = 10
;;
;; # N = 10
;; 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + (1 + 0) = 46
;;
;; # N = 12
;; 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + (1 + 0) + (1 + 1) + (1 + 2) = 51

;123 % 10 = 3
;123 / 10 = 12
;12 % 10 = 2
;12 / 10 = 1
;1 % 10 = 1

(defn digit-sum
  ([num] (digit-sum num 0))
  ([num sum]
   (if (zero? num)
     sum
     (digit-sum (quot num 10) (+ sum (mod num 10))))))

(defn compute-sum [n]
  (reduce #(+ %1 (digit-sum %2)) (range (inc n))))