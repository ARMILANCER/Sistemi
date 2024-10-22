package Statistics;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Frequencies {
    HashMap<Character,Integer> counters = new HashMap();

    public void counter() {
        int cont;
        for(char character = 'a';character <= 'z';character++) {
            Pattern pattern = Pattern.compile(String.valueOf(character),Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher("Sempre caro mi fu quest’ermo colle,\n" +
                    "E questa siepe, che da tanta parte\n" +
                    "Dell’ultimo orizzonte il guardo esclude.\n" +
                    "Ma sedendo e mirando, interminati\n" +
                    "Spazi di là da quella, e sovrumani\n" +
                    "Silenzi, e profondissima quiete\n" +
                    "Io nel pensier mi fingo; ove per poco\n" +
                    "Il cor non si spaura. E come il vento\n" +
                    "Odo stormir tra queste piante, io quello\n" +
                    "Infinito silenzio a questa voce\n" +
                    "Vo comparando: e mi sovvien l’eterno,\n" +
                    "E le morte stagioni, e la presente\n" +
                    "E viva, e il suon di lei. Così tra questa\n" +
                    "Immensità s’annega il pensier mio:\n" +
                    "E il naufragar m’è dolce in questo mare.");
            cont = 0;
            while(matcher.find()){
                counters.put(character,++cont);
            }
        }

        counters.forEach((character, count) -> {
            System.out.println("Character: "+character+" Numbers: "+count);
        });
    }
    public static void main(String[] args){
        Frequencies statistics = new Frequencies();
        statistics.counter();
    }
}
