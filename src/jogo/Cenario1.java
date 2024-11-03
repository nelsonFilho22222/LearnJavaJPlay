package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Controle {

    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Zumbi zumbi;

    private Keyboard teclado;

    public Cenario1(Window window) {
       janela = window;
       cena = new Scene();
       cena.loadFromFile(URL.scenario("Cenario1.scn"));
       jogador = new Jogador(640, 350);
       teclado = janela.getKeyboard();
       zumbi = new Zumbi(300, 300);

        Som.play("musica.mid");
       run();
    }

    private void run() {
        while(true) {
//            cena.draw();

            cena.moveScene(jogador);

            jogador.mover(janela, teclado);
            jogador.caminho(cena);

            zumbi.caminho(cena);
            zumbi.perseguir(jogador.x, jogador.y);

            zumbi.x += cena.getXOffset();
            zumbi.y += cena.getYOffset();

            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();

            jogador.draw();
            zumbi.draw();
            janela.update();
            janela.delay(2);

        }
    }

}
