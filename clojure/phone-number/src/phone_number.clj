(ns phone-number
  (:require [clojure.string :as str])
  )

(defn- clean-number
  [number]
  (->> number
       (re-seq #"\d")
       (str/join)
       )
  )

(defn number
  [phone-number]
  (if-let
    [[_ m] (->> phone-number
                (clean-number)
                (re-find #"^1?(\d{10})$")
                )
     ]
    m
    "0000000000"
    )
  )

(defn area-code
  [phone-number]
  (->> phone-number
       (number)
       (take 3)
       (str/join)
       )
  )

(defn pretty-print
  [phone-number]
  (let [[_ area g1 g2] (re-find #"(\d{3})(\d{3})(\d{4})" (number phone-number)
                                )
        ]
    (format "(%s) %s-%s" area g1 g2)
    )
  )