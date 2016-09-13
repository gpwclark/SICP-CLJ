;; A summation procedure that uses linear recursion is provided, write an
;; equivalent fcn to compute summations iteratively

(ns sicp.chapter1.e30
  (:gen-class))

(defn recur-summation [term a next b]
  (if (> a b)
    0
    (+ (term a)
       (recur-summation term (next a) next b))))

(defn iter-summation [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (+ result (term a)))))
  (iter a 0))

(defn sum-integer-iter [a b]
  (let [term (fn [x]
               x)
        next (fn [x]
               (inc x))]
    (iter-summation term a next b)))

(defn sum-integer-recur [a b]
  (let [term (fn [x]
               x)
        next (fn [x]
               (inc x))]
    (recur-summation term a next b)))

