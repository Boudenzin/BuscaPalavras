(ns caca-palavras.core
  (:require [clojure.java.io :as io]))

(defn ler-matriz-horizontal [caminho]
  (with-open [rdr (io/reader caminho)]
    (doall
     (map (fn [linha]
            (vec (remove #(Character/isWhitespace %) linha)))
          (line-seq rdr)))))
;; => [[\C \A \Ç \A]
;;     [\P \A \L \A]
;;     [\V \R \A \S]]

(defn transpor-matriz [matriz]
  (apply map vector matriz))

;;(defn ler-palavra []
  ;;(clojure.string/upper-case (read-line)))

(def matriz (ler-matriz-horizontal "cacapalavra.txt"))
(def matriz-transposta (transpor-matriz matriz))

(defn busca-horizontal [matriz palavra])

(defn -main []
  (println "🧩 Bem-vindo ao caça-palavras em Clojure!\n")
  (print "Digite a palavra que deseja encontrar: ")

  
  (flush)
  (let [palavra (clojure.string/upper-case (read-line))]
    (println "🔍 Buscando a palavra:" palavra))
  
  (println "\n📄 Matriz carregada:")
  (doseq [linha matriz]
    (println linha))
  
  (println "\n📄 Matriz transposta:")
  (doseq [linha matriz-transposta]
    (println linha))
  
  )