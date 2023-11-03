package org.academiadecodigo;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Entity{
    private Picture player;
    private Pokemon pokemon;

    private int currentFrame;
    private int currentSide;

    private final int shootingCounter=0;

    private Picture bullet;



    public Player() {
        this.pokemon = Pokemon.BULBASAUR;
        this.currentFrame = 1;
        this.currentSide = 2;

    }

    public Picture getPlayer() {
        return player;
    }

    public void setPlayer(Picture player) {
        this.player = player;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(int currentSide) {
        this.currentSide = currentSide;
    }



    public void moveJump() {
        if (currentSide == 2) {
            player.translate(60, -100);
            return;
        }
        player.translate(-60,-100);
    }

    public void moveFall() {
        if(currentSide == 2){
            player.translate(60, 100);
            return;
        }
        player.translate(-60,100);
    }
    }
