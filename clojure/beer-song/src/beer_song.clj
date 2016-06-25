(ns beer-song
  (:require [clojure.string :as str])
  )

(defn- what-to-do-given
  [beers]
  (cond
    (> beers 1) "Take one down and pass it around, "
    (= beers 1) "Take it down and pass it around, "
    (= beers 0) "Go to the store and buy some more, "
    )
  )

(defn- sing-bottles-of
  [beers]
  (cond
    (> beers 1) (str beers " bottles")
    (= beers 1) "1 bottle"
    (= beers 0) "No more bottles"
    (= beers -1) "99 bottles"
    )
  )

(defn verse
  [beers]
  (str (str/capitalize (str (sing-bottles-of beers) " of beer on the wall, " (sing-bottles-of beers) " of beer.\n"
                            )
                       )
       (str/capitalize (str (what-to-do-given beers) (sing-bottles-of (- beers 1)) " of beer on the wall.\n"
                            )
                       )
       )
  )

(defn sing
  ([initial] (sing initial 0))
  ([initial end]
   (->> (range initial (- end 1) -1)
        (map verse)
        (str/join "\n")
        )
    )
  )
