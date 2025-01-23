
# Gerenciamento de Datashows com Clojure

Este projeto foi desenvolvido para gerenciar datashows utilizando a linguagem Clojure. Ele permite consultar a disponibilidade, alocar e desalocar datashows, utilizando listas e recursividade.

## Objetivo
- Verificar a disponibilidade de um datashow.
- Realizar a alocação de um horário para um datashow, caso esteja disponível.
- Desalocar uma reserva existente de um datashow.

## Estrutura do Código

- `datashows`: Lista inicial de datashows com suas reservas.
- `disponivel?`: Verifica se um datashow está disponível em um horário específico.
- `verificar-disponibilidade`: Itera sobre os datashows para verificar disponibilidade.
- `alocar-datashow`: Aloca um horário em um datashow.
- `desalocar-datashow`: Remove uma reserva de um datashow.

## Como Rodar

1. Certifique-se de que o Leiningen está instalado ([Leiningen](https://leiningen.org/)).
2. Abra o terminal e execute o REPL do Clojure:

   ```bash
   lein repl
   ```
3. Carregue o arquivo principal:
   ```clojure
   (load-file "datashow_management.clj")
   ```
4. Execute os exemplos no REPL.

## Exemplos

- Verificar Disponibilidade:

  ```clojure
  (verificar-disponibilidade datashows 1 :segunda 10 12)
  ```

- Alocar um Datashow:

  ```clojure
  (def datashows-atualizados (alocar-datashow datashows 1 :segunda 14 16))
  ```

- Desalocar um Datashow:

  ```clojure
  (def datashows-atualizados (desalocar-datashow datashows-atualizados 1 :segunda 14 16))
  ```
- Ao Final do código existem 2 comentários indicando o local para realizar os testes.
## Branches

- Implementação inicial: `feature/atividade-01-20242`
- Correções: `bugfix/atividade-01-20242`

---

