(ns trinary)

(declare transform-base-3 valid-input?)

(defn to-decimal
  "Converts a base-3 number string to base-10 number."
  [n]
  (if-not (valid-input? n)
    0
    (let [trinary-to-decimal (partial transform-base-3 (count n))]
      (->> n
           (map-indexed trinary-to-decimal)
           (apply +)))))

(defn- valid-input? [exp]
  (boolean (re-matches #"[012]+" exp)))

(defn- transform-base-3 [length index c]
  (let [exponent (- length 1.0 index)]
    (-> c
        (Character/getNumericValue)
        (* (Math/pow 3.0 exponent))
        (int))))