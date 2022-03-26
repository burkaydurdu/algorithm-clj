(ns algorithm-clj.gapinprimes)

(comment
  g (integer >= 2) which indicates the gap we are looking for

  m (integer > 2) which gives the start of the search (m inclusive)

  n (integer >= m) which gives the end of the search (n inclusive)

  n won't go beyond 1100000.)

;(defn abs [n] (max n (- n)))

(defn prime? [value]
  (let [end-date (quot value 2)]
    (if (<= value 1)
      false
      (->> (range 2 (inc end-date))
           (map #(mod value %))
           (some zero?)
           (not)))))

(defn next-prime [value]
  (if (prime? value)
    value
    (next-prime (inc value))))

;; Solution 1
;(defn gap [g m n]
;  ""
;  (let [rang (keep #(when (prime? %1) %1) (range m (inc n)))]
;    (some #(when (= (abs (reduce - %1)) g) %1) (partition 2 1 rang))))

;; Solution 2
;(defn gap [g m n]
;  (loop [f (next-prime m)
;         l (next-prime (inc f))]
;    (cond
;      (= (abs (- f l)) g) [f l]
;      (> l n) nil
;      :else (recur l (next-prime (inc l))))))

;; Solution 3
(defn gap [g m n]
  (loop [f (next-prime m)]
    (cond
      (> (+ f g) n) nil
      (and (prime? (+ f g)) (= (next-prime (inc f)) (+ f g))) [f (+ f g)]
      :else (recur (next-prime (inc f))))))
