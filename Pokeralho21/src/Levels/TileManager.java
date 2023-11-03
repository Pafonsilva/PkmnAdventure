package Levels;

import org.academiadecodigo.FieldSize;
import org.academiadecodigo.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Format;

public class TileManager {
    private final Tile[] tile;
    private final Tile[][] mapTiles;
    int[][] mapTileNum;
    private int count = 0;

    private static Tile[] collidableTiles = new Tile[501];

    public Tile[][] getMapTiles() {
        return mapTiles;
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public Tile[] getTile() {
        return tile;
    }

    public TileManager(){

        tile = new Tile[10];
        mapTiles = new Tile[FieldSize.fieldMaxCol][FieldSize.fieldMaxRow];
        mapTileNum = new int [FieldSize.fieldMaxCol][FieldSize.fieldMaxRow];
        loadMap();
        draw();
    }

    public static Tile[] getCollidableTiles() {
        return collidableTiles;
    }

    public void loadMap() {
        try {
            InputStream in = getClass().getResourceAsStream("map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            int col = 0;
            int row = 0;

            while (col < FieldSize.fieldMaxCol && row < FieldSize.fieldMaxRow){
                String line = br.readLine();

                while (col < FieldSize.fieldMaxCol){

                    String[] numbers = line.split(" ");


                    int num = Integer.parseInt(numbers[col]);

                   mapTileNum[col][row] = num;

                   if (num == 0) {
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/grass/grass0.png");
                   }
                   if(num == 1){
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10, "resources/FloorTiles/floor_vines4.png");
                        mapTiles[col][row].setCollision(true);
                   }
                   if(num == 2){
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10, "resources/FloorTiles/floor_vines4.png");
                   }
                   if(num == 3){
                       mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/grass/grass_s.png");
                   }
                   if(num == 4){
                       mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/bog_green0.png");
                       mapTiles[col][row].setBulbasaurCollision(true);
                   }
                   if(num == 5){
                       mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/lava3.png");
                       mapTiles[col][row].setCharmanderCollision(true);                  }
                    if(num == 6){
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/electric tile.png");
                        mapTiles[col][row].setPikachuCollision(true);                    }
                    if(num == 7){
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/water_tile.png");
                        mapTiles[col][row].setSquirtleColliion(true);                    }
                    if(num == 8){
                        mapTiles[col][row] = new Tile(col * FieldSize.tilesSize + 10, row * FieldSize.tilesSize + 10,"resources/FloorTiles/poketiles/flag.png");
                        mapTiles[col][row].setVictoryCollision(true);                    }

                    col++;
                }

                col = 0;
                row++;

            }
            br.close();

            for (int i = 0; i < mapTiles.length; i++) {
                for (int j = 0; j < mapTiles[i].length; j++) {
                    if (mapTiles[i][j].isCollision() || mapTiles[i][j].isSquirtleCollision() || mapTiles[i][j].isBulbasaurCollision() || mapTiles[i][j].isPikachuCollision() || mapTiles[i][j].isCharmanderCollision() || mapTiles[i][j].isVictoryCollision()) {
                        collidableTiles[count] = mapTiles[i][j];
                        count++;
                    }
                }
            }
            System.out.println(count);


        } catch (Exception e) {
        }



    }

    public void draw(){

        int col = 0;
        int row = 0;
        int x = 10;
        int y = 10;

        while (col < FieldSize.fieldMaxCol && row < FieldSize.fieldMaxRow){

            //int tileNum = mapTileNum[col][row];


            mapTiles[col][row].draw();
            col++;
           x += FieldSize.tilesSize;

           if(col == FieldSize.fieldMaxCol){
               col = 0;
               x = 0;
               row++;
               y += FieldSize.tilesSize;
           }

        }
    }
}
