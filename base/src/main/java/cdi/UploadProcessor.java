package cdi;

import dao.AddressInfoDao;
import dao.ChargingPointDao;
import dao.CountryDao;
import model.AddressInfo;
import model.ChargingPoint;
import model.Country;

import javax.enterprise.context.RequestScoped;
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
        chargingPointList.forEach(c -> {
            if (!addressInfos.stream().anyMatch(a -> a.getId() == c.getAddressInfo().getId())) {
                addressInfos.add(c.getAddressInfo());
            }

        });
        addressInfos.forEach(c -> addressInfoDao.save(c));



        Set<ChargingPoint> chargingPoints = new HashSet<>();
        chargingPointList.forEach(c -> {
            if (!chargingPoints.stream().anyMatch(q -> q.getId() == c.getId())) {
                chargingPoints.add(c);
            }

        });



        chargingPoints.forEach(c -> chargingPointDao.save(c));
    }

    void clearTables() {
        chargingPointDao.deleteAll();
        addressInfoDao.deleteAll();
        countryDao.deleteAll();
    }
}
