(defproject pasta-cljs "0.1.0-SNAPSHOT"
  :description "App as a value"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler {:output-to "resources/public/js/pasta-cljs.js"
                                   :optimizations :simple
                                   :pretty-print false}}]})
