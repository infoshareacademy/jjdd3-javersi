package cdi;

import dao.PromotedChargingPointDao;
import model.ChargingPoint;
import model.PromotedChargingPoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.EmptyStackException;
import java.util.List;

@RequestScoped
@Named
public class PromotedChargingPointsBean {

    @Inject
    private PromotedChargingPointDao promotedChargingPointDao;
    
    public PromotedChargingPointsBean() {
    }

    public boolean isPromoted(ChargingPoint chargingPoint) {
        return isPromoted(chargingPoint.getId());
    }

    public boolean isPromoted(int chargingPointId) {

        PromotedChargingPoint promotedChargingPoint = promotedChargingPointDao.findById(chargingPointId);

        return  promotedChargingPoint != null; 
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
