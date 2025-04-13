# 🔍 BuscaPalavras

Um sistema de **caça-palavras** desenvolvido em **Clojure**, capaz de identificar palavras escondidas em uma matriz de letras. A busca ocorre de forma **horizontal**, **vertical** e **diagonal**, para frente e para trás.

---

## ✨ Funcionalidades

- Busca de palavras ocultas em uma matriz personalizada
- Suporte a direções:
  - Horizontal (→ ←)
  - Vertical (↓ ↑)
  - Diagonal (↘ ↖ ↙ ↗)
- Destaque de palavras encontradas
- Interface de linha de comando

---

## 🚀 Como executar

### ✅ Pré-requisitos

- [Clojure CLI](https://clojure.org/guides/getting_started) **ou** [Leiningen](https://leiningen.org)
- Git

### 📦 Clonando o projeto

```bash
git clone https://github.com/seu-usuario/BuscaPalavras.git
cd BuscaPalavras
```

### ▶️ Executando com Leiningen

```bash
lein run
```

> O programa irá iniciar no terminal. Você poderá digitar a palavra que deseja procurar e ver o resultado na matriz.

---

## 🗂 Estrutura do Projeto

```
BuscaPalavras/
├── project.clj         # Configurações do projeto
├── README.md           # Este arquivo
└── src/
    └── busca_palavras/
        └── core.clj    # Arquivo principal com a lógica do programa
```

---

## 🛠 Em desenvolvimento

- [ ] Entrada de matriz por arquivo `.txt`
- [ ] Suporte a múltiplas palavras por vez
- [ ] Interface gráfica via ClojureScript (futuro)
- [ ] Testes automatizados com `clojure.test`

---

## 📄 Licença

Este projeto está licenciado sob a licença (LICENSE)

---

## 🤝 Contribuindo

Contribuições são super bem-vindas! Abra uma *issue* ou envie um *pull request* com suas ideias, melhorias ou correções.

---

## 👨‍💻 Autores

Desenvolvido  por Romildo Rodrigues, Frederyck Lohan e Miguel Angelo.  
