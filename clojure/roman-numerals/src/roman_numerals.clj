(ns roman-numerals)

(def ^:private letters ["I" "V" "X" "L" "C" "D" "M"])

(declare to-roman)

(defn numerals [n]
  (->> n
       (str)
       (reverse)
       (map-indexed to-roman)
       (reverse)
       (clojure.string/join)))

(defn- to-roman [order n]
  (let [low-index (* order 2)
        [low mid high] (subvec letters low-index)]
    (case n
      \0 ""
      \1 (str low)
      \2 (str low low)
      \3 (str low low low)
      \4 (str low mid)
      \5 (str mid)
      \6 (str mid low)
      \7 (str mid low low)
      \8 (str mid low low low)
      \9 (str low high))))
