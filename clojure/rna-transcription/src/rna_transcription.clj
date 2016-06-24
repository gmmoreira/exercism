(ns rna-transcription
  (:require [clojure.string :as string])
  )

(defn dna-to-rna
  [dna]
  (case dna
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError.))
    )
  )

(defn to-rna
  [dna]
  (string/join (map dna-to-rna (seq dna)))
  )
