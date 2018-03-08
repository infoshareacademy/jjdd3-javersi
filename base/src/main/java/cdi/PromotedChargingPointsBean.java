package cdi;

import dao.PromotedChargingPointDao;
import model.ChargingPoint;
import model.PromotedChargingPoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PromotedChargingPointsBean {

    @Inject
    PromotedChargingPointDao promotedChargingPointDao;

    private List<PromotedChargingPoint> promotedChargingPoints;
    public PromotedChargingPointsBean() {
        promotedChargingPoints = promotedChargingPointDao.findAll();
    }

    public boolean isPromoted(ChargingPoint chargingPoint) {
        return isPromoted(chargingPoint.getId());
    }

    public boolean isPromoted(int chargingPointId) {
        return  promotedChargingPoints.stream().anyMatch(p -> p.getChargingPointId() == chargingPointId);
    }

    public void addToPromoted(ChargingPoint chargingPoint) {
        addToPromoted(chargingPoint.getId());
    }

    public void addToPromoted(int chargingPointId) {
        addToPromoted(new PromotedChargingPoint(chargingPointId));
    }

    private void addToPromoted(PromotedChargingPoint promotedChargingPoint) {
        promotedChargingPointDao.save(promotedChargingPoint);
    }

    public void removeFromPromoted(ChargingPoint chargingPoint) {
        removeFromPromoted(chargingPoint.getId());
    }

    public void removeFromPromoted(int chargingPointId) {
        promotedChargingPointDao.delete(chargingPointId);
    }

}