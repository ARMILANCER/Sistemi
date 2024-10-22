package Statistics;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Frequencies {
    HashMap<Character,Integer> counters = new HashMap();
    StringBuilder stringBuilder = new StringBuilder();

    public void panelControll(String path) {
        try(RandomAccessFile raf = new RandomAccessFile(path,"rw")){
            counter(inRead(raf));
        }catch (IOException e){

        }
    }

    public String inRead(RandomAccessFile raf) throws IOException {
        while(raf.getFilePointer()<raf.length()){
            stringBuilder.append(raf.readLine());
        }
        return stringBuilder.toString();
    }

    public void counter(String text) {
        int cont;
        for(char character = 'a';character <= 'z';character++) {
            Pattern pattern = Pattern.compile(String.valueOf(character),Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
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
        statistics.panelControll("/Users/christianbrito/Documents/Eli/Sistemi/Projects/src/Statistics/file.txt");
    }
}
