(ns clojure-samples.core-test
  (:require [clojure.test :refer :all]
            [clojure-samples.core :as core]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defspec test-reverse
  100
  (prop/for-all [s (gen/vector gen/small-integer)]
                (= (reverse (reverse s)) s)))

(defspec prop-add
  {:num-tests 30}
  (prop/for-all [a gen/small-integer
                 b gen/small-integer]
    (= (core/add a b) (+ a b))))
