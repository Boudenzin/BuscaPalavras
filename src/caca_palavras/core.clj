(ns caca-palavras.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))



;; Definindo a função para ler o arquivo e criar a matriz
(defn ler-matriz [caminho-arquivo]
  (with-open [leitor (io/reader caminho-arquivo :encoding "UTF-8")]
    (->> (line-seq leitor)
         (map str/upper-case)
         (map #(str/replace % " " ""))
         (map vec)
         (vec))))
;; => [[\C \A \Ç \A]
;;     [\P \A \L \A]
;;     [\V \R \A \S]]




(defn transpor-matriz [matriz]
  (apply map vector matriz))

;;(defn ler-palavra []
  ;;(clojure.string/upper-case (read-line)))

(def matriz (ler-matriz "cacapalavra.txt"))
(def matriz-transposta (transpor-matriz matriz))

(defn buscar-horizontal [matriz palavra]
  (let [palavra (str/upper-case palavra)
        tamanho-palavra (count palavra)]
    (keep-indexed
     (fn [indice linha]
       (let [linha-str (apply str linha)]
         (when (str/includes? linha-str palavra)
           {:tipo :horizontal
            :linha indice
            :coluna (str/index-of linha-str palavra)})))
     matriz))) ;; => aqui ele tá retornando um mapa de vetores com as posições da palavra encontrada na matriz horizontalmente

(defn buscar-vertical [matriz palavra]
  (let [resultados (-> matriz
                       transpor-matriz
                       (buscar-horizontal palavra))]
    (map #(assoc % :tipo :vertical :coluna (:linha %) :linha (:coluna %)) resultados)))

(defn busca-diagonal [matriz palavra]) ;; => implementar ainda


(defn exibir-matriz [matriz]
  (println "\n🔍 Matriz Carregada:")
  (doseq [linha matriz]
    (println (str/join linha))))

(defn formatar-resultado [resultado]
  (case (:tipo resultado)
    :horizontal (str "✅ Encontrada na linha " (:linha resultado)
                     ", começando na coluna " (:coluna resultado))
    :vertical (str "✅ Encontrada na coluna " (:coluna resultado)
                   ", começando na linha " (:linha resultado))))

(defn exibir-resultados [resultados]
  (if (seq resultados)
    (doseq [r resultados]
      (println (formatar-resultado r)))
    (println "❌ Palavra não encontrada.")))

(defn arquivo-existe? [caminho-arquivo]
  (.exists (io/file caminho-arquivo)))

(defn -main []
  (println "🧩 Bem-vindo ao caça-palavras em Clojure!\n")
  (print "Digite a palavra que deseja encontrar: ")
  
  (let [caminho-arquivo "cacapalavra.txt"]
    (if (arquivo-existe? caminho-arquivo)
      (let [matriz (ler-matriz caminho-arquivo)]
        (exibir-matriz matriz)
        
        (loop []
          (print "\n🔎 Digite a palavra para buscar (ou 'sair' para terminar): ")
          (flush)
          (let [palavra (str/trim (read-line))]
            (when-not (or (= "sair" (str/lower-case palavra)) (empty? palavra))
              (let [resultados (concat (buscar-horizontal matriz palavra)
                                       (buscar-vertical matriz palavra))]
                (exibir-resultados resultados)
                (recur))))))
      (println "❌ Arquivo não encontrado:" caminho-arquivo)))
  
  (println "\nObrigado por jogar! Até a próxima! 👋")
  )
