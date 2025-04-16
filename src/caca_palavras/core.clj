(ns caca-palavras.core
  (:require [clojure.java.io :as io]))

(defn ler-matriz [caminho]
  (with-open [rdr (io/reader caminho)]
    (doall
     (map (fn [linha]
            (vec (remove #(Character/isWhitespace %) linha)))
          (line-seq rdr)))))
;; => [[\C \A \Ç \A]
;;     [\P \A \L \A]
;;     [\V \R \A \S]]

(defn ler-palavra []
  (clojure.string/upper-case (read-line)))

(defn -main []
  (println "🧩 Bem-vindo ao caça-palavras em Clojure!\n")
  (println "Digite a palavra que deseja encontrar: ") 

  (let [palavra (ler-palavra)]
    (println "🔍 Buscando a palavra:" palavra)

    


    ) 
  )