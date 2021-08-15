(ns memory-game.core-test
  (:require [midje.sweet :as midje]
            [memory-game.fields :as fields]
            [memory-game.logic :as logic]))


(midje/fact "fn set-of-random-numbers with argument<2 should not return empty list (0 is removed from list)"
            (logic/set-of-random-numbers 1) midje/=> empty)

(midje/fact "fn set-of-random-numbers with argument>=2 should be size of (argument - 1)"
            (logic/set-of-random-numbers 5) midje/=> (fn [res]
                                                       (= (count res) 4)))

(midje/fact "first (level-1) fields should be different from 0, after fn random-board-state-generator was called"
            (logic/random-board-state-generator) midje/=> (fn [res]
                                                            (not= (nth fields/vector-of-fields-view (rand-int @logic/level)) 0)))

(midje/fact "when view and state atoms are not equal, the level-msg-atom has value 'GAME OVER'"
            (logic/game-over? (atom 1) (atom 1)) midje/=> (fn [res]
                                                            (not= @logic/level-msg-atom "GAME OVER")))

(midje/fact "when view and state atoms are equal, the level-msg-atom hasn't value 'GAME OVER'" 
            (logic/game-over? (atom 1) (atom 2)) midje/=> (fn [res]
                                                            (= @logic/level-msg-atom "GAME OVER")))

(midje/fact "after start-new-game is called, only f1 field should be filled with number 1" 
            (logic/start-new-game) midje/=> (fn [res]
                                              (and (= @fields/f1 1) (= @fields/f2 0))))                                                                         
(midje/fact "after reset-all-view-fields is called, all view atoms should be 0" 
            (logic/reset-all-view-fields) midje/=> (fn [res]
                                                     (= @fields/f1 0)))

(midje/fact "if move is not valid, fn should return false" 
            (logic/update-field-and-check-game-status (atom 1) (atom 1) 2) midje/=> false)
