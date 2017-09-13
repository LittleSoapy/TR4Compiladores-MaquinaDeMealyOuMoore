package com.neet.gamestates;

import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.neet.main.Game;
import com.neet.managers.GameStateManager;

import Logic.Problem;

public class PlayState extends GameState {
	TiledMapTile TileNone = tiledMap.getTileSets().getTileSet("Ground").getTile(6);
	TiledMapTile TilePacManDireita = tiledMap.getTileSets().getTileSet("Ground").getTile(17);
	TiledMapTile TilePacManBaixo = tiledMap.getTileSets().getTileSet("Ground").getTile(25);
	TiledMapTile TilePacManEsquerda = tiledMap.getTileSets().getTileSet("Ground").getTile(33);
	TiledMapTile TilePacManCima = tiledMap.getTileSets().getTileSet("Ground").getTile(41);
	Problem problema;

	int timer = 0;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		
	}

	public void init() {
		int[][] food = new int[15][15];
		tiledMap = new TmxMapLoader().load("res/maps/map1.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get("Food");
		int x = 0, y = 0;
		for (int i = layer.getWidth() - 1; i >= 0; i--) {
			for (int j = 0; j < layer.getHeight(); j++) {
				food[y][x] = layer.getCell(j, i).getTile().getId();
				x++;
			}
			x = 0;
			y++;
		}
		// tiledMap.getTileSets().getTileSet("Rat").getTile(1);
		problema = new Problem(food);

		/*
		 * x = 1; y = 0; layer.getCell(x, 14 -
		 * y).setTile(tiledMap.getTileSets().getTile(6));
		 */

	}

	public void update(float dt) {
		// o timer no 60 é equivalente a 1 segundo de intervalo
		if (timer == 30) {
			
			timer = 0;
			problema.machine();
			
			int[][] food = problema.food;
			TiledMapTileLayer layerFood = (TiledMapTileLayer) tiledMap.getLayers().get("Food");
			TiledMapTileLayer layerPacman = (TiledMapTileLayer) tiledMap.getLayers().get("Rat");
			int pacX = problema.rato.point.x;
			int pacY = problema.rato.point.y;
			
			
			for (int y = 0; y < 15; y++) {
				for (int x = 0; x < 15; x++) {
					
					
					if (food[y][x] != layerFood.getCell(x, 14 - y).getTile().getId()) {
						layerFood.getCell(x, 14 - y).setTile(TileNone);
					}
					
					if (layerPacman.getCell(x, 14 - y).getTile().getId() == TilePacManDireita.getId()
							|| layerPacman.getCell(x, 14 - y).getTile().getId() == TilePacManEsquerda.getId()
							|| layerPacman.getCell(x, 14 - y).getTile().getId() == TilePacManCima.getId()
							|| layerPacman.getCell(x, 14 - y).getTile().getId() == TilePacManBaixo.getId()) {
						layerPacman.getCell(x, 14 - y).setTile(TileNone);
					}

					if (pacX == y && pacY == x) {
						if(problema.rato.PaCima){
							layerPacman.getCell(x, 14 - y).setTile(TilePacManCima);
						}
						if(problema.rato.PaBaixo){
							layerPacman.getCell(x, 14 - y).setTile(TilePacManBaixo);
						}
						if(problema.rato.PaDireita){
							layerPacman.getCell(x, 14 - y).setTile(TilePacManDireita);
						}
						if(problema.rato.PaEsquerda){
							layerPacman.getCell(x, 14 - y).setTile(TilePacManEsquerda);
						}
						
					}

				}
			}
		}
		timer++;
	}

	public void draw() {
		tiledMapRenderer.setView(Game.camera);
		tiledMapRenderer.render();
	}

	public void handleInput() {

	}

	public void dispose() {

	}

}
