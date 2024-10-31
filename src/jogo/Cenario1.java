package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Controle {

    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;

    public Cenario1(Window window) {
       janela = window;
       cena = new Scene();
       cena.loadFromFile(URL.scenario("Cenario1.scn"));
       jogador = new Jogador(640, 350);
       teclado = janela.getKeyboard();

        Som.play("musica.mid");
       run();
    }

    private void run() {
        while(true) {
//            cena.draw();

            jogador.mover(janela, teclado);
            jogador.caminho(cena);
            cena.moveScene(jogador);

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            jogador.draw();
            janela.update();
            janela.delay(2);

        }
    }

}
