(ns robot-name)

(def ^:private allowed-numbers (range 0 10))
(def ^:private allowed-letter (map char (range 65 91)))
(def ^:private robot-list [])

(defn- get-random-letter
  []
  (rand-nth allowed-letter)
  )

(defn- get-random-number
  []
  (rand-nth allowed-numbers)
  )

(defn- generate-name
  []
  (str (get-random-letter)
       (get-random-letter)
       (get-random-number)
       (get-random-number)
       (get-random-number)
    )
  )

(defn- get-new-robot-id
  []
  (count robot-list)
  )

(defn- get-robot-by-id
  [robot]
  (robot-list (robot :id))
  )

(defn robot
  []
  (let [robot-id (get-new-robot-id)
        new-robot { :id robot-id :name (generate-name) }
        ]
    (def robot-list (conj robot-list new-robot))
    new-robot
    )
  )

(defn robot-name
  [robot]
  ((get-robot-by-id robot) :name)
  )

(defn reset-name
  [robot]
  (let [new-robot (assoc robot :name (generate-name))
        ]
    (def robot-list (assoc robot-list (robot :id) new-robot))
    new-robot
    )
  )
