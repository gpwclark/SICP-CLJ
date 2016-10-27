;; investigating this business of lambda calculus and procedural representations
;; of numbers.

(ns sicp.chapter2.e24-26
  (:gen-class))

;; Ex. 2.4
;; Here is a procedural representation of pairs. For this representation verify that
;; (car (cons x y)) yields x for any objects x and y.

(defn mcons [x y]
  (fn [m] (m x y)))

(defn car [z]
  (z (fn [p q] p)))

;; what is the corresponding defintion of cdr?
(defn cdr [z]
  (z (fn [p q] q)))
;; ... I'm melting

(defn zero
  ;; zero is a function that when evaluated returns a function that takes 1 arguemnts
  ;; that returns a function that returns its argument.

  []
  (fn [f]
    (fn [y] y)))

(defn add-1 [n]
  (fn [f]
    (fn [y]
      (f ((n f) y)))))
