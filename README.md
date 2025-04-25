# 🔍 BuscaPalavras

Um sistema de **caça-palavras** desenvolvido em **Clojure**, capaz de identificar palavras escondidas em uma matriz de letras carregada a partir de um arquivo `.txt`. A busca é feita nas direções **horizontal**, **vertical** e **diagonal** (↘ ↗), tanto para frente quanto para trás.

---

## ✨ Funcionalidades

- Busca de palavras ocultas em uma matriz personalizada
- Suporte a direções:
  - Horizontal (→ ←)
  - Vertical (↓ ↑)
  - Diagonal (↘ ↗)
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

> O programa será executado no terminal. Você poderá digitar a palavra que deseja buscar e o sistema mostrará se ela foi encontrada, indicando a posição e direção.


**Nota para usuários Windows** <img src="https://img.icons8.com/color/48/000000/windows-10.png" alt="Windows Logo" width="20"/>


Se estiver utilizando **Windows**, pode haver problemas com a exibição de caracteres (como acentuação ou setas). Para garantir que tudo funcione corretamente no terminal, siga estas instruções:

1. **Use o Windows Terminal** (ou outro terminal compatível com UTF-8).
2. No terminal, execute:

```bash
chcp 65001
```

> Esse comando muda o encoding do terminal para **UTF-8**.

3. Em seguida, rode o programa com:

```bash
clj -M:run
```

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
- [x] Busca diagonal (↘ ↗)
- [x] Mostrar posições da palavra (início)
- [ ] Busca diagonal invertida (↙ ↖)
- [ ] Destaque visual da palavra encontrada na matriz
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
