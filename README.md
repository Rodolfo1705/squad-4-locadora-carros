# Sistema de Locadora de Veículos
<p align="justify">Este projeto é um exemplo de uma aplicação back-end de locação de veículos, construído tecnologias como Java, Hibernate, JPA e Spring Boot para gerenciar as requisições e operações relacionadas ao aluguel de veículos.</p>

## Sobre o desafio
<p align="justify">Este sistema foi desenvolvido como parte de um desafio proposto pela empresa de tecnologia <b>Solutis</b>, como parte do processo seletivo para estagiários. Tal desafio visava avaliar as habilidades dos candidatos na construção de uma aplicação prática que atendesse aos requisitos de uma locadora de veículos, demonstrando competências em programação e na implementação de funcionalidades essenciais para a aplicação.</p>

## Visão Geral
<p align="justify">Este sistema foi desenvolvido para proporcionar uma experiência fluida e eficiente na locação de veículos. O mesmo conta com três principais funções:</p>

  - <p align="justify"><b>Cadastro de Cliente:</b> Os usuários têm a capacidade de se cadastrar no sistema fornecendo informações pessoais essenciais. Ademais, também é feita a vinculação de um email único com a conta do usuário, permitindo um processo de locação personalizado e mantendo um registro completo das atividades do cliente.</p>

  - <p align="justify"><b>Escolha de Veículo para Aluguel:</b> O sistema permite que o usuário navegue pela ampla variedade de veículos disponíveis para aluguel. Além disso, também é possível realizar a filtragem e seleção do veículo perfeito para atender às necessidades do cliente.</p>

  - <p align="justify"><b>Efetivação do Aluguel de Veículo:</b> Com a seleção do veículo feita, este recurso permite que os clientes finalizem o processo de locação. As datas de retirada e devolução são especificadas, e os detalhes finais são confirmados e o pagamento é realizado antes de concluir a reserva.</p>

## Funcionalidades Adicionais
<p align="justify">Além das funções principais utilizadas pelos usuários comuns, o sistema também oferece funcionalidades avançadas para os funcionários:</p>

  - <p align="justify"><b>Gerenciamento de Fabricantes:</b> Esta funcionalidade permite aos funcionários adicionar, atualizar listar e remover informações sobre fabricantes de veículos.</p>

  - <p align="justify"><b>Gerenciamento de Modelos de Carros:</b> Neste caso, além das funcionalidades do tópico anterior, os funcionários podem manter um inventário completo modelos de carros separdos por fabricantes e categorias específicas.</p>

  - <p align="justify"><b>Gerenciamento de Acessórios:</b> Neste ponto, oferecemos ao funcionário a possibilidade de adicionar, atualizar e remover acessórios opcionais dos veículos, proporcionando uma experiência personalizada para os clientes durante o período de aluguel.</p>

  - <p align="justify"><b>Gerenciamento de Carros:</b> Como uma peça fundamental para a funcionalidade do sistema, o gerenciamento de carros por parte do funcionário é vital para manter um inventário completo de veículos, seus detalhes e opções atualizadas, permitindo uma seleção precisa pelos clientes.</p>

  - <p align="justify"><b>Gerenciamento de Apólices de Seguro:</b> Por último, esta funcionalidade permite ao funcionário administrar as ofertas de apólices de seguro aos seus aluguéis.</p>

## Tecnologias Utilizadas
<p align="justify">O projeto de Locadora de Veículos foi desenvolvido empregando uma série de tecnologias modernas e robustas para assegurar a eficiência, escalabilidade e manutenibilidade da aplicação. Ele foi construído com as seguintes tecnologias:</p>

  - <p align="justify"><b>Java:</b> A linguagem de programação Java foi a base sólida que permitiu a construção de código limpo e organizado, garantindo funcionalidades seguras e eficientes.</p>

  - <p align="justify"><b>JPA:</b> A JPA, ou Java Persistence API, foi utilizada para abstrair a complexidade das operações de banco de dados, permitindo a representação coesa e consistente das entidades do sistema no banco de dados.</p>

  - <p align="justify"><b>Hibernate:</b> O Hibernate, ao implementar a JPA, simplificou a persistência de objetos Java no banco de dados, oferecendo recursos avançados de consulta e mapeamento.</p>

  - <p align="justify"><b>Lombok:</b> O Lombok simplificou o código ao automatizar a geração de getters, setters e construtores, tornando-o mais conciso, legível e permitindo uma grande economia de tempo.</p>

  - <p align="justify"><b>Spring Boot:</b> A utilização do Spring Boot facilitou o desenvolvimento ao oferecer configuração automática, ambiente de execução embutido e gerenciamento de dependências, permitindo concentrar-se nas funcionalidades principais do sistema.</p>

  - <p align="justify"><b>Swagger:</b> Por fim, o Swagger (OpenAPI) viabilizou a documentação clara e detalhada da API, auxiliando usuários e desenvolvedores a entender e interagir com a a mesma de forma eficaz.</p>

<hr>

## Guia de Utilização

<p align="justify">Para experimentar este projeto localmente, siga as instruções abaixo para configurar e executar a aplicação. Certifique-se de que o seu servidor SQL esteja operacional antes de prosseguir.</p>

### Passos de Configuração

1. <p align="justify"><strong>Clonagem do Repositório:</strong> Clone este repositório para o seu ambiente de desenvolvimento local.</p>

2. <p align="justify"><strong>Configuração do Banco de Dados:</strong> Certifique-se de que o servidor SQL esteja em funcionamento e configure as informações de conexão no arquivo de configuração apropriado.</p>


### Execução da Aplicação

1. <p align="justify"><strong>Compilação e Execução:</strong> Utilize uma IDE ou uma ferramenta de linha de comando para compilar e executar a aplicação. Certifique-se de que todas as dependências funcionem corretamente.</p>

2. <p align="justify"><strong>Verificação do Servidor SQL:</strong> Assegure-se de que o servidor SQL esteja operacional e a configuração de conexão esteja correta para permitir a comunicação com o banco de dados.</p>


### Utilização da Aplicação

  - <p align="justify"><strong>Requisições JSON:</strong> O sistema se comunica por meio de requisições JSON. Utilize as rotas e os endpoints definidos para realizar as operações desejadas. Consulte a documentação fornecida para obter informações detalhadas sobre as requisições suportadas.</p>

<p align="center"><b>(Última atualização: 21 de agosto 2023)</b></p>
