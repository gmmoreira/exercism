(ns scrabble-score)

(def scores {
             1  #"[AEIOULNRST]"
             2  #"[DG]"
             3  #"[BCMP]"
             4  #"[FHVWY]"
             5  #"K"
             8  #"[JX]"
             10 #"[QZ]"
             })

(defn score-letter [letter]
  (score-word letter))

(defn score-word [word]
  (let [upper-word (clojure.string/upper-case word)]
    (reduce (fn [current-score [score table]]
              (+ current-score (* score (count (re-seq table upper-word)))))
            0 scores)))
