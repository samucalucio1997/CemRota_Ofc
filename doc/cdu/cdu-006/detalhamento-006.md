# CDU001. Fazer Reserva

- **Usuário**: Usuário geral
- **Resumo**: O usuário escolhe uma hospedagem para efetuar reserva e envia uma notificação para o dono da hospedagem
- **pré-condição**: estar logado
- **Pós-Condição**: O usuário retorna para página principal

## [Regras de negócio](/doc/RegrasNegocio/Regras.md) - -


## Fluxo Principal
| Ações do ator | Ações do sistema |
| :-----------------: | :-----------------: | 
| 1 - O usuário clica em um botão para efetuar a reserva de um ponto de interese do tipo hospedagem |  |  
| | 2 -O sistema retorna uma página com todos os detalhes da reserva (data, horário, se é permitido animais, quantidade de camas de solteiro e casal, e valor) | 
| 3 - O usuário insere dados para checagem da hospedagem no local e confirma | |
| | 4 - O sistema deixa aquele ponto de interesse como indisponível e envia uma mensagem para o usuário dono do ponto de interesse|




## Fluxo de Exceção I - Usuário sem permissão
| Ações do ator | Ações do sistema |
| :-----------------: |:-----------------: | 
| 6.1 - O usário não tem permissão (Não logado) | |  
| | X.2 - O sistema redireciona página de login. |

