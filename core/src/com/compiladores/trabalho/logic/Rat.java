package com.compiladores.trabalho.logic;

import java.awt.Point;

public class Rat {

	public Point point = new Point(0, 0);
	public int Passos = 0;
	public int estado = 1;
	public int FoodCount = 0;
	public boolean PaCima, PaBaixo, PaDireita, PaEsquerda;
	int aDireita, aEsquerda, aFrente, aTras;

	public Rat() {
		PaCima = false;
		PaBaixo = false;
		PaDireita = true;
		PaEsquerda = false;
	}

	public void see(int[][] food) {
		aDireita = 0;
		aEsquerda = 0;
		aFrente = 0;
		aTras = 0;

		int x = 0;
		if (point.x - 1 >= 0) {
			if (food[point.x - 1][point.y] == 5) {
				x = 1;
			} else {
				x = 0;
			}

		} else {
			x = -1;
		}

		if (PaCima) {
			aFrente = x;
		}
		if (PaBaixo) {
			aTras = x;
		}
		if (PaDireita) {
			aEsquerda = x;
		}
		if (PaEsquerda) {
			aDireita = x;
		}

		if (point.x + 1 < 15) {
			if (food[point.x + 1][point.y] == 5) {
				x = 1;
			} else {
				x = 0;
			}
		} else {
			x = -1;
		}

		if (PaCima) {
			aTras = x;
		}
		if (PaBaixo) {
			aFrente = x;
		}
		if (PaDireita) {
			aDireita = x;
		}
		if (PaEsquerda) {
			aEsquerda = x;
		}

		if (point.y - 1 >= 0) {
			if (food[point.x][point.y - 1] == 5) {
				x = 1;
			} else {
				x = 0;
			}
		} else {
			x = -1;
		}

		if (PaCima) {
			aEsquerda = x;
		}
		if (PaBaixo) {
			aDireita = x;
		}
		if (PaDireita) {
			aTras = x;
		}
		if (PaEsquerda) {
			aFrente = x;
		}

		if (point.y + 1 < 15) {
			if (food[point.x][point.y + 1] == 5) {
				x = 1;
			} else {
				x = 0;
			}
		} else {
			x = -1;
		}

		if (PaCima) {
			aDireita = x;
		}
		if (PaBaixo) {
			aEsquerda = x;
		}
		if (PaDireita) {
			aFrente = x;
		}
		if (PaEsquerda) {
			aTras = x;
		}

	}

	public int[][] andarPaFrente(int[][] food) {
		
		if (PaCima) {
			point.x--;
		}
		if (PaBaixo) {
			point.x++;
		}
		if (PaDireita) {
			point.y++;
		}
		if (PaEsquerda) {
			point.y--;
		}
		Passos++;
		if (food[point.x][point.y] == 5) {
			food[point.x][point.y] = 6;
			FoodCount++;
		}
		return food;
	}

	public void virarPaDireita() {
		if (PaCima) {
			PaCima = false;
			PaDireita = true;
		} else {
			if (PaDireita) {
				PaDireita = false;
				PaBaixo = true;
			} else {
				if (PaBaixo) {
					PaBaixo = false;
					PaEsquerda = true;
				} else {
					if (PaEsquerda) {
						PaEsquerda = false;
						PaCima = true;
					}
				}
			}
		}
		Passos++;
	}

	public void virarPaEsquerda() {
		if (PaCima) {
			PaCima = false;
			PaEsquerda = true;
		} else {
			if (PaEsquerda) {
				PaEsquerda = false;
				PaBaixo = true;
			} else {
				if (PaBaixo) {
					PaBaixo = false;
					PaDireita = true;
				} else {
					if (PaDireita) {
						PaDireita = false;
						PaCima = true;
					}
				}
			}
		}
		Passos++;
	}

}
