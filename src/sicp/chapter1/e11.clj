;; Recursive and iterative impl of following function:
;; f(n) = n   if n < 3
;; f(n) = f(n-1)+2*f(n-2)+3*f(n-3) if n >= 3

(ns sicp.chapter1.e11
  (:gen-class))

(defn iter-impl-help [count n n1 n2 n3] ;;vec_size (count answer-vec)
  (let [result (+ n1
                  (* 2 n2)
                  (* 3 n3))]
    (if (< count n) ;; count starts at 3 and runs until it passes n
      (recur (inc count) n result n1 n2)
      result)))


(defn iter-impl [n]
  (if (< n 3)
    n
    (iter-impl-help 3 n 2 1 0)))

(defn recur-impl [n]
  (if (< n 3)
    n
    (+ (recur-impl (- n 1))
       (* (recur-impl (- n 2)) 2)
       (* (recur-impl (- n 3)) 3))))
