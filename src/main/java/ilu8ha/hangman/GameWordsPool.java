package ilu8ha.hangman;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameWordsPool {
    private static final List<String> wordsPool = new ArrayList<>();
    private static final String fileName = "wordsList.txt";
    public static void Init(){
        try(InputStream inputStream = GameWordsPool.class.getResourceAsStream("/" + fileName)) {
            if(inputStream != null){
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){
                    String line;
                    while ((line = reader.readLine()) != null){
                        wordsPool.addAll(Arrays.stream(line.split(":")).toList());
                    }
                }
            }else {
                //ERROR_FILE_NOT_FOUND 2 (0x2)
                System.exit(2);
            }
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
    }

    public static List<String> getWordsPool(){
        return new ArrayList<>(wordsPool);
    }
}
