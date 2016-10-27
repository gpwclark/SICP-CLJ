;; 1. Write a procedure that returns the product of the values of a function at
;; points over a given range.
;; 2. Show how to define factorial in terms of product.
;; 3. Also use product to compute approximations of pi using the formula.
;; (/ pi 4) = (/ (* 2 4 4 6 6 8 ...) (* 3 3 5 5 7 7 ...))
(ns sicp.chapter1.e31
  (:gen-class))

;; 1 - (need to go back and figure out how to keep a SO from occurring)
(defn recur-product-SO [term a next b]
  (if (> a b)
    1
    (* (term a)
       (recur-product-SO term (next a) next b))))

(defn iter-product [term a next b]
  (defn iter [a result]
    (if (> a b)
      result
      (iter (next a) (* result (term a)))))
  (iter a 1N)) ;;N makes result a bigint to prevent overflow

(defn prod-integer-iter [a b]
  (let [term (fn [x]
               x)
        next (fn [x]
               (inc x))]
    (iter-product term a next b)))

(defn prod-integer-recur [a b]
  (let [term (fn [x]
               x)
        next (fn [x]
               (inc x))]
    (recur-product-SO term a next b)))

;; 2 - It's so beautiful and so concise.
(defn factorial [n]
   (prod-integer-iter 1 n))


;; 3
(defn wallis-pattern-from [n times]
  (let [term (fn [x]
               x)
        next (fn [x]
               (+ x 2))
        until (fn [x]
                (if (odd? x)
                  (+ n (* 2 times)) 
                  (- (+ n (* 2 times)) 2)))]
    (iter-product term n next (until n))))

(defn numer-pattern [p]
  (let [numer (wallis-pattern-from 4 p)
        last-num (+ 4 (* 2 (- p 1)))]
    (* numer (/ numer last-num)))

(defn denom-pattern [p]
  (let [denom (wallis-pattern-from 1 p)]
    (* denom denom)))

(defn wallis-product
  ;; where this-precise is a number that indicates something that is certainly
  ;; indicative of precision but much like this tautology fails to pin exactly
  ;; what this is while still doing exactly what you would expect.
  [this-precise]
  (let [numer (numer-pattern this-precise)
        denom (denom-pattern this-precise)]
    (* 8 (/ numer denom))))

