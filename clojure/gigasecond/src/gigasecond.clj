(ns gigasecond
  (:import (java.time LocalDateTime Duration)))

(def ^:private gs-duration (Duration/ofSeconds 1000000000))

(declare calculate-anniversary format-output)

(defn from [year month day]
  (-> (calculate-anniversary year month day)
      (format-output)))

(defn- calculate-anniversary [year month day]
  (-> (LocalDateTime/of year month day 0 0)
      (.plus gs-duration)))

(defn- format-output [date]
  [(.getYear date) (.getMonthValue date) (.getDayOfMonth date)])
