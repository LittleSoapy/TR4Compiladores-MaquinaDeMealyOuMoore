package Logic;

import java.awt.Point;

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
					if (x == 0) {
						rato.estado = 0;
					}else{
						rato.estado = 2;
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
				if(!(rato.FoodCima || rato.FoodBaixo || rato.FoodEsquerda || rato.FoodDireita)) {
					Point targetPoint = rato.getPoint();
					int targetType = 0;
					double minorDistance = 0;
					
					//double dx = pt1.x-pt2.y;
					//double dy = pt1.y-pt2.y;
					//double distance = Math.sqrt(dx*dx+dy*dy);
					
					
					for (int y = 0; y < 15; y++) {
						for (int x = 0; x < 15; x++) {
							if(rato.RememberFood[y][x] == 1) {
								double dx = rato.getPoint().getX() - x;
								double dy = rato.getPoint().getY() - y;
								double Distance = Math.sqrt(dx*dx+dy*dy);
								if(Distance<minorDistance) {
									minorDistance = Distance;
									targetPoint = new Point(y,x);
								}
								targetType = 1;
							}else {
								if(targetType != 1 && rato.RememberFood[y][x] == 2) {
									double dx = rato.getPoint().getX() - x;
									double dy = rato.getPoint().getY() - y;
									double Distance = Math.sqrt(dx*dx+dy*dy);
									if(Distance<minorDistance) {
										minorDistance = Distance;
										targetPoint = new Point(y,x);
									}
									targetType = 2;
								}
							}
						}
						
					}
					//if() {
					//AQUI	
					//}
					
					
				}else {
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
						rato.estado = 2;
					}
				}
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
