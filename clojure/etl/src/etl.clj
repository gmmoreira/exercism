(ns etl
  (:require [clojure.string :as str]))

(defn- old->new [])
(defn transform [data]
  (reduce
    (fn [db [score words]]
      (reduce #(assoc %1 (str/lower-case %2) score) db words))
    {} data))
