package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
    private static final String FILE_NAME = "src/main/resources/config.properties";
    private static final String UNIT_PROPERTY_NAME = "unit";

    private Properties applicationProps = new Properties();

    private static AppProperties instance;

    public AppProperties() {
        load();
    }

    static{
        try{
            instance = new AppProperties();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static AppProperties getInstance(){
        return instance;
    }

    private void load() {
        FileInputStream in;
        try {
            in = new FileInputStream(FILE_NAME);
            applicationProps.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            creatDefaultFile();
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatDefaultFile() {
        applicationProps.setProperty(UNIT_PROPERTY_NAME, Units.kilometres.toString());
        save();
    }

    public void save() {
        FileOutputStream out;
        try {
            out = new FileOutputStream(FILE_NAME);
            applicationProps.store(out, "chosen unit");
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Units getUnits() {
        String propName = applicationProps.getProperty(UNIT_PROPERTY_NAME);
        return Units.valueOf(propName);
    }

    public void setUnits(Units value) {
        applicationProps.setProperty(UNIT_PROPERTY_NAME, value.toString());
    }
}



