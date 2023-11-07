(ns solar-system-v2.protocols.db)

(defprotocol IDB
  (q [this query args]
    "q calls the database query method (e.g. reads from the database).
     query is the datomic query object (either a map or vector)
     args must be a sequence")
  (tx! [this txs]
    "tx! makes a new transaction (e.g. writes to the database)
     txs must be a sequence of transactions sent to the database"))

