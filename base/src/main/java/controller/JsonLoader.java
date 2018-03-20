package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonLoader {
    public static final Logger LOG = LoggerFactory.getLogger(JsonLoader.class);

    private JsonLoader() {
    }

    public static String loadFromFile(String path) {
        String everything = "";
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            LOG.error("File " + path + " not found");
            return null;
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((line = bufferedReader.readLine()) != null) {
                everything += line;
            }
        } catch (IOException e) {
            LOG.error("Unknown IO exception");
            return null;
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException i) {
                LOG.error("Can not close buffer reader");
            }
        }
        return everything;
    }
}
