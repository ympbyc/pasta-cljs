(defproject pasta-cljs "0.1.2"
  :description "App as a value"
  :url "http://github.com/ympbyc/pasta-cljs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins      [[lein-cljsbuild "0.3.2"]]
  :cljsbuild {:builds [{:source-paths ["src"]
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :none
                                   :pretty-print true}}]})
