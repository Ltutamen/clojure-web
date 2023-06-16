(ns clojure-sandbox.core
  (:require [aleph.http :as aleph]
            [clojure.java.jdbc :refer :all]
            [hiccup-templating.views.contents :as contents]
            [hiccup-templating.views.layout :as layout]))

(defn get-body []
  (layout/application "Home" (contents/index)))

(defn upload-handle []
  (print-str "sfsf")
  )

(defn index-handle []
  {:status 200 :body (get-body) :headers {"Content-Type" "text/html"}})

(defn route[uri method]
  (cond
    (and (= uri "/upload" ) (= method "post")) (upload-handle)
    :else (index-handle)))

(defn app [req]
  (route (:uri req) (:request-method req)))


(defn -main
  [& _]
  (aleph/start-server (fn [req] (app req)) {:port 3001})
  (print-str "launched"))


;;https://ericnormand.me/clojure#
;;https://github.com/weavejester/hiccup
;;https://github.com/yokolet/hiccup-samples