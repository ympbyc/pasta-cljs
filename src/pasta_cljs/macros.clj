;*CLJSBUILD-MACRO-FILE*;

(ns pasta-cljs.macros)

(defmacro deftransition
  "Define a function that receives the current state and returns a patch to it.
   The patch returned will get conjed onto the state.
   Use `watch-transition` to react to the state change."
  [name params & body]
  `(defn ~name [app# & pars#]
     (let [diff# (apply (fn ~params ~@body) (cons @app# pars#))
           new-state# (conj @app# diff#)]
       (doseq [[key-changed# _#] diff#]
         (when-let [f# (get (:watchers__special__ @app#) key-changed#)]
           (f# new-state# @app#)))
       (reset! app# new-state#))))
