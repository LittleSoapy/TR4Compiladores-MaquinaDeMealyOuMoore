package Logic;

public class Problem {

	public Rat rato = new Rat();
	public int[][] food = new int[15][15];
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
				}
				if (rato.aDireita <= 0) {
					rato.estado = 3;
				}
				break;
			case 3:
				if (rato.aEsquerda == 1) {
					rato.virarPaEsquerda();
					rato.estado = 1;
				}
				if (rato.aEsquerda <= 0) {
					rato.estado = 4;
				}
				break;
			case 4:
				if(rato.aFrente >= 0) {
					rato.andarPaFrente(food);
					rato.estado = 5;
				}else {
					if(rato.aDireita >= 0) {
						rato.virarPaDireita();
						rato.estado = 12;
					}else {
						rato.virarPaEsquerda();
						rato.estado = 17;
					}
					
					
				}
				
				break;
			case 5:
				if (rato.aFrente == 1) {
					rato.estado = 1;
				}else {
					rato.estado = 6;
				}
				
				break;
			case 6:
				if (rato.aDireita == 1) {
					rato.virarPaDireita();
					rato.estado = 1;
				}else {
					rato.estado = 7;
				}
				
				break;
			case 7:
				if (rato.aEsquerda == 1) {
					rato.virarPaEsquerda();
					rato.estado = 1;
				}else {
					rato.estado = 8;
				}
				
				break;
			case 8:
				rato.virarPaDireita();
				rato.estado = 9;
				break;
			case 9:
				rato.virarPaDireita();
				rato.estado = 10;
				break;
			case 10:
				rato.andarPaFrente(food);
				rato.estado = 11;
				break;
			case 11:
				rato.virarPaEsquerda();
				rato.estado = 12;
				break;
			case 12:
				if(rato.aFrente >= 0) {
					rato.andarPaFrente(food);
					rato.estado = 13;
				}else {
					rato.virarPaDireita();
					rato.estado = 16;
				}
				break;
			case 13:
				if (rato.aFrente == 1) {
					rato.estado = 1;
				}else {
					rato.estado = 14;
				}
				
				break;
			case 14:
				rato.virarPaDireita();
				rato.estado = 15;
				break;
			case 15:
				rato.virarPaDireita();
				rato.estado = 16;
				break;
			case 16:
				if(rato.aFrente >= 0) {
					rato.andarPaFrente(food);
					rato.estado = 17;
				}else {
					rato.estado = 0;
				}
					
				break;
			case 17:
				if(rato.aFrente >= 0) {
					rato.andarPaFrente(food);
					rato.estado = 18;
				}else {
					rato.estado = 0;
				}
				break;
			case 18:
				if (rato.aFrente == 1) {
					rato.estado = 1;
				}else {
					rato.estado = 0;
				}
				
				break;
			case 0:
				break;

			}
		}

	}

}
