;; Write fcn to multiple 2 numbers that can only use +,-,double, and halve
;; and computers results in O(log(n)).

(ns sicp.chapter1.e17
  (:gen-class))

(defn double [n]
  (* 2 n))

(defn halve [n]
  (/ n 2))

(defn log*-help [a counter left ops]
  (println "ops: " ops)
  (if (= counter 1)
    (if (= left 1)
      a
      (+ a left))
    (if (even? counter)
      (recur (double a) (halve counter) left (inc ops))
      (recur  a (- counter 1) a (inc ops)))))

(defn log* [a b]
  (log*-help a b 1 1))
