# 🔍 BuscaPalavras

Um sistema de **caça-palavras** desenvolvido em **Clojure**, capaz de identificar palavras escondidas em uma matriz de letras carregada a partir de um arquivo `.txt`. A busca pode ser feita de forma **horizontal**, **vertical** e futuramente **diagonal**, tanto para frente quanto para trás.

---

## ✨ Funcionalidades

- Busca de palavras ocultas em uma matriz personalizada
- Suporte a direções:
  - Horizontal (→ ←)
  - Vertical (↓ ↑)
- Interface via linha de comando
- Leitura de matriz a partir de arquivo `.txt`

---

## 🚀 Como executar

### ✅ Pré-requisitos

- [Clojure CLI](https://clojure.org/guides/getting_started)
- Git
- Editor de texto compatível com UTF-8 (VS Code, Neovim, etc.)

### 📦 Clonando o projeto

```bash
git clone https://github.com/Boudenzin/BuscaPalavras.git
cd BuscaPalavras
```

### ▶️ Executando com Clojure CLI

```bash
clj -M:run
```

> O programa será executado no terminal. Você poderá digitar a palavra que deseja buscar e o sistema mostrará se ela foi encontrada, indicando a posição.

---

## 📂 Estrutura do Projeto

```
BuscaPalavras/
├── cacapalavra.txt            # Matriz do caça-palavras (entrada)
├── deps.edn                   # Configurações do projeto com Clojure CLI
├── README.md                  # Este arquivo
└── src/
    └── caca_palavras/
        └── core.clj           # Arquivo principal com a lógica do programa
```

---

## 🛠 Em desenvolvimento

- [x] Entrada da matriz via `.txt`
- [x] Busca horizontal
- [x] Busca vertical
- [ ] Busca diagonal
- [ ] Destaque visual da palavra encontrada na matriz
- [ ] Mostrar posições da palavra (início e fim)
- [ ] Interface gráfica via ClojureScript
- [ ] Testes automatizados com `clojure.test`

---

## 📄 Licença

Este projeto está licenciado sob os termos do arquivo [LICENSE](./LICENSE).

---

## 🤝 Contribuindo

Contribuições são super bem-vindas! Sinta-se à vontade para abrir uma *issue* com sugestões, relatar bugs ou enviar um *pull request* com melhorias.

---

## 👨‍💻 Autores

Desenvolvido por **Romildo Rodrigues**, **Frederyck Lohan** e **Miguel Angelo**.
