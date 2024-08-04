 | Tabela       | Descrição |
|--------------|--------------|
| PontoInteresse | Guarda informações referentes ao model PontoInteresse para cadastro e visibilidade | 

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| id   | Int        |  N   |  Y   |  N   |   Y    |
| Titulo   | Char        |  N   |  N   |  N   |   N    |
| Descrição   | Char        |  N   |  N   |  N   |   N    |
| Qtd Hóspedes   | Int        |  Y   |  N   |  N   |   N    |
| Qtd Quartos   | Int        |  Y   |  N   |  N   |   N    |
| Valor   | Decimal        |  N   |  N   |  N   |   N    |
| Longitude   | Decimal        |  N   |  N   |  N   |   N    |
| Latitude   | Decimal        |  N   |  N   |  N   |   N    |
| Dias   | Char        |  N   |  N   |  N   |   N    |
| Turnos   | Char        |  N   |  N   |  N   |   N    |
| id_endereço   | Int        |  N   |  N   |  Y   |   N    |
| Imagem   | Text        |  N   |  N   |  N   |   N    |


&nbsp;

| Tabela       | Descrição |
|--------------|--------------|
| Usuário | Guarda informações referentes ao model Usuario para cadastro e visibilidade |

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| Email   | Char       |  N   |  Y   |  N   |   N    |
|  Senha  | Char        |  N   |  N   |  N   |   N    |
| Nome   | Char        |  N   |  N   |  N   |   N    |
| Telefone   | Char      |  N   |  N   |  N   |   N    |
| Sobrenome   | Char       |  N   |  N   |  N   |   N    |
| id_endereço   | Int        |  N   |  N   |  Y   |   Y    |

&nbsp;

| Tabela       | Descrição |
|--------------|--------------|
| Endereço | Guarda informações referentes ao model Endereço para cadastro e visibilidade |

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| id   | Int       |  N   |  Y   |  N   |   Y    |
| Cidade  | Char        |  N   |  N   |  N   |   N    |
| Estado   | Char        |  N   |  N   |  N   |   N    |
| Rua   | Char      |  N   |  N   |  N   |   N    |
| Numero   | Char       |  N   |  N   |  N   |   N    |


&nbsp;

| Tabela       | Descrição |
|--------------|--------------|
| Reserva | Guarda informações referentes ao model Reserva para cadastro e visibilidade |

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| id   | Int       |  N   |  Y   |  N   |   Y    |
| Email  | Char        |  N   |  N   |  Y   |   Y    |
| id_anuncio   | Int        |  N   |  N   |  Y   |   Y    |
| Data_entrada   | Date      |  N   |  N   |  N   |   N    |
| Data_saida   | Date       |  N   |  N   |  N   |   N    |
| Valor_total   | Decimal       |  N   |  N   |  N   |   N    |


&nbsp;

| Tabela       | Descrição |
|--------------|--------------|
| Avalia | Guarda informações referentes ao model Avalia com as avaliações dos usuários |

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| id_usuário   | Int       |  N   |  N   |  Y   |   N    |
| id_anuncio  | Int        |  N   |  N   |  Y   |   N    |
| Comentário   | Char        |  N   |  N   |  N   |   N    |
| Estrelas   | Float      |  N   |  N   |  N   |   N    |

&nbsp;

| Tabela       | Descrição |
|--------------|--------------|
| Disponibiliza | Tabela de relacionamento de PontoInteresse e Usuario |

| Nome       | Tipo De Dado | Null | PK   | FK   | Unique |
|------------|--------------|------|------|------|--------|
| id_usuario   | Int       |  N   |  N   |  Y   |   N    |
| id_PontoInteresse  | Int        |  N   |  N   |  Y   |   N    | 