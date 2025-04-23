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
  (apply mapv vector matriz))

(defn buscar-horizontal [matriz palavra]
  (let [palavra (str/upper-case palavra)]
    (keep-indexed
     (fn [indice linha]
       (let [linha-str (apply str linha)]
         (when (str/includes? linha-str palavra)
           {:tipo :horizontal
            :linha indice
            :coluna (str/index-of linha-str palavra)})))
     matriz)))


(defn buscar-vertical [matriz palavra]
  (let [resultados (-> matriz
                       transpor-matriz
                       (buscar-horizontal palavra))]
    (map #(assoc % :tipo :vertical :coluna (:linha %) :linha (:coluna %)) resultados)))

(defn buscar-diagonal [matriz palavra]
  (let [palavra (str/upper-case palavra)
        tam-palavra (count palavra)
        linhas (count matriz)
        colunas (if (pos? linhas) (count (first matriz)) 0)

        ;; Função auxiliar definida localmente
        verificar-diagonal (fn [linha-inicial coluna-inicial direcao] 
                             (let [passos (range tam-palavra)
                                   caracteres (for [i passos]
                                                (let [linha (+ linha-inicial (* direcao i))
                                                      coluna (+ coluna-inicial i)]
                                                  (when (and (< linha linhas) (< coluna colunas))
                                                    (get-in matriz [linha coluna]))))]
                               (when (= palavra (apply str (remove nil? caracteres)))
                                 {:tipo :diagonal
                                  :linha linha-inicial
                                  :coluna coluna-inicial
                                  :direcao (if (pos? direcao) "descendo" "subindo")})))]

    ;; Verifica todas as diagonais possíveis
    (->> (for [linha (range linhas)
               coluna (range colunas)]
           (or (verificar-diagonal linha coluna 1)  ; Diagonal descendente
               (verificar-diagonal linha coluna -1))) ; Diagonal ascendente
         (remove nil?))))


(defn exibir-matriz [matriz]
  (println "\n🔍 Matriz Carregada:")
  (doseq [linha matriz]
    (println (str/join " " linha))))

(defn formatar-resultado [resultado]
  (case (:tipo resultado)
    :horizontal (str "✅ Encontrada na linha " (:linha resultado)
                     ", começando na coluna " (:coluna resultado))
    :vertical (str "✅ Encontrada na coluna " (:coluna resultado)
                   ", começando na linha " (:linha resultado))
    :diagonal (str "✅ Encontrada na diagonal (" (:direcao resultado)
                   ") começando em [" (:linha resultado) "," (:coluna resultado) "]")))

(defn exibir-resultados [resultados]
  (if (seq resultados)
    (doseq [r resultados]
      (println (formatar-resultado r)))
    (println "❌ Palavra não encontrada.")))

(defn arquivo-existe? [caminho-arquivo]
  (.exists (io/file caminho-arquivo)))

(defn -main []
  (println "🧩 Bem-vindo ao caça-palavras em Clojure!\n")

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
                                       (buscar-vertical matriz palavra)
                                       (buscar-diagonal matriz palavra))]
                (exibir-resultados resultados)
                (recur))))))
      (println "❌ Arquivo não encontrado:" caminho-arquivo)))

  (println "\nObrigado por jogar! Até a próxima! 👋"))
