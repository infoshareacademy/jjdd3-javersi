package model;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.*;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

public class modelTest {

    @Test
    public void testAddressInfo() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());;
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(AddressInfo.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testChargingPoint() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(ChargingPoint.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testConnection() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(Connection.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testConnectionType() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(ConnectionType.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testCoordinates() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(Coordinates.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testCountry() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(Country.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testCurrentType() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(CurrentType.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testLevel() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(Level.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testOperatorInfo() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(OperatorInfo.class);
        pojoValidator.runValidation(pojoClass);
    }

    @Test
    public void testUsageType() {
        PojoValidator pojoValidator = new PojoValidator();

        pojoValidator.addRule(new NoPublicFieldsRule());
        pojoValidator.addRule(new NoStaticExceptFinalRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new NoNestedClassRule());
        pojoValidator.addRule(new NoPublicFieldsExceptStaticFinalRule());
        pojoValidator.addRule(new SerializableMustHaveSerialVersionUIDRule());

        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        PojoClass pojoClass = PojoClassFactory.getPojoClass(UsageType.class);
        pojoValidator.runValidation(pojoClass);
    }

}
