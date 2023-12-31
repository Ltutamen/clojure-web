(defproject clojure_sandbox "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/java.jdbc "0.7.12"]
                 [org.xerial/sqlite-jdbc "3.40.1.0"]
                 [ring/ring-core          "1.9.1"]
                 [ring/ring-jetty-adapter "1.9.1"]
                 [aleph/aleph "0.6.1"]
                 [hiccup "1.0.5"]
                 ]
  :main ^:skip-aot clojure-sandbox.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
