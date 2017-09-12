package Logic;

public class Problem {

	private Rat rato = new Rat();
	int[][] food = new int[15][15];
	int maxFood = 0;

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

				} else {
					int x = 0;
					if (rato.FoodCima) {
						x++;
					}
					if (rato.FoodBaixo) {
						x++;
					}
					if (rato.FoodDireita) {
						x++;
					}
					if (rato.FoodEsquerda) {
						x++;
					}
					if (x == 3 || x == 2) {
						rato.estado = 2;
					}else{
						rato.estado = 0;
					}
				}
				break;

			case 2:
				if (!(rato.FoodCima ^ rato.FoodBaixo ^ rato.FoodEsquerda ^ rato.FoodDireita)) {
					if (rato.FoodCima && rato.PaCima) {
						rato.andarPaCima(food);
					} else {
						if (rato.FoodBaixo && rato.PaBaixo) {
							rato.andarPaBaixo(food);
						} else {
							if (rato.FoodEsquerda && rato.PaEsquerda) {
								rato.andarPaEsquerda(food);
							} else {
								if (rato.FoodDireita && rato.PaDireita) {
									rato.andarPaDireita(food);
								} else {
									if (rato.PaDireita && rato.FoodBaixo) {
										rato.andarPaBaixo(food);
									} else {
										if (rato.PaBaixo && rato.FoodEsquerda) {
											rato.andarPaEsquerda(food);
										} else {
											if (rato.PaEsquerda && rato.FoodCima) {
												rato.andarPaCima(food);
											} else {
												if (rato.PaCima && rato.FoodDireita) {
													rato.andarPaDireita(food);
												}
											}
										}
									}
								}
							}
						}
					}
				} else {
					int x = 0;
					if (rato.FoodCima) {
						x++;
					}
					if (rato.FoodBaixo) {
						x++;
					}
					if (rato.FoodDireita) {
						x++;
					}
					if (rato.FoodEsquerda) {
						x++;
					}
					if (x == 1) {
						rato.estado = 1;
					} else {
						rato.estado = 0;
					}
				}
				break;
			case 0:
				break;
			}
		}

	}

	public Rat getRato() {
		return rato;
	}

	public int[][] getFood() {
		return food;
	}

}
