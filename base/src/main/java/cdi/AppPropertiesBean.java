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
    }

}
