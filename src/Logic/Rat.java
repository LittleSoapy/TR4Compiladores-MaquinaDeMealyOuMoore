package Logic;

import java.awt.Point;

public class Rat {

	private Point point = new Point(0, 0);
	int Passos = 0;
	int estado = 1;
	int FoodCount = 0;
	int[][] RememberFood = new int[15][15];
	boolean PaCima, PaBaixo, PaDireita, PaEsquerda;
	boolean FoodDireita = false, FoodEsquerda = false, FoodCima = false, FoodBaixo = false;
	
	public Point getPoint() {
		return point;
	}

	public Rat(){
		for(int i = 0; i<15;i++){
			for(int j = 0; j<15; j++){
				RememberFood[i][j] = 0;
			}
		}
	}

	public void see(int[][] food) {
		FoodDireita = false;
		FoodEsquerda = false;
		FoodCima = false;
		FoodBaixo = false;
		if (point.x - 1 >= 0) {
			if (food[point.x - 1][point.y] == 5) {
				RememberFood[point.x - 1][point.y] = 1;
				FoodCima = true;
			}
		}
		if (point.x + 1 < 15) {
			if (food[point.x + 1][point.y] == 5) {
				RememberFood[point.x + 1][point.y] = 1;
				FoodBaixo = true;
			}
		}
		if (point.y - 1 >= 0) {
			if (food[point.x][point.y - 1] == 5) {
				RememberFood[point.x][point.y - 1] = 1;
				FoodEsquerda = true;
			}
		}
		if (point.y + 1 < 15) {
			if (food[point.x][point.y + 1] == 5) {
				RememberFood[point.x][point.y + 1] = 1;
				FoodDireita = true;
			}
		}
	}

	public int[][] comer(int[][] food) {
		food[point.x][point.y] = 6;
		RememberFood[point.x][point.y] = 0;
		FoodCount++;
		return food;
	}

	public int[][] andarPaCima(int[][] food) {
		if (PaCima) {
			Passos++;
		} else {
			if (PaDireita || PaEsquerda) {
				Passos = Passos + 2;
				PaDireita = false;
				PaEsquerda = false;
			} else {
				Passos = Passos + 3;
				PaBaixo = false;
			}
		}
		point.x--;
		PaCima = true;
		if (FoodCima) {
			comer(food);
			FoodCima = false;
		}
		return food;
	}

	public int[][] andarPaBaixo(int[][] food) {
		if (PaBaixo) {
			Passos++;
		} else {
			if (PaDireita || PaEsquerda) {
				Passos = Passos + 2;
				PaDireita = false;
				PaEsquerda = false;
			} else {
				Passos = Passos + 3;
				PaCima = false;
			}
		}
		point.x++;
		PaBaixo = true;
		if (FoodBaixo) {
			comer(food);
			FoodBaixo = false;
		}
		return food;
	}

	public int[][] andarPaDireita(int[][] food) {
		if (PaDireita) {
			Passos++;
		} else {
			if (PaCima || PaBaixo) {
				Passos = Passos + 2;
				PaCima = false;
				PaBaixo = false;
			} else {
				Passos = Passos + 3;
				PaEsquerda = false;
			}
		}
		point.y++;
		PaDireita = true;
		if (FoodDireita) {
			comer(food);
			FoodDireita = false;
		}
		return food;
	}

	public int[][] andarPaEsquerda(int[][] food) {
		if (PaEsquerda) {
			Passos++;
		} else {
			if (PaCima || PaBaixo) {
				Passos = Passos + 2;
				PaCima = false;
				PaBaixo = false;
			} else {
				Passos = Passos + 3;
				PaDireita = false;
			}
		}
		point.y--;
		PaEsquerda = true;
		if (FoodEsquerda) {
			comer(food);
			FoodEsquerda = false;
		}
		return food;
	}

}
