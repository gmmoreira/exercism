(ns prime-factors)

(declare compute-prime-factors)

(defn of
  "Computes the prime factors of a numbers and returns a vector containing them"
  [n]
  (compute-prime-factors n))

(defn- compute-prime-factors
  ([n] (compute-prime-factors [] n 2))
  ([factors n counter]
   (if (= n 1)
     factors
     (if (= (mod n counter) 0)
       (recur (conj factors counter) (/ n counter) counter)
       (recur factors n (inc counter))))))
