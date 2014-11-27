(ns rostockparts.penholder
  (:refer-clojure :exclude [import use])
  (:use [scad-clj.scad]
        [scad-clj.model]))

(def effector-bolts-radius 25.0)
(def bolt-hole-radius 2.1)
(def pen-hole-inner-radius 7.0)
(def pen-hole-outer-radius 17.0)
(def pen-hole-outer-height 30)
(def pen-nut-width 7.5)
(def pen-nut-depth 3.5)


(defn radians [deg]
  (* (/ deg 180.0) Math/PI))


; The rostock effector platform - loaded here just to check that the part will fit
(def effector-mesh (import "/Users/jules/devel/3DPrinting/models/rostock parts/70832 platform r2 rostockv2-effector.stl"))

(def effector
  (rotate (radians -30.0) [0 0 1]
    (translate [-43.5 -40 0]
      effector-mesh)))

(def tri-plate
  (with-fn 3 (cylinder 50 10)))

(def pen-hole
  (with-fn 6 (cylinder pen-hole-inner-radius 100)))

(def pen-hole-outer
  (union
    (translate [(+ pen-hole-inner-radius 1) 0 10.0 ]
      (rotate (radians 30) [1 0 0]
        (rotate (radians 90) [0 1 0]
          (intersection
            (with-fn 6 (cylinder (/ pen-hole-outer-radius 2.0) 15))
            (with-fn 64 (cylinder (/ pen-hole-outer-radius 2.1) 15))
            ))))
    (translate [(+ pen-hole-inner-radius 3.5) 0 0] (cube 10 10 10))
    (translate [0 0 (- (/ pen-hole-outer-height 2.0) 5)]
      (intersection
        (rotate (radians 30) [0 0 1]
          (with-fn 6 (cylinder [pen-hole-outer-radius (* pen-hole-outer-radius 0.5)] pen-hole-outer-height)))
        (with-fn 64 (cylinder [(* pen-hole-outer-radius 0.95) (* pen-hole-outer-radius 0.5 0.95)] pen-hole-outer-height))))))

(def pen-screw-hole
  (translate [20 0 (- (/ pen-hole-outer-height 2) 5)]
    (rotate (radians 90) [0 1 0]
      (with-fn 32 (cylinder 2 40)))))

(def leg
  (union
    (translate [(/ effector-bolts-radius 2.0) 0 0]
      (cube effector-bolts-radius 10 10))
    (translate [effector-bolts-radius 0 0]
      (with-fn 32 (cylinder 5 10)))))

(def legs
  (union
    (map #(rotate (* % (/ tau 3.0)) [0 0 1] leg)
         (range 3))))
         
(def legs-cut
  (difference
    ;(intersection
      legs
      ;(translate [0 0 -95] (with-fn 64 (sphere 100)))
      ;)
    (translate [0 0 4]
      ;(difference
        (cylinder (* effector-bolts-radius 2) 10)
        ;(cylinder (- effector-bolts-radius 4) 10))
      ;)
    )))

(def pen-nut-capture
  (translate [(/ (+ pen-hole-inner-radius pen-hole-outer-radius) 2.2) 0 12]
    (cube pen-nut-depth pen-nut-width (* pen-nut-width 2))))

(def effector-bolt-holes
  (map #(rotate (* % (/ tau 3.0)) [0 0 1]
          (translate [effector-bolts-radius 0 0]
            (with-fn 32 (cylinder bolt-hole-radius 20))))
       (range 3)))

(def corner-cuts
  (map #(rotate (* % (/ tau 6.0)) [0 0 1]
          (translate [(* pen-hole-outer-radius 1.165) 0 20]
            (if (zero? (mod % 2)) 
              (with-fn 6 (cylinder 10 30))
              (with-fn 6 (cylinder 10 125))
             
             ) ))
       (range 1 6)))


(def part
  (difference
    (union
      legs-cut
      ;tri-plate
      ;effector
      pen-hole-outer)
    pen-nut-capture
    effector-bolt-holes
    pen-hole
    pen-screw-hole
    corner-cuts 
    ))



(spit "output/penholder.scad" (write-scad part))
