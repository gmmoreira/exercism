(ns grade-school)

(defn- add-student-to-grade
  [students student]
  (conj students student)
  )

(defn- store-grade
  [old-db g students]
  (merge old-db
         {g students}
         )
  )

(defn grade
  [db g]
  (get db g [])
  )

(defn add
  [db student g]
  (let [ get-students-by-grade (partial grade db)
          store-in-db (partial store-grade db g)
        ]
    (-> g
        (get-students-by-grade)
        (add-student-to-grade student)
        (store-in-db)
        )
    )
  )

(defn- get-ordered-students
  [db g]
  (sort (get db g))
  )

(defn sorted
  [db]
  (->> db
      (keys)
      (sort)
      (reduce
        #(assoc %1 %2 (get-ordered-students db %2))
        {}
        )
      )
  )
