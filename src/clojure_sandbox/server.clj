(ns clojure-sandbox.server
  (:require [clojure.java.jdbc :refer :all]
            [aleph.http :as aleph] )
  (:gen-class))



(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn print-result-set
  "prints the result set in tabular form"
  [result-set]
  (doseq [row result-set]
    (println row)))

(def testdata
  {:message "http://example.com"})

(defn create-db
  "create db and table"
  []
  (try (db-do-commands db
                       (create-table-ddl :messages
                                         [[:timestamp :datetime :default :current_timestamp]
                                          [:message :text]]))
       (catch Exception e
         (println (.getMessage e)))))

(def db-example
  []
  (create-db)
  (insert! db :messages testdata)
  (print-result-set (query db ["select * from messages"])))