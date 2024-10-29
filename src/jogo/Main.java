package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Window janela = new Window(640, 480);
        Window janela = new Window(800, 600);
        GameImage plano = new  GameImage(URL.sprite("menu.png"));
        Keyboard teclado = janela.getKeyboard();
        while(true){
            plano.draw();
            janela.update();

            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario1(janela);
            }
        }
    }
}