package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Entity extends Picture {


    private Rectangle solidArea;

    private boolean collision = false;

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isCollided() {
        return collision;
    }

    public Entity(){
    }




    public Rectangle getSolidArea() {
        return solidArea;
    }
}
