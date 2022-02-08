(ns algorithm-clj.human-readable
  (:require [clojure.string :as str]))

;; Your task in order to complete this Kata is to write a function which formats a duration,
;; given as a number of seconds, in a human-friendly way.

;; The function must accept a non-negative integer. If it is zero, it just returns "now".
;; Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.

;; It is much easier to understand with an example:

;; * For seconds = 62, your function should return
;;    "1 minute and 2 seconds"
;;* For seconds = 3662, your function should return
;;   "1 hour, 1 minute and 2 seconds"

;; Time sec 965
;; Time 965 % 60 = sec
;; Time 965 / 60 = min
;; Time min % 60 = min
;; Time min / 60 = ho
;; Time ho % 24 = ho
;; Time ho / 24 = da
;; Time da % 365 = da
;; Time da / 365 = ye

(defn formatDuration [secs]
  (let [second (mod secs 60)
        min    (quot secs 60)
        minute (mod min 60)
        hou    (quot min 60)
        hour   (mod hou 24)
        da     (quot hou 24)
        day    (mod da 365)
        year   (quot da 365)
        rr     {:year year
                :day day
                :hour hour
                :minute minute
                :second second}
        result (->> rr
                    (filterv (fn [[_ v]] (> v 0)))
                    (mapv (fn [[k v]] (if (> v 1) (str v " " (name k) "s") (str v " " (name k))))))]
    (case (count result)
      0 "now"
      1 (first result)
      (str (str/join #", " (drop-last result)) " and " (last result)))))