package Logic;

import java.awt.Point;

public class Rat {

	private Point point = new Point(0, 0);
	int Passos = 0;
	int estado = 1;
	int FoodCount = 0;
	public int[][] RememberFood = new int[15][15];
	public boolean PaCima = false, PaBaixo = false, PaDireita = true, PaEsquerda = false;
	boolean FoodDireita = false, FoodEsquerda = false, FoodCima = false, FoodBaixo = false;

	public Point getPoint() {
		return point;
	}
	

	public Rat() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				RememberFood[i][j] = 0;
			}
		}
		RememberFood[0][0] = 3;// posicao sempre vazio

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
				if ((point.y - 1) >= 0) {
					if (RememberFood[point.x - 1][point.y - 1] != 3
							&& RememberFood[point.x - 1][point.y - 1] != 1) {
						RememberFood[point.x - 1][point.y - 1] = 2;
					}
				}

				if ((point.x - 2) >= 0) {
					if (RememberFood[point.x - 2][point.y] != 3
							&& RememberFood[point.x - 2][point.y] != 1) {
						RememberFood[point.x - 2][point.y] = 2;
					}
				}
				if ((point.y + 1) < 15) {
					if (RememberFood[point.x - 1][point.y + 1] != 3
							&& RememberFood[point.x - 1][point.y + 1] != 1) {
						RememberFood[point.x - 1][point.y + 1] = 2;
					}
				}
			} else {
				RememberFood[point.x - 1][point.y] = 3;
				
			}
		}
		if (point.x + 1 < 15) {
			if (food[point.x + 1][point.y] == 5) {
				RememberFood[point.x + 1][point.y] = 1;
				FoodBaixo = true;
				if ((point.y + 1) < 15) {
					if (RememberFood[point.x + 1][point.y + 1] != 3 
							&& RememberFood[point.x + 1][point.y + 1] != 1) {
						RememberFood[point.x + 1][point.y + 1] = 2;
					}
				}

				if ((point.x + 2) < 15) {
					if (RememberFood[point.x + 2][point.y] != 3
							&& RememberFood[point.x + 2][point.y] != 1) {
						RememberFood[point.x + 2][point.y] = 2;
					}
				}

				if ((point.y - 1) >= 0) {
					if (RememberFood[point.x + 1][point.y - 1] != 3
							&& RememberFood[point.x + 1][point.y - 1] != 1) {
						RememberFood[point.x + 1][point.y - 1] = 2;
					}
				}
			} else {
				RememberFood[point.x + 1][point.y] = 3;
				
				
			}
		}
		if (point.y - 1 >= 0) {
			if (food[point.x][point.y - 1] == 5) {
				RememberFood[point.x][point.y - 1] = 1;
				FoodEsquerda = true;
				if ((point.x + 1) >= 0) {
					if (RememberFood[point.x + 1][point.y - 1] != 3
							&& RememberFood[point.x + 1][point.y - 1] != 1) {
						RememberFood[point.x + 1][point.y - 1] = 2;
					}
				}

				if ((point.y - 2) >= 0) {
					if (RememberFood[point.x][point.y - 2] != 3
							&& RememberFood[point.x][point.y - 2] != 1) {
						RememberFood[point.x][point.y - 2] = 2;
					}
				}

				if ((point.x - 1) >= 0) {
					if (RememberFood[point.x - 1][point.y - 1] != 3
							&& RememberFood[point.x - 1][point.y - 1] != 1) {
						RememberFood[point.x - 1][point.y - 1] = 2;
					}
				}
			} else {
				RememberFood[point.x][point.y - 1] = 3;
				

			}
		}
		if (point.y + 1 < 15) {
			if (food[point.x][point.y + 1] == 5) {
				RememberFood[point.x][point.y + 1] = 1;
				FoodDireita = true;
				if ((point.x - 1) >= 0) {
					if (RememberFood[point.x - 1][point.y + 1] != 3 
							&& RememberFood[point.x - 1][point.y + 1] != 1) {
						RememberFood[point.x - 1][point.y + 1] = 2;
					}
				}

				if ((point.y + 2) < 15) {
					if (RememberFood[point.x][point.y + 2] != 3
							&& RememberFood[point.x][point.y + 2] != 1) {
						RememberFood[point.x][point.y + 2] = 2;
					}
				}

				if ((point.x + 1) < 15) {
					if (RememberFood[point.x + 1][point.y + 1] != 3
							&& RememberFood[point.x + 1][point.y + 1] != 1) {
						RememberFood[point.x + 1][point.y + 1] = 2;
					}
				}
			}else{
				RememberFood[point.x][point.y + 1] = 3;
			}
		}
		
	}

	public int[][] comer(int[][] food) {
		food[point.x][point.y] = 6;
		RememberFood[point.x][point.y] = 3;
		FoodCount++;
		return food;
	}

	public int[][] andarPaCima(int[][] food) {
		if (PaCima) {
			Passos++;
			point.x--;
			if (FoodCima) {
				comer(food);
				FoodCima = false;
			}
		} else {
			if (PaDireita || PaEsquerda) {
				Passos++;
				PaDireita = false;
				PaEsquerda = false;
				PaCima = true;
			} else {
				Passos++;
				PaBaixo = false;
				PaDireita = true;
			}
		}
		return food;
	}

	public int[][] andarPaBaixo(int[][] food) {
		if (PaBaixo) {
			Passos++;
			point.x++;
			if (FoodBaixo) {
				comer(food);
				FoodBaixo = false;
			}
		} else {
			if (PaDireita || PaEsquerda) {
				Passos++;
				PaDireita = false;
				PaEsquerda = false;
				PaBaixo = true;
			} else {
				Passos++;
				PaCima = false;
				PaEsquerda = true;
			}
		}
		return food;
	}

	public int[][] andarPaDireita(int[][] food) {
		if (PaDireita) {
			Passos++;
			point.y++;
			if (FoodDireita) {
				comer(food);
				FoodDireita = false;
			}
		} else {
			if (PaCima || PaBaixo) {
				Passos++;
				PaCima = false;
				PaBaixo = false;
				PaDireita = true;
			} else {
				Passos++;
				PaEsquerda = false;
				PaCima = true;
			}
		}
		return food;
	}

	public int[][] andarPaEsquerda(int[][] food) {
		if (PaEsquerda) {
			Passos++;
			point.y--;
			if (FoodEsquerda) {
				comer(food);
				FoodEsquerda = false;
			}
		} else {
			if (PaCima || PaBaixo) {
				Passos++;
				PaCima = false;
				PaBaixo = false;
				PaEsquerda = true;
			} else {
				Passos++;
				PaDireita = false;
				PaBaixo = true;
			}
		}
		return food;
	}

}
