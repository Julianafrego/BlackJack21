trabalho final - programaçao 2 (poo)
Você está participando de uma seleção para uma empresa desenvolvedora de jogos e deverá desenvolver utilizando orientação à objetos um protótipo funcional para o jogo de Blackjack 21. O jogo é simples e utiliza um baralho comum de 52 cartas (13 valores para cada um dos 4 naipes distintos). Baralho: Valores: A (Ás), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (Valete), Q (Rainha ou Dama), K (Rei) Naipes: Ouro (¨), Espadas (ª), Paus (§), Copas (©) Exemplos de cartas: A de Ouro; 2 de Paus; 5 de Espadas. Possível notação para cartas: AO = A de Ouro; 2P = 2 de Paus; 5C = 5 de Copas; QE (Dama de Espadas); Objetivo: Fazer o somatório do valor das cartas na mão chegar o mais próximo possível de 21, sem ultrapassar este valor. Quantos jogam? Pelo menos 2 jogadores. Como jogar?

Cada jogador recebe duas cartas; a. Neste ponto, faz sentido decidir a ordem dos jogadores, ou simplesmente usar a ordem de inserção dos nomes. O jogador da vez soma os valores de suas cartas e indica ao computador se quer receber outra carta. Repete o passo 2 até que o jogador não queira mais cartas. Repete os passos 2 e 3 para os demais jogadores, na ordem definida no início. Vence(m) aquele(s) que chegou(aram) mais próximo de somar 21. Há empate se todos pontuarem mais que 21. Requisitos da implementação (composição da nota) – 10pts GOVERNO DO ESTADO DO PIAUÍ UNIVERSIDADE ESTADUAL DO PIAUÍ CAMPUS PROFESSOR ANTONIO GEOVANNE ALVES DE SOUSA BACHARELADO EM CIÊNCIA DA COMPUTAÇÃO DISCIPLINA: PROGRAMAÇÃO II Laboratório de Engenharia de Software – LES http://www.les.prp.uespi.br les@prp.uespi.br O jogo deve ser implementado em Java (ou Dart), começa na classe Main e devem ser utilizadas boas práticas de programação da linguagem aprendidas em sala de aula. (5% ponto) Deve ser possível jogar Blackjack21; (35% pontos) a) Deve ser possível jogar várias partidas; Ao término de uma partida: (10% ponto) a) Deve-se exibir o resultado do jogo; b) Deve ser possível decidir por continuar jogando ou encerrar o jogo; Após a solicitação de encerramento do jogo, o jogo deverá apresentar o resultado de todas as partidas jogadas, incluindo: (10% ponto) a) Tipo (empate, vitória); b) Nome dos jogadores vencedores (se tiver algum); e c) Pontuação de cada jogador. O jogo deve utilizar tratamento de exceções (10% ponto) a) ao menos uma classe de exceção personalizada deve ser criada e utilizada. Você deve utilizar ao menos 6 classes distintas, excluindo-se a classe Main e as classes de Exceções e utilizar ao menos 2 padrões de projeto dentre os 23 do livro do clássico do tema1 . (30% pontos)
