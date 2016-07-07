(ns leap)

(defn- divide-by-4? [year]
  (= (mod year 4) 0))

(defn- divide-by-100-and-not-400? [year]
  (and (= (mod year 100) 0)
       (not= (mod year 400) 0)))

(defn leap-year? [year]
  (if (divide-by-4? year)
    (if (divide-by-100-and-not-400? year)
      false
      true)
    false))
