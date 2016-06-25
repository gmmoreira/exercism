(ns anagram
  (:require [clojure.string :as str])
  )

(defn- get-anagram-seq
  [word]
  (->> word (re-seq #"\w") (frequencies)
       )
  )

(defn- anagram-word-predicate [word]
  "Return a predicate function"
  (let [lower-case-word (str/lower-case word)
        word-anagram (get-anagram-seq lower-case-word)]
    (fn [candidate]
      (let [lower-case-candidate (str/lower-case candidate)]
        (and (not= lower-case-word lower-case-candidate)
             (= word-anagram (get-anagram-seq lower-case-candidate))
             )
        )
      )
    )
  )

(defn anagrams-for
  [word candidates-list]
  (filter (anagram-word-predicate word) candidates-list
          )
  )


