package Logic;

public class Problem {

	private Rat rato = new Rat();
	int[][] food = new int[15][15];
	int maxFood;

	public Problem(int[][] food) {
		this.food = food;
		maxFood = maxFood();
	}

	public void machine() {
		if (maxFood != rato.FoodCount) {
			rato.see(food);

			switch (rato.estado) {
			case 1:
				if (rato.FoodCima ^ rato.FoodBaixo ^ rato.FoodEsquerda ^ rato.FoodDireita) {
					if (rato.FoodCima) {
						rato.andarPaCima(food);
					} else {
						if (rato.FoodBaixo) {
							rato.andarPaBaixo(food);
						} else {
							if (rato.FoodEsquerda) {
								rato.andarPaEsquerda(food);
							} else {
								if (rato.FoodDireita) {
									rato.andarPaDireita(food);
								}
							}
						}
					}
				}else{
					
				}
				break;

			case 2:
				break;

			}
		}
	}

	public int maxFood() {
		int max = 0;
		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food.length; j++) {
				if (food[i][j] == 5) {
					max++;
				}
			}
		}
		return max;
	}

	public Rat getRato() {
		return rato;
	}

	public int[][] getFood() {
		return food;
	}

}
