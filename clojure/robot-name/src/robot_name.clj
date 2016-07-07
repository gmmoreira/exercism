(ns robot-name)

(def ^:private allowed-numbers (range 0 10))
(def ^:private allowed-letter (map char (range 65 91)))

(defn- get-random-letter
  []
  (rand-nth allowed-letter))

(defn- get-random-number
  []
  (rand-nth allowed-numbers))

(defn- generate-name
  []
  (str (get-random-letter)
       (get-random-letter)
       (get-random-number)
       (get-random-number)
       (get-random-number)))

(defn robot
  []
  (atom {:name (generate-name)}))

(defn robot-name
  [robot]
  (:name @robot))

(defn reset-name
  [robot]
  (swap! robot assoc :name (generate-name)))
