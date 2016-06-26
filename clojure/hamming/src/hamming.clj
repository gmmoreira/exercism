(ns hamming
  (:require [clojure.string :as str])
  )

(defn- zip
  [coll1 coll2]
  (map vector coll1 coll2)
  )

(defn distance
  [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    nil
    (->>
      (zip strand1 strand2)
      (remove #(= (first %) (last %)))
      (count)
      )
    )
  )
