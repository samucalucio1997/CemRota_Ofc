# Documento de Visão

## Histórico de Revisões

| Data                |  Versão             |          Descrição  |  Autores            |
| :-----------------: | :-----------------: | :-----------------: | :-----------------: |
| 04/09/2023 | 1.0 | Primeiras descrições da aplicação, incluindo:1; 2; 3, 6 |  Renan, Samuel, Ítalo, Carlos. |
| 06/09/2023 | 1.1 | Redefinição do projeto, incluindo: 2; 3; 6; |  Renan, Samuel, Ítalo, Carlos. |
| 24/09/2023 | 1.2 | atualização do projeto em itens: 1, 8, 9, 6.|  Renan, Samuel, Ítalo, Carlos. |
| 02/12/2023 | 2.0 | Atualização em: 2, 3, 4, 8.| Italo, Renan, Samuel. |
| 05/03/2024 | 2.1 | Atualização em: 8, 9.| Italo, Radmila, Renan, Samuel, Walber. |
| 14/03/2024 | 2.2 | Atualização em: 8.| Italo, Radmila, Renan, Samuel, Walber. |


## 1. Objetivo do projeto

 Proporcionar ao usuário a experiência de poder usufruir de serviços que estão na rota de viagem do mesmo. Além disso, disponibiliza espaço para micro/pequenos empreendendores para cadastrarem seus pontos de interesses(pousadas, hotéis, restaurantes, bares e atrações turísticas em geral) 

## 2. Descrição do problema

|     |      |
| --- | --- |
| **Problema**            | Baixa visibilidade de eventos, pontos de interesse, conforto e praticidade de hospedagens durante uma viagem longa; reserva de hospedagem em viagens, locais que poderiam ser visitados mas são desconhecidos e participação de atividades(danças locais, eventos como batalhas de rap, dança de rua, apresentação de arte, atividades físicas ao ar livre, etc). |
| **Afeta**               | Donos de hostels, hotéis, pousadas, incentivadores de atividades físicas, vendedores autônomos,  atividades de lazer com pouca divulgação.|  
| **Impacta**             | Falta de visibilidade para hotéis, pousadas, pequenas atividades sociais e pontos turísticos que não possuem referência disponível na internet e/ou são pouco divulgados. |
| **Solução**             | Criar um sistema web para que possa ser cadastrado os pontos poucos divulgados, através de imagens, descrições e possíveis atrativos dando maior visibilidade para quem desconhece aquele local ou evento. | 

## 3. Descrição dos usuários 
|   **Nome** | **Descrição** |**Responsabilidade** |
| ---        | ---           |---                  |
|Usuário Geral|  Usuários que cadastram e gerenciam as informações sobre o sistema, atualizando preços, disponibilidade dos quartos, além de pesquisar por rotas, ponto de interesses, pontos gerais, serviços e fazer reservas.  |     Cadastro de ponto de interesse; cadastro e atualização de vagas; cadastro de reservas.|
|Usuário Visitante| Usuários ainda não cadastrados podem visualizar e pesquisar pontos de interesse, tem a possibilidade de cadastro no sistema para se tornar o Usuário Geral descrito acima. |      ---   |

## 4. Descrição do ambiente dos usuários
<ul>
  <li>A aplicação irá funcionar de forma web, podendo ser acessada por todos os dispositivos que tem acesso a internet e de qualquer lugar.</li>
</ul>


## 5. Principais necessidades dos usuários
<ul>
  <li>Cadastro de ponto de interesse: Os proprietários e gerentes precisam de uma maneira fácil e eficiente de cadastrar seus ponto de interesses no sistema, incluindo detalhes como nome, localização, comodidades, preços e disponibilidade.</li>
  <li>Visualização dos pontos disponíveis já cadastrados no sistema.</li>
</ul>


## 6. Alternativas concorrentes
**Aplicativos**: Booking.com,  Trivago, Google maps e Airbnb.

**Pontos positivos**: Dão a oportunidade de pesquisar por hotéis, pontos turísticos e pontos para passeios com seus respectivos sites institucionais ou diretamente na plataforma. 

**Negativos**: Pequenos pontos de interesses e que são reservados na hora não tem necessidade de possuir um sistema de reserva antecipada na internet além da falta de visibilidade.


## 7. Visão geral do produto
<ul>
  <li>Recursos principais: Cadastro e atualização de ponto de interesse, cadastro e atualização de usuários, pesquisa, reserva,passeios, comentários e  avaliações.</li>
  <li>O sistema deve ser robusto e suficiente para lidar com picos de tráfego e garantir alta disponibilidade. Deve ser capaz de lidar com erros e exceções de forma controlada. Deve ser capaz de lidar com erros de entrada do usuário e outras situações. A interface deve ser intuitiva e fácil de usar para qualquer nível de usuário. Todas as informações sensíveis devem ser protegidas.</li>
</ul>


## 8. Requisitos funcionais

| Código | Nome                                   | Descrição                                                                                             | Prioridade |
|--------|----------------------------------------|-------------------------------------------------------------------------------------------------------|------------|
| F01    | Cadastro de Usuário                   | Os usuários devem poder se cadastrar na plataforma, fornecendo informações como nome, endereço de e-mail e senha. | Alta       |
| F02    | Login de Usuário                      | Os usuários registrados devem poder fazer login na plataforma para acessar sua conta.                | Alta       |
| F03    | Pesquisa de Rota                      | Realizar busca através de barra de pesquisa, exibindo os pontos de interesse que irão traçar o destino. | Alta       |
| F04    | Cadastro de Ponto de Interesse        | Informação de localização, quantidade de quartos (em caso de hospedagens), preços, serviços prestados, informações adicionais como atividades do local. | Alta       |
| F05    | Atualização de informações do Ponto de Interesse | Alterar datas de funcionamento e/ou exceções de dias que estarão fechados. Alterar nome, alterar endereço. | Média      |
| F06    | Pesquisa de Ponto de Interesse       | Realizar busca de ponto de interesse através de barra de pesquisa, utilizando ou não filtros.        | Média      |
| F07    | Visualizar de Ponto de Interesse    | Visualizar e acessar informações sobre pontos de interesse.                                           | Média      |
| F08    | Criação de reserva de Ponto de Interesse | Selecionar quarto em um ponto de interesse, verificar disponibilidade e realizar reserva.           | Alta       |
| F09    | Avaliar Ponto de Interesse           | Declarar uma valor entre 0 e 5 como método de avaliação por estrela. Exibir a média de acordo com a quantidade e valor de pessoas que avaliaram. Incluir opção de comentário. | Alta       |
| F10    | Gerenciamento de Perfil de Usuário   | Os usuários devem poder gerenciar seu perfil na plataforma, incluindo a capacidade de alterar senha, informações pessoais e outras configurações relacionadas à conta. | Alta       |
| F11 | adição de ponntos de interesse como favorito | O usuario ao visualizar informações sobre o ponto de interesse poderá marcar com favorito. | Baixa| 
|F12| Escolha de rota| o usuario poderá escolher uma rota que está entre os pontos de origem e destino.| Baixa |

## 9. Requisitos não-funcionais

| Código              |  Nome               |          Descrição  |  Categoria          |  Classificação      |
| :-----------------: | :-----------------: | :-----------------: | :-----------------: | :-----------------: |
| NF01 | Segurança de login | As senhas dos usuários devem ser guardadas usando criptografia | Segurança | obrigatório |
| NF02 | Capacidade de atendimento múltiplo | Deve ser capaz de receber requisições de 100 usuários simultâneos. | Performance | Desejável |
| NF03 | Sistema funcional e responsivo | O sistema deve funcionar 99% durante todo o uso pelo usuário. | Disponibilidade | Obrigatório |
| NF04 | Eficiência e legibilidade | Deve ser utilizado  arquitetura de códigos limpos e de fácil entendimento para melhor manutenção. | Escalabilidade | Desejável |
| NF05 | Roda no máximo de plataformas possível | O sistema deve ser compatível com todos os navegadores mais usados: Chrome, Edge, Opera, Safari, Mozilla. | Portabilidade | Desejável |
| NF06 | Segurança das escolhas do cliente | Os locais escolhidos pelos hóspedes não devem saber o destino completo do usuário. | Privacidade/Segurança | Obrigatório |
|NF07| Desempenho ao cadastrar | Os envios de formulários não devem ser maiores que 2 segundos. | Desempenho | Desejável |
|NF08| Poder de escolha | O usuário deve ter acesso a disponibilidade do local escolhido para reserva/passeio. | Usabilidade | Obrigatório |
|NF09| Responsabilidade na Coleta de dados | Todos os formulários devem ter filtros para receber somente o tipo exclusivo em cada campo, ex: texto, senha. | Segurança | Obrigatório |
|NF10| Segurança de dados no ambiente web | As requisições HTTP devem ser filtradas somente para o uso necessário para execução da tarefa (somente POST ou GET ou PUT ou DELETE) | Segurança | Desejável |
|NF11| Evitar problemas de avaliações desonestas | Usuários não podem acumular avaliações por estrela em um único ponto de interesse. | Usabilidade | Desejável |
