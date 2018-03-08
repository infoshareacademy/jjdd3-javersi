package cdi;

import dao.AddressInfoDao;
import dao.ChargingPointDao;
import dao.CountryDao;
import model.AddressInfo;
import model.ChargingPoint;
import model.Country;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class UploadProcessor {
    @Inject
    ChargingPointDao chargingPointDao;

    @Inject
    CountryDao countryDao;

    @Inject
    AddressInfoDao addressInfoDao;
    void saveChargingPoints (List<ChargingPoint> chargingPointList) {

        Set<Country> countries = new HashSet<>();
        chargingPointList.forEach(c -> countries.add(c.getAddressInfo().getCountry()));
        countries.forEach(c -> countryDao.save(c));

        Set<AddressInfo> addressInfos = new HashSet<>();
        chargingPointList.forEach(c -> addressInfos.add(c.getAddressInfo()));
        addressInfos.forEach(c -> addressInfoDao.save(c));

        chargingPointList.forEach(c -> chargingPointDao.save(c));
    }
}
