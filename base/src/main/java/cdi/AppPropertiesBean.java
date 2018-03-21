package cdi;

import controller.AppProperties;
import controller.Units;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class AppPropertiesBean {
    public Units getCurrentUnit() {
        return AppProperties.getInstance().getUnits();
    }

    public void setUnits(Units units) {
        AppProperties.getInstance().setUnits(units);
        AppProperties.getInstance().save();
    }

    public String getGoogleApiKey() {
        return AppProperties.getInstance().getGoogleApiKey();
    }

    public void  setGoogleApiKey(String key) {
        AppProperties.getInstance().setGoogleApiKeyp(key);
        AppProperties.getInstance().save();
    }
}
