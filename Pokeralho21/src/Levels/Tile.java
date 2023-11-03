package Levels;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Tile extends Picture{

    public Tile(int x, int y, String picture) {
        super(x,y,picture);
    }

    private Picture picture;

    private boolean bulbasaurCollision = false;

    private boolean squirtleCollision = false;

    private boolean charmanderCollision = false;

    private boolean pikachuCollision = false;

    private boolean victoryCollision = false;

    public Picture getPicture() {
        return picture;
    }

    private boolean collision = false;

    public boolean isCollision() {
        return collision;
    }

    public void setBulbasaurCollision(boolean bulbasaurCollision) {
        this.bulbasaurCollision = bulbasaurCollision;
    }

    public void setCharmanderCollision(boolean charmanderCollision) {
        this.charmanderCollision = charmanderCollision;
    }

    public void setPikachuCollision(boolean pikachuCollision) {
        this.pikachuCollision = pikachuCollision;
    }

    public void setSquirtleColliion(boolean squirtleColliion) {
        this.squirtleCollision = squirtleColliion;
    }

    public void setVictoryCollision(boolean victoryCollision) {
        this.victoryCollision = victoryCollision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isBulbasaurCollision() {
        return bulbasaurCollision;
    }

    public boolean isCharmanderCollision() {
        return charmanderCollision;
    }

    public boolean isSquirtleCollision() {
        return squirtleCollision;
    }

    public boolean isPikachuCollision() {
        return pikachuCollision;
    }

    public boolean isVictoryCollision() {
        return victoryCollision;
    }
}


