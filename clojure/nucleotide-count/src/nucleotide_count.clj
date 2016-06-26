(ns nucleotide-count
  (:refer-clojure :exclude [count])
  )

(def valid-nucleotides [\A \C \G \T])

(defn-
  valid-nucleotide?
  [nucleotide]
  (some #(= nucleotide %) valid-nucleotides)
  )

(defn count
  [nucleotide dna]
  (when-not (valid-nucleotide? nucleotide)
    (throw (AssertionError. (str nucleotide " is not valid."))
           )
    )
  (->> dna
       (filter #(= nucleotide %))
       (clojure.core/count)
       )
  )

(defn nucleotide-counts
  [dna]
  (reduce
    #(assoc %1 %2 (count %2 dna))
    {} valid-nucleotides)
  )