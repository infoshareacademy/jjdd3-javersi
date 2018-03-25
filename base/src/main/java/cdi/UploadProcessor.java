package cdi;

import dao.*;
import model.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class UploadProcessor {

    @Inject
    LevelDao levelDao;

    @Inject
    ConnectionDao connectionDao;

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

        Set<Level> levels = new HashSet<>();
        chargingPointList.forEach(c -> c.getConnectionList().forEach(n -> {
            if (!levels.stream().anyMatch(a -> a.getId() == n.getLevel().getId())) {
                levels.add(n.getLevel());
            }
        }));
        levels.forEach(c -> levelDao.save(c));

        Set<Connection> connections = new HashSet<>();
        chargingPointList.forEach(c -> c.getConnectionList().forEach(n -> {
            if (!connections.stream().anyMatch(a -> a.getId() == n.getId())) {
                connections.add(n);
            }
        }));
        connections.forEach(c -> connectionDao.save(c));
    }

    void clearTables() {
        chargingPointDao.deleteAll();
        addressInfoDao.deleteAll();
        countryDao.deleteAll();
        connectionDao.deleteAll();
        levelDao.deleteAll();
    }
}
