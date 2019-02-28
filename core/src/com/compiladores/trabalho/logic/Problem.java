package com.compiladores.trabalho.logic;

public class Problem {

	public Rat rato = new Rat();
	public int[][] food = new int[15][15];
	public int maxFood = 0;

	public Problem(int[][] food) {
		this.food = food;

		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food.length; j++) {
				if (food[i][j] == 5) {
					maxFood++;
				}
			}
		}

	}

	public void machine() {
		if (rato.estado != 0) {
			rato.see(food);
			switch (rato.estado) {
			case 1:
				if (rato.aFrente == 1) {
					rato.andarPaFrente(food);
					rato.estado = 1;
				}
				if (rato.aFrente <= 0) {
					rato.estado = 2;
				}

				break;

			case 2:
				if (rato.aDireita == 1) {
					rato.virarPaDireita();
					rato.estado = 1;
				}else {
					if (rato.aDireita <= 0) {
					rato.estado = 3;
				}
				}
				
				break;
			case 3:
				if (rato.aEsquerda == 1) {
					rato.virarPaEsquerda();
					rato.estado = 1;
				} else {
					if (rato.aFrente == 0) {
						rato.andarPaFrente(food);
						rato.estado = 4;
					}else {
						if(rato.aDireita == 0) {
							rato.virarPaDireita();
							rato.estado = 10;
						}else {
							if(rato.aEsquerda == 0) {
								rato.virarPaEsquerda();
								rato.estado = 14;
							}
						}
					}
				}

				break;
			case 4:
				if (rato.aFrente == 1) {
					rato.andarPaFrente(food);
					rato.estado = 1;
				} else {
					if (rato.aFrente <= 0) {
						rato.estado = 5;
					}

				}

				break;
			case 5:
				if (rato.aDireita == 1) {
					rato.virarPaDireita();
					rato.estado = 1;
				} else {
					if (rato.aDireita <= 0) {
						rato.estado = 6;
					}
				}

				break;
			case 6:
				if (rato.aEsquerda == 1) {
					rato.virarPaEsquerda();
					rato.estado = 1;
				} else {
					if (rato.aEsquerda <= 0) {
						rato.virarPaDireita();
						rato.estado = 7;
					}
				}

				break;
			case 7:
				if(rato.aFrente == 0) {
					rato.virarPaDireita();
					rato.estado = 8;	
				}
				break;
			case 8:
				if(rato.aFrente == 0) {
					rato.andarPaFrente(food);
					rato.estado = 9;	
				}
				break;
			case 9:
				if(rato.aEsquerda == 0) {
					rato.virarPaEsquerda();
					rato.estado = 10;
				}
				break;
			case 10:
				if(rato.aFrente == 0) {
					rato.andarPaFrente(food);
					rato.estado = 11;
				}
				break;
			case 11:
				if(rato.aFrente == 1) {
					rato.andarPaFrente(food);
					rato.estado = 1;
				}else {
					if(rato.aFrente <= 0) {
						rato.virarPaDireita();
						rato.estado = 12;
					}
				}
				break;
			case 12:
				if (rato.aDireita == 0) {
					rato.virarPaDireita();
					rato.estado = 13;
				}
				break;
			case 13:
				if (rato.aFrente == 0) {
					rato.andarPaFrente(food);
					rato.estado = 14;
				}

				break;
			case 14:
				if (rato.aFrente == 0) {
					rato.andarPaFrente(food);
					rato.estado = 15;
				}else {
					if(rato.aEsquerda == 0 || rato.aDireita == 0) {
						rato.estado = 0;
					}
				}
				break;
			case 15:
				if (rato.aFrente == 1) {
					rato.andarPaFrente(food);
					rato.estado = 1;
				}else {
					if(rato.aFrente <= 0) {
						rato.estado = 0;
					}
				}
				break;
			case 0:
				break;

			}
		}

	}

}
