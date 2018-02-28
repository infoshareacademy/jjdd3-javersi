package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonLoader {

    public static String loadFromFile(String path)throws IOException {

        String everything ="";
        String line = null;

        FileReader fileReader =
                new FileReader(path);

        BufferedReader bufferedReader =
                new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            everything += line;
        }
        bufferedReader.close();
        return everything;
    }
}
