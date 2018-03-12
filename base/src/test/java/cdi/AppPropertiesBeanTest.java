package cdi;

import controller.Units;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppPropertiesBeanTest {

    AppPropertiesBean appPropertiesBean = new AppPropertiesBean();

    @Test
    public void shouldReturnSetValue() {
        //GIVEN
        Units expected = Units.MILES;
        appPropertiesBean.setUnits(expected);
        //WHEN
        Units result = appPropertiesBean.getCurrentUnit();

        //THEN
        assertEquals(expected, result);
    }
}