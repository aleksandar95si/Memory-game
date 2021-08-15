(ns memory-game.core
  (:require [memory-game.fields :as fields]
            [memory-game.logic :as logic]
            [cljfx.api :as fx])
  (:gen-class))

(def renderer (fx/create-renderer))

(def rules (slurp "resources/Rules.txt"))

(defn board [{:keys [arg]}]
  {:fx/type :stage
   :showing true
   :title "Memory game"
   :scene {:fx/type :scene
           :root {:fx/type :tab-pane
                  :pref-width 415
                  :pref-height 400
                  :tabs [{:fx/type :tab
                          :text "Game"
                          :closable false
                          :content {:fx/type :anchor-pane
                                    :children [{:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 10
                                                :text (str @fields/f1)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f1 fields/f_1 1))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 10
                                                :text (str @fields/f2)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f2 fields/f_2 2))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 10
                                                :text (str @fields/f3)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f3 fields/f_3 3))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 10
                                                :text (str @fields/f4)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f4 fields/f_4 4))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 10
                                                :text (str @fields/f5)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f5 fields/f_5 5))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 70
                                                :text (str @fields/f6)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f6 fields/f_6 6))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 70
                                                :text (str @fields/f7)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f7 fields/f_7 7))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 70
                                                :text (str @fields/f8)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f8 fields/f_8 8))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 70
                                                :text (str @fields/f9)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f9 fields/f_9 9))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 70
                                                :text (str @fields/f10)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f10 fields/f_10 10))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 130
                                                :text (str @fields/f11)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f11 fields/f_11 11))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 130
                                                :text (str @fields/f12)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f12 fields/f_12 12))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 130
                                                :text (str @fields/f13)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f13 fields/f_13 13))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 130
                                                :text (str @fields/f14)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f14 fields/f_14 14))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 130
                                                :text (str @fields/f15)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f15 fields/f_15 15))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 190
                                                :text (str @fields/f16)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f16 fields/f_16 16))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 190
                                                :text (str @fields/f17)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f17 fields/f_17 17))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 190
                                                :text (str @fields/f18)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f18 fields/f_18 18))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 190
                                                :text (str @fields/f19)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f19 fields/f_19 19))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 190
                                                :text (str @fields/f20)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f20 fields/f_20 20))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 250
                                                :text (str @fields/f21)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f21 fields/f_21 21))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 250
                                                :text (str @fields/f22)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f22 fields/f_22 22))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 250
                                                :text (str @fields/f23)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f23 fields/f_23 23))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 250
                                                :text (str @fields/f24)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f24 fields/f_24 24))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 250
                                                :text (str @fields/f25)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f25 fields/f_25 25))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 10
                                                :anchor-pane/top 310
                                                :text (str @fields/f26)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f26 fields/f_26 26))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 70
                                                :anchor-pane/top 310
                                                :text (str @fields/f27)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f27 fields/f_27 27))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 130
                                                :anchor-pane/top 310
                                                :text (str @fields/f28)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f28 fields/f_28 28))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 190
                                                :anchor-pane/top 310
                                                :text (str @fields/f29)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f29 fields/f_29 29))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 48
                                                :max-width 48
                                                :anchor-pane/left 250
                                                :anchor-pane/top 310
                                                :text (str @fields/f30)
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/update-field-and-check-game-status fields/f30 fields/f_30 30))}
                                               {:fx/type :button
                                                :padding 17
                                                :min-width 100
                                                :anchor-pane/left 310
                                                :anchor-pane/top 310
                                                :text @logic/level-msg-atom
                                                :style {:-fx-background-color (if (= @logic/level-msg-atom "GAME OVER")
                                                                                :red
                                                                                :silver)}}
                                               {:fx/type :label
                                                :anchor-pane/left 310
                                                :anchor-pane/top 250
                                                :text "Username:"}
                                               {:fx/type :text-field
                                                :min-width 100
                                                :max-width 100
                                                :anchor-pane/left 310
                                                :anchor-pane/top 270 
                                                :text @logic/username
                                                :on-text-changed (fn [text]
                                                                   (reset! logic/username text))}

                                               {:fx/type :button
                                                :padding 15
                                                :min-width 100
                                                :anchor-pane/left 310
                                                :anchor-pane/top 10
                                                :style {:-fx-background-color :#50C878}
                                                :text "Start new \n   game"
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/start-new-game))}
                                               {:fx/type :button
                                                :padding 15
                                                :min-width 100
                                                :anchor-pane/left 310
                                                :anchor-pane/top 80 ;90
                                                :style {:-fx-background-color :#FFE5B4}
                                                :text "Click here \nwhen you \nare ready"
                                                :on-mouse-clicked (fn [_]
                                                                    (logic/reset-all-view-fields))}]}}
                         {:fx/type :tab
                          :text "High score"
                          :closable false
                          :content {:fx/type :anchor-pane
                                    :children [{:fx/type :label
                                                :anchor-pane/left 20
                                                :anchor-pane/top 20
                                                :style {:-fx-underline true
                                                        :-fx-font "20 arial"}
                                                :text "High score:"}
                                               {:fx/type :label
                                                :anchor-pane/left 20
                                                :anchor-pane/top 50
                                                :style {:-fx-font "20 arial"}
                                                :text (str "Username: " @logic/high-score-username)}
                                               {:fx/type :label
                                                :anchor-pane/left 20
                                                :anchor-pane/top 80
                                                :style {:-fx-font "20 arial"}
                                                :text (str "Level: " @logic/high-score-level)}]}}
                         {:fx/type :tab
                          :text "Rules"
                          :closable false
                          :content {:fx/type :v-box
                                    :style {:-fx-background-color :#FFE5B4}
                                    :children [{:fx/type :label
                                                :padding 10
                                                :text rules}]}}]}}})

(logic/create-watchers renderer board)

(defn -main
  [& args]
  (renderer {:fx/type board
             :arg 0}))
