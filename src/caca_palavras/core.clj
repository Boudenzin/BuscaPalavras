(ns caca-palavras.core
  (:require [clojure.java.io :as io]))

(defn ler-matriz-horizontal [caminho]
  (with-open [rdr (io/reader caminho :encoding "UTF-8")]
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

(defn encontrar-posicoes [matriz palavra]
  (keep-indexed
   (fn [i linha]
     (when (clojure.string/includes? (apply str linha) palavra)
       i))
   matriz)) ;; => aqui ele tá retornando o índice da linha onde a palavra foi encontrada

(defn busca-diagonal [matriz palavra]) ;; => implementar ainda

(defn -main []
  (println "🧩 Bem-vindo ao caça-palavras em Clojure!\n")
  (print "Digite a palavra que deseja encontrar: ")

  
  (flush)
   (let [palavra (clojure.string/upper-case (read-line))
         linhas-encontradas (encontrar-posicoes matriz palavra)
         colunas-encontradas (encontrar-posicoes matriz-transposta palavra)]
  
     (println "\n📄 Matriz carregada:")
     (doseq [linha matriz]
       (println linha)
       )
  
     ;; Resultado da busca horizontal (linha)
     (if (seq linhas-encontradas)
       (doseq [linha linhas-encontradas]
         (println (str "✅ Palavra encontrada na linha " linha))
         )
       (println "❌ Palavra não encontrada nas linhas.")
       )
  
     ;; Resultado da busca vertical (coluna)
     (if (seq colunas-encontradas)
       (doseq [coluna colunas-encontradas]
         (println (str "✅ Palavra encontrada na coluna " coluna))
         )
       (println "❌ Palavra não encontrada nas colunas.")
       )
     )
  )
