(ns behrica.specter-x
  (:require 
   [com.rpl.specter :refer :all])

  )

(defn shorten-string [s]
  (if (> (count s) 1000)
    (str (.substring s 0 1000) " ...")
    s)
  )

(defn info [x]
  (cond (string? x)   (shorten-string x)
        (map? x) (str "keys: "(keys x)) 
        (sequential? x) (str "count: " (count x))
        true x))
  
  
(defnav INFO []
    (select* [this structure next-fn] 
             (next-fn (info structure)))
  (transform* [this structure next-fn]
              nil))
