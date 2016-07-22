(ns space-age)

(defn- age-in-years
  [person-age-in-seconds earth-years]
  (let [earth-orbital-period-in-seconds 31557600.0]
    (/ person-age-in-seconds (* earth-orbital-period-in-seconds earth-years))))

(defn on-earth
  [age]
  (let [earth-years 1.0]
    (age-in-years age earth-years)))

(defn on-mercury
  [age]
  (let [earth-years 0.2408467]
    (age-in-years age earth-years)))

(defn on-venus
  [age]
  (let [earth-years 0.61519726]
    (age-in-years age earth-years)))

(defn on-mars
  [age]
  (let [earth-years 1.8808158]
    (age-in-years age earth-years)))

(defn on-jupiter
  [age]
  (let [earth-years 11.862615]
    (age-in-years age earth-years)))

(defn on-saturn
  [age]
  (let [earth-years 29.447498]
    (age-in-years age earth-years)))

(defn on-uranus
  [age]
  (let [earth-years 84.016846]
    (age-in-years age earth-years)))

(defn on-neptune
  [age]
  (let [earth-years 164.79132]
    (age-in-years age earth-years)))
