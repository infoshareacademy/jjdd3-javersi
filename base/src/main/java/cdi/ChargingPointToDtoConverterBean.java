package cdi;

import dto.ChargingPointDto;
import model.ChargingPoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ChargingPointToDtoConverterBean {

    @Inject
    private PromotedChargingPointsBean promotedChargingPointsBean;

    public List<ChargingPointDto> convertList (List<ChargingPoint> cp) {
        return  setPromotedOnList(ChargingPointDto.convertFromChargingPointList(cp));
    }

    public List<ChargingPointDto> setPromotedOnList(List<ChargingPointDto> cpd) {
        cpd.forEach(s -> s.setPromoted(promotedChargingPointsBean.isPromoted(s.getId())));
        return cpd;
    }
}
