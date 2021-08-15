(ns memory-game.logic
  (:require [memory-game.fields :as fields]
            [clojure.set :as set]))

(def num-counter (atom 0))

;fn that increments and resets number counter
(defn inc-and-reset-num-counter [atom]
  (swap! num-counter inc)
  (reset! atom @num-counter))

;fn that returns set of random numbers without 0 and size of (level - 1)
(defn set-of-random-numbers [level]
  (remove #{0} (let [a-set (set (take level (repeatedly #(rand-int level))))]
                 (concat a-set (set/difference (set (take level (range)))
                                               a-set)))))

(def level (atom 1))
(def level-msg-atom (atom "Level 1"))

(def username (atom ""))

(def high-score-level (atom 1))
(def high-score-username (atom ""))

;fn that generates random board state with storing that state in vector-of-fields-state and reseting vector-of-fields-view,
;and also reseting level atom value
(defn random-board-state-generator []
  (loop [counter 0
         rnd (set-of-random-numbers (+ 1 @level))]
    (when (< counter @level)
      (reset! (fields/vector-of-fields-view counter) (nth rnd counter))
      (reset! (fields/vector-of-fields-state counter) (nth rnd counter))
      (recur (inc counter) rnd)))
  (reset! level (inc @level)))

;fn that checks if vector-of-fields-view and vector-of-fields-state are equal, and if yes then game level goes up. 
;Also, checks if current level is best result (high score)
(defn win? []
  (when (= (map #(conj [] @%) fields/vector-of-fields-view) (map #(conj [] @%) fields/vector-of-fields-state))
    (reset! level-msg-atom (str "Level " @level))
    (random-board-state-generator)
    (when (> @level @high-score-level)
      (reset! high-score-level (- @level 1))
      (reset! high-score-username @username))))

;"fn that checks if the game is over, if not then it calls fn win?. 
;If the game is over, this fn resets level-msg-atom with message 'GAME OVER'.
(defn game-over? [atom1 atom2]
  (if (not= @atom1 @atom2)
    (do (reset! level-msg-atom "GAME OVER")
        (reset! level 1))
    (win?)))

;fn that checks if the move is valid, and if is, fn calls inc-and-reset-num-counter and game-over? functions
(defn update-field-and-check-game-status [view-field state-field field-number]
  (and (= 0 @view-field) (> @level field-number) (do (inc-and-reset-num-counter view-field)
                                                     (game-over? view-field state-field))))

;fn for starting a new game
(defn start-new-game []
  (reset! num-counter 0)
  (reset! level 1)
  (reset! level-msg-atom "Level 1")
  ;(map #(reset! % 0) fields/vector-of-fields-view) - doesn't work here because of nested anonymus function, i'm not sure why
  ;(map #(reset! % 0) fields/vector-of-fields-state); - doesn't work here because of nested anonymus function, i'm not sure why
  ;I wrote reset! functions manually because of these reasons
  (reset! fields/f_1 0)
  (reset! fields/f_2 0)
  (reset! fields/f_3 0)
  (reset! fields/f_4 0)
  (reset! fields/f_5 0)
  (reset! fields/f_6 0)
  (reset! fields/f_7 0)
  (reset! fields/f_8 0)
  (reset! fields/f_9 0)
  (reset! fields/f_10 0)
  (reset! fields/f_11 0)
  (reset! fields/f_12 0)
  (reset! fields/f_13 0)
  (reset! fields/f_14 0)
  (reset! fields/f_15 0)
  (reset! fields/f_16 0)
  (reset! fields/f_17 0)
  (reset! fields/f_18 0)
  (reset! fields/f_19 0)
  (reset! fields/f_20 0)
  (reset! fields/f_21 0)
  (reset! fields/f_22 0)
  (reset! fields/f_23 0)
  (reset! fields/f_24 0)
  (reset! fields/f_25 0)
  (reset! fields/f_26 0)
  (reset! fields/f_27 0)
  (reset! fields/f_28 0)
  (reset! fields/f_29 0)
  (reset! fields/f_30 0)
  
  (reset! fields/f1 0)
  (reset! fields/f2 0)
  (reset! fields/f3 0)
  (reset! fields/f4 0)
  (reset! fields/f5 0)
  (reset! fields/f6 0)
  (reset! fields/f7 0)
  (reset! fields/f8 0)
  (reset! fields/f9 0)
  (reset! fields/f10 0)
  (reset! fields/f11 0)
  (reset! fields/f12 0)
  (reset! fields/f13 0)
  (reset! fields/f14 0)
  (reset! fields/f15 0)
  (reset! fields/f16 0)
  (reset! fields/f17 0)
  (reset! fields/f18 0)
  (reset! fields/f19 0)
  (reset! fields/f20 0)
  (reset! fields/f21 0)
  (reset! fields/f22 0)
  (reset! fields/f23 0)
  (reset! fields/f24 0)
  (reset! fields/f25 0)
  (reset! fields/f26 0)
  (reset! fields/f27 0)
  (reset! fields/f28 0)
  (reset! fields/f29 0)
  (reset! fields/f30 0)
  (random-board-state-generator))

;reset all members of vector-of-fields-view and num-counter
(defn reset-all-view-fields []
  (reset! num-counter 0)
  ;(map #(reset! % 0) fields/vector-of-fields-view) - dont' work here because of nested anonymus function, i'm not sure why
  (reset! fields/f1 0)
  (reset! fields/f2 0)
  (reset! fields/f3 0)
  (reset! fields/f4 0)
  (reset! fields/f5 0)
  (reset! fields/f6 0)
  (reset! fields/f7 0)
  (reset! fields/f8 0)
  (reset! fields/f9 0)
  (reset! fields/f10 0)
  (reset! fields/f11 0)
  (reset! fields/f12 0)
  (reset! fields/f13 0)
  (reset! fields/f14 0)
  (reset! fields/f15 0)
  (reset! fields/f16 0)
  (reset! fields/f17 0)
  (reset! fields/f18 0)
  (reset! fields/f19 0)
  (reset! fields/f20 0)
  (reset! fields/f21 0)
  (reset! fields/f22 0)
  (reset! fields/f23 0)
  (reset! fields/f24 0)
  (reset! fields/f25 0)
  (reset! fields/f26 0)
  (reset! fields/f27 0)
  (reset! fields/f28 0)
  (reset! fields/f29 0)
  (reset! fields/f30 0))

;fn that creates wathcers for all members of vector-of-fields-view
(defn create-watchers [renderer board]
  (add-watch fields/f1 :f1-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 1})))
  (add-watch fields/f2 :f2-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 2})))
  (add-watch fields/f3 :f3-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 3})))
  (add-watch fields/f4 :f4-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 4})))
  (add-watch fields/f5 :f5-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 5})))
  (add-watch fields/f6 :f6-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 6})))
  (add-watch fields/f7 :f7-watcher6
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 7})))
  (add-watch fields/f8 :f8-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 8})))
  (add-watch fields/f9 :f9-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 9})))
  (add-watch fields/f10 :f10-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 10})))
  (add-watch fields/f11 :f11-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 11})))
  (add-watch fields/f12 :f12-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 12})))
  (add-watch fields/f13 :f13-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 13})))
  (add-watch fields/f14 :f14-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 14})))
  (add-watch fields/f15 :f15-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 15})))
  (add-watch fields/f16 :f16-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 16})))
  (add-watch fields/f17 :f17-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 17})))
  (add-watch fields/f18 :f18-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 18})))
  (add-watch fields/f19 :f19-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 19})))
  (add-watch fields/f20 :f20-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 20})))
  (add-watch fields/f21 :f21-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 21})))
  (add-watch fields/f22 :f22-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 22})))
  (add-watch fields/f23 :f23-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 23})))
  (add-watch fields/f24 :f24-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 24})))
  (add-watch fields/f25 :f25-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 25})))
  (add-watch fields/f26 :f26-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 26})))
  (add-watch fields/f27 :f27-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 27})))
  (add-watch fields/f28 :f28-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 28})))
  (add-watch fields/f29 :f29-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 29})))
  (add-watch fields/f30 :f30-watcher
             (fn [key atom old-state new-state]
               (renderer {:fx/type board
                          :arg 30}))))