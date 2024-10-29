package jogo;

import jplay.Sound;
import jplay.URL;

public class Som {
    private static Sound musica;

    public static void play(String audio) {
        stop();
        musica = new Sound(URL.audio(audio));
        Som.musica.play();
        Som.musica.setRepeat(true);
    }
    public static void stop() {
        if(musica != null) {
            musica.stop();
        }
    }
}
