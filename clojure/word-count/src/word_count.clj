(ns word-count
  (:require [clojure.string :as string])
  )

(defn split-words
  [phrase]
  (string/split phrase #" ")
  )

(defn count-words
  [words]
  (reduce (fn [map, current-word]
            (if (contains? map current-word)
              (->> current-word (get map) (+ 1) (assoc map current-word))
              (assoc map current-word 1)
              )) {} words)
  )

(defn word-count
  [phrase]
  (-> phrase (split-words) (count-words))
  )
