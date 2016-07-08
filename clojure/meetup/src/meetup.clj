(ns meetup
  (:import (java.time LocalDate DayOfWeek)
           (java.time.temporal TemporalAdjusters)))

(def ^:private days-of-week {:monday    DayOfWeek/MONDAY
                             :tuesday   DayOfWeek/TUESDAY
                             :wednesday DayOfWeek/WEDNESDAY
                             :thursday  DayOfWeek/THURSDAY
                             :friday    DayOfWeek/FRIDAY
                             :saturday  DayOfWeek/SATURDAY
                             :sunday    DayOfWeek/SUNDAY})

(declare adjust-by-teenth adjust-by-ordinal)

(defn meetup [month year day-week type]
  [year month (case type
                :teenth (adjust-by-teenth year month day-week)
                :first (adjust-by-ordinal year month day-week 1)
                :second (adjust-by-ordinal year month day-week 2)
                :third (adjust-by-ordinal year month day-week 3)
                :fourth (adjust-by-ordinal year month day-week 4)
                :last (adjust-by-ordinal year month day-week -1)
                )])

(defn- day-of-week-in-month [year month day-week ord]
  (let [day-of-week (get days-of-week day-week)
        day-of-week-adjuster (TemporalAdjusters/dayOfWeekInMonth ord day-of-week)]
    (.. (LocalDate/of year month 1) (with day-of-week-adjuster))))

(defn- adjust-by-teenth [year month day-week]
  (loop [week-ord 1]
    (let [date (day-of-week-in-month year month day-week week-ord)
          day (.getDayOfMonth date)]
      (if (and (>= day 13)
               (<= day 19))
        day
        (recur (inc week-ord))))))

(defn- adjust-by-ordinal [year month day-week ordinal]
  (let [date (day-of-week-in-month year month day-week ordinal)]
    (.getDayOfMonth date)))
