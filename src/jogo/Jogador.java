package jogo;

import jplay.*;
import jplay.Window;

import java.awt.*;
import java.util.Vector;


public class Jogador extends Sprite {

    private double velocidade = 1;
    private int direcao = 3;
    private boolean movendo;

    Controle controle = new Controle();


    private boolean colisaoVertical(GameObject obj, GameObject obj2) {
        if(obj2.x + obj2.width <= obj.x)
            return false;
        if(obj.x + obj.width <= obj2.x)
            return false;
        return true;
    }
    private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
        if(obj2.y + obj2.height <= obj.y)
            return false;
        if(obj.y + obj.height <= obj2.y)
            return false;
        return true;
    }

    public Jogador(int x, int y) {
        super(URL.sprite("jogador.png"),20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }

    public void mover(Window janela, Keyboard teclado) {

        if(teclado.keyDown(Keyboard.LEFT_KEY)){
            if(this.x > 0)
                this.x -= velocidade;
            if(direcao != 1){
                setSequence(4, 8);
                direcao = 1;
            } movendo = true;
        }else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
            if(this.x < janela.getWidth() + 150)
                this.x += velocidade;
            if(direcao != 2){
                setSequence(8, 12);
                direcao = 2;
            }movendo = true;
        }else if(teclado.keyDown(Keyboard.UP_KEY)){
            if(this.y > 0)
                this.y -= velocidade;
            if(direcao != 4){
                setSequence(12, 16);
                direcao = 4;
            } movendo = true;
        }else if(teclado.keyDown(Keyboard.DOWN_KEY)){
            if(this.y < janela.getHeight() + 100)
                this.y += velocidade;
            if(direcao != 5){
                setSequence(1, 4);
                direcao = 5;
            }movendo = true;
        }
        if(movendo){
            update();
            movendo = false;
        }
    }

    public void caminho(Scene cena) {
        Point min = new Point((int)this.x, (int)this.y);
        Point max = new Point((int)this.x + this.width, (int)this.y + this.height);

        Vector<?> tiles = cena.getTilesFromPosition(min, max);

        for(int i = 0; i < tiles.size(); i++){
            TileInfo tile = (TileInfo)tiles.elementAt(i);

            if(controle.colisao(this, tile)== true){
                if(colisaoVertical(this, tile)){
                    if(tile.y + tile.height - 2 < this.y){
                        this.y = tile.y + tile.height;
                    }
                    else if(tile.y > this.y + this.height){
                        this.y = tile.y + tile.height;
                    }
                }
                if(colisaoHorizontal(this, tile)){
                    if(tile.x > this.x + this.width){
                        this.x = tile.x - tile.width;
                    }
                    else{
                        this.x = tile.x + tile.width;
                    }
                }
            }
        }
    }





}