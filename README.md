# exploring-mars
Teste elo7

#Sobre as tecnologias
- Utilizei o SpringBoot para export os endpoints e fazer toda a ID e IoC;
- utilizei o padrão Domain Model do Fowler, que evita classe anonimas e facilita a utilização de métodos fluentes;
- Java 1.7
- Maven
- Junit

#Endpoints
A API espões 3 endpoints sendo eles:
- [POST] /plateaus - É responsável pela criação do terreno a ser mapeado, esse endpoint recebe um json contendo positionX, positionY;
- [POST] /probes - Irá inicializar uma sonda, esse endpoint recebe como parâmetro um json contendo name, positionX, positionY e cardinalDirection (N, W, S, E);
- [POST] /probes/{probeName}/instructions - Esse endpoint é responsável por realizar as instruções de uma sonda, na url deve ser passado o nome sonda como pathvariable e um json com uma lista de instruções. Ex:L,M,L,M.

