(ns bob)
(require '[clojure.string :as string])

(defn empty-question? "Nothing was said."
  [text]
  (string/blank? text)
  )

(defn question? "Is it a question?"
  [question]
  (string/ends-with? question "?")
  )

(defn yelling? "Is he yelling?"
  [text]
  (let [
        upcase-seq (re-seq #"[A-Z]" text)
        downcase-seq (re-seq #"[a-z]" text)
        ]
    (and
      (empty? downcase-seq)
      (not (empty? upcase-seq))
      )
    )
  )

(defn response-for "What bob says."
  [question]
  (cond
    (bob/empty-question? question) "Fine. Be that way!"
    (bob/yelling? question) "Whoa, chill out!"
    (bob/question? question) "Sure."
    :else "Whatever."
   )
  )
