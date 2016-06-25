(ns word-count
  (:require [clojure.string :as string])
  )

(defn split-words
  [phrase]
  (let [normalize-case #(string/lower-case %)
        split-pattern #"[^\w]+"
        split #(string/split % split-pattern)]
    (-> phrase (normalize-case) (split))
    )
  )

(defn group-words
  [words]
  (reduce (fn [map, current-word]
            (if (contains? map current-word)
              (->> current-word (get map) (+ 1) (assoc map current-word))
              (assoc map current-word 1)
              )) {} words)
  )

(defn word-count
  [phrase]
  (-> phrase (split-words) (group-words))
  )
