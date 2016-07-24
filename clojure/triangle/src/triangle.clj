(ns triangle)

(declare equilateral? isosceles? scalene? logical?)

(defn type [n1 n2 n3]
  (cond
    (not (logical? n1 n2 n3)) :illogical
    (equilateral? n1 n2 n3) :equilateral
    (isosceles? n1 n2 n3) :isosceles
    (scalene? n1 n2 n3) :scalene))

(defn- equilateral? [n1 n2 n3]
  (= n1 n2 n3))

(defn- isosceles? [n1 n2 n3]
  (or (= n1 n2)
      (= n1 n3)
      (= n2 n3)))

(defn- scalene? [n1 n2 n3]
  (and (not= n1 n2)
       (not= n2 n3)))

(defn- logical? [n1 n2 n3]
  (and (> (+ n1 n2) n3)
       (> (+ n1 n3) n2)
       (> (+ n2 n3) n1)))
