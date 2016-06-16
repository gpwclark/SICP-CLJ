;; computer elements of pascals triangle recursively.

(ns sicp.chapter1.e12
  (:gen-class))

(defn get-parentR [elem-info]
  (let [row (first elem-info)
        place (first (rest elem-info))
        value (first (rest (rest elem-info)))]
    (if (= -1 place)
      nil
      (- value (- row 1)))))

(defn get-parentL [elem-info]
  (let [row (first elem-info)
        place (first (rest elem-info))
        value (first (rest (rest elem-info)))]
    (if (= place (* row -1))
      nil
      (- value row))))

(defn get-level [elem count]
  (let [rem (- elem count)]
    (if (< rem 0)
      [count rem]
      (recur rem (inc count)))))

(defn value-pascals-triangle [elem]
  ;; elem-info is a vector, the first element represents the row
  ;; of pascal's triangle, and the second elem represents the
  ;; place in the row, -1 is the rightmost place, and -(row) is the
  ;; leftmost place in the row. Third element is the original value
  ;; of the element.
  (if (= elem nil)
    0
    (let [elem-info (get-level elem 1)
          elem-info (conj elem-info elem)]
    (case elem
      0 1
      1 1
      2 1
      (+ (value-pascals-triangle (get-parentL elem-info))
         (value-pascals-triangle (get-parentR elem-info)))))))
