package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.Menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class AppProperties {

    private static final Logger LOG = LoggerFactory.getLogger(AppProperties.class);

    private static final String FILE_NAME = "config.properties";
    private static final String UNIT_PROPERTY_NAME = "unit";

    private Properties applicationProps = new Properties();

    private static AppProperties instance;

    private AppProperties() {
        load();
    }

    static {
        try {
            instance = new AppProperties();
        } catch (Exception e) {
            LOG.error("RuntimeException was catched");
            throw new RuntimeException("Exception occured in creating singleton instance");

        }
    }

    public static AppProperties getInstance() {
        return instance;
    }

    private void load() {
        FileInputStream in;
        try {
            in = new FileInputStream(FILE_NAME);
            applicationProps.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            LOG.error("FileNotFoundException was catched");
            creatDefaultFile();
            load();
        } catch (IOException e) {
            LOG.error("IOException was catched");
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
            LOG.error("FileNotFoundException was catched");
        } catch (IOException e) {
            LOG.error("IOException was catched");
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