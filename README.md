# server
Back-end do projeto

## Versionamento do projeto

#### Clonar o repositório:

` git clone https://github.com/minha-vez/server.git `


#### Colocar suas alterações no repositório

1. ` git add <caminho do arquivo> ou <.> ` <- adiciona os arquivos que irão para o repositório

2. ` git commit -m 'Sua mensagem do commit aqui' ` <- embrulha o pacote com os arquivos adicionados acima e adiciona um bilhete

3. ` git push ` <- "empurra" para dentro do repositório

------------------------------

#### Criando uma nova branch:

- `  git checkout -b 'nome da branch' `

#### mudando de branch:

- ` git checkout 'nome da branch' `

#### Adicionar sua nova branch no repositório remoto (upstream)

1. ` git add ` e ` git commit `
2. ` git push --set-upstream origin <nome da branch> `

## Rotina básica para iniciar uma feature:

1. `  git checkout <sua branch> ` <- entre na sua branch

2. ` git pull origin main ` <- atualize sua branch com a branch principal 'main'

3. code tudo que precisar para a feature e em seguida faça o git add/commit/push padrão

4. no repositório online você deve fazer o 'pull request' e aguardar o review do coleguinha


