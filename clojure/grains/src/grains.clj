(ns grains)

(defn square
  [n]
  (->> (dec n)
       (.pow (biginteger 2))
       (bigint)))

(defn total
  []
  (->> (range 1 65)
       (map square)
       (apply +')))
