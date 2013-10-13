(ns pasta-cljs.core)

(defn watch-transition
  "Watch for state transition of a field.
   The watcher fn will receive new-state and old-state.
   The watcher fn should perform side-effectful operation.
   Typically used to keep the view in sync with the state."
  [app key f]
  (swap! app (fn [{watchers :watchers__special__ :as state}]
               (assoc state :watchers__special__
                      (assoc watchers key f)))))
