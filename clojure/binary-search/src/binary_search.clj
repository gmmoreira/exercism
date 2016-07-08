(ns binary-search)

(defn middle [coll]
  (let [c (Integer. (count coll))]
  (Math/floorDiv c 2)))

(defn search-for [n coll]
  (loop [position 0
         coll (vec coll)]
    (let [m (middle coll)
          e (get coll m)]
      (when (and (= 1 (count coll))
                 (not= e n))
        (throw (Exception. "not found")))
      (if (= n e)
        (+ position m)
        (if (< n e)
          (recur position (subvec coll 0 m))
          (recur (+ position m 1) (subvec coll (inc m))))))))
