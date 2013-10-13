# pasta-cljs

State transformers and watchers.

# Installation

The artifact hasn't been created yet


## Usage

...


## Examples

```clojure
(ns your-app
  (use [pasta.core :only [watch-transition]])
  (use-macros [pasta.macros :only [deftransition]]))


;; Create an atom of a map to hold the entire state of the app.
;; Put everything you need to reconstruct the view.
(def app (atom {:page 1
                :loading :false}))


;;;;; PURE ;;;;;

;; Deftransition defines a function that takes the current state and arbitrary
;; number of arguments and returns a diff map to the state.
;; No side-effectful operation should happen in a transition.
(deftransition stop-load [_state]
  {:loading false})

(deftransition next-page [{:keys [page]}]
  {:page (inc page)
   :loading true})

(deftransition prev-page [{:keys [page]}]
  {:page (dec page)
   :loading true})

(deftransition page-to [_state page-n]
  {:page page-n
   :loading true})




;;;;; IMPURE ;;;;;


;; Watch-transion registers a side-effectful function that will get invoked
;; whenever the specified field of the state changes.
;; Do not mess with the state in a watcher.
(watch-transition app :load
                  (fn [{:keys [loading]} _old-state]
                    (if loading
                      (.show (js/jQuery ".loading-indicator"))
                      (.hide (js/jQuery ".loading-indicator")))))


(watch-transition app :page
                  (fn [st]
                    ;; retrieve html, replace the content, etc.
                    (stop-load app)))


(.on js/document "click" (js/jQuery ".next-btn")
     #(next-page app))

(.on js/document "click" (js/jQuery ".prev-btn")
     #(prev-page app))

(.on js/document "click" (js/jQuery ".pager")
     #(page-to app (.getAttribute (.-target %) "data-page")))

;;....
```


## License

Copyright © 2013 Minori Yamashita <ympbyc@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure.
