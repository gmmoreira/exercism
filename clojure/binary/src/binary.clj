(ns binary)

(declare transform valid-input?)

(defn to-decimal [n]
  (if-not (valid-input? n)
    0
    (->> n
         (reverse)
         (map-indexed transform)
         (apply +)
         (int))
    )
  )

(defn- valid-input? [n]
  (boolean (re-matches #"[01]+" n)))

(defn- transform [order c]
  (let [n (Character/getNumericValue c)]
    (-> (Math/pow 2 order)
        (* n))))