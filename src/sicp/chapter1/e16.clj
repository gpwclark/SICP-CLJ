(ns sicp.chapter1.e16
  (:gen-class))

(defn even? [n]
 (= (mod n 2) 0))

(defn fast-expt-iter-help [b counter a ops]
  (println "ops: " ops)
  (if (= counter 1)
    a
    (if (even? counter)
      (fast-expt-iter-help b (/ counter 2) (* a (* b b)) (inc ops))
      (fast-expt-iter-help b (- counter 1) (* a b) (inc ops)))))

(defn fast-expt-iter [b counter]
  (fast-expt-iter-help b counter 1 1))
