package controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class JsonParser {

    public  List<ChargingPoint> jsonToChargingPointList (String json){
        Type listType = new TypeToken<LinkedList<ChargingPoint>>(){}.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(listType, new ChargingPointDeserializer());
        Gson gson = gsonBuilder.create();

        List<ChargingPoint> chargingPoints = gson.fromJson(json, listType);

        return  chargingPoints;
    }



    private class ChargingPointDeserializer implements JsonDeserializer<List<ChargingPoint>> {

        public List<ChargingPoint> deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
                throws JsonParseException {
            List<ChargingPoint> chargingPoints = new LinkedList<ChargingPoint>();

            JsonArray jsonArray = json.getAsJsonArray();

            for (JsonElement jsonElement: jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                ChargingPoint chargingPoint = new ChargingPoint();

                JsonElement subElement = jsonObject.get("ID");
                if(!subElement.isJsonNull()) {
                    chargingPoint.setId(subElement.getAsInt());
                }

                subElement = jsonObject.get("UUID");
                if(!subElement.isJsonNull())
                    chargingPoint.setUuid(subElement.getAsString());

                subElement = jsonObject.get("ParentChargePointID");
                if(!subElement.isJsonNull())
                    chargingPoint.setParentChargePointID(subElement.getAsInt());

                subElement = jsonObject.get("UsageCost");
                if(!subElement.isJsonNull())
                    chargingPoint.setUsageCost(subElement.getAsDouble());

                JsonElement object = jsonObject.get("OperatorInfo");
                if(!object.isJsonNull())
                    chargingPoint.setOperatorInfo(parseAsOperatorInfo(object));

                subElement = jsonObject.get("AddressInfo");
                if(!subElement.isJsonNull())
                    chargingPoint.setAddressInfo(parseAsAddressInfo(subElement));

                subElement = jsonObject.get("UsageType");
                if(!subElement.isJsonNull())
                    chargingPoint.setUsageType(parseAsUsageType(subElement));




                //DOKOŃCZYĆ


                chargingPoints.add(chargingPoint);
            }

            return chargingPoints;
        }


        private OperatorInfo parseAsOperatorInfo(JsonElement jsonElement) {
            OperatorInfo operatorInfo = new OperatorInfo();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement  =  jsonObject.get("Title");
            if (!subElement.isJsonNull())
                operatorInfo.setTitle(subElement.getAsString());

            subElement = jsonObject.get("WebsiteURL");
            if (!subElement.isJsonNull())
                operatorInfo.setWebsiteURL(subElement.getAsString());

            subElement = jsonObject.get("Comments");
            if (!subElement.isJsonNull())
                operatorInfo.setComments(subElement.getAsString());

            subElement = jsonObject.get("AddressInfo");
            if(!subElement.isJsonNull())
                operatorInfo.setAddressInfo(parseAsAddressInfo(subElement));

            subElement = jsonObject.get("BookingURL");
            if (!subElement.isJsonNull())
                operatorInfo.setBookingURL(subElement.getAsString());

            subElement = jsonObject.get("ContactEmail");
            if (!subElement.isJsonNull())
                operatorInfo.setContactEmail(subElement.getAsString());

            subElement = jsonObject.get("FaultReportEmail");
            if (!subElement.isJsonNull())
                operatorInfo.setFaultReportEmail(subElement.getAsString());

            return  operatorInfo;
        }

        private AddressInfo parseAsAddressInfo(JsonElement jsonElement) {
            AddressInfo addressInfo = new AddressInfo();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull())
                addressInfo.setTitle(subElement.getAsString());

            subElement = jsonObject.get("AddressLine1");
            if (!subElement.isJsonNull())
                addressInfo.setAddressLine1(subElement.getAsString());

            subElement = jsonObject.get("AddressLine2");
            if (!subElement.isJsonNull())
                addressInfo.setAddressLine2(subElement.getAsString());

            subElement = jsonObject.get("Town");
            if (!subElement.isJsonNull())
                addressInfo.setTown(subElement.getAsString());

            subElement = jsonObject.get("StateOrProvince");
            if (!subElement.isJsonNull())
                addressInfo.setStateOrProvince(subElement.getAsString());

            subElement = jsonObject.get("Postcode");
            if (!subElement.isJsonNull())
                addressInfo.setPostcode(subElement.getAsString());

            subElement = jsonObject.get("Country");
            if (!subElement.isJsonNull())
                addressInfo.setCountry(parseAsCountry(subElement));

            subElement = jsonObject.get("Latitude");
            if (!subElement.isJsonNull())
                addressInfo.setLatitude(subElement.getAsDouble());

            subElement = jsonObject.get("Longitude");
            if (!subElement.isJsonNull())
                addressInfo.setLongitude(subElement.getAsDouble());

            subElement = jsonObject.get("ContactTelephone1");
            if (!subElement.isJsonNull())
                addressInfo.setContactTelephone1(subElement.getAsString());

            subElement = jsonObject.get("ContactTelephone2");
            if (!subElement.isJsonNull())
                addressInfo.setContactTelephone2(subElement.getAsString());

            subElement = jsonObject.get("ContactEmail");
            if (!subElement.isJsonNull())
                addressInfo.setContactEmail(subElement.getAsString());

            subElement = jsonObject.get("AccessComments");
            if (!subElement.isJsonNull())
                addressInfo.setAccessComments(subElement.getAsString());

            subElement = jsonObject.get("RelatedURL");
            if (!subElement.isJsonNull())
                addressInfo.setRelatedURL(subElement.getAsString());



            return  addressInfo;
        }

        private Country parseAsCountry(JsonElement jsonElement) {
            Country country = new Country();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement  =  jsonObject.get("Title");
            if (!subElement.isJsonNull())
                country.setTitle(subElement.getAsString());

            subElement = jsonObject.get("ContinentCode");
            if (!subElement.isJsonNull())
                country.setContinentCode(subElement.getAsString());

            subElement = jsonObject.get("ISOCode");
            if (!subElement.isJsonNull())
                country.setIsoCode(subElement.getAsString());

            return  country;
        }

        private UsageType parseAsUsageType(JsonElement jsonElement) {
            UsageType usageType = new UsageType();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement  =  jsonObject.get("Title");
            if (!subElement.isJsonNull())
                usageType.setTitle(subElement.getAsString());

            subElement = jsonObject.get("IsPayAtLocation");
            if (!subElement.isJsonNull())
                usageType.setPayAtLocation(subElement.getAsBoolean());

            subElement = jsonObject.get("IsMembershipRequired");
            if (!subElement.isJsonNull())
                usageType.setMembershipRequired(subElement.getAsBoolean());

            subElement = jsonObject.get("IsAccessKeyRequired");
            if (!subElement.isJsonNull())
                usageType.setAccessKeyRequired(subElement.getAsBoolean());


            return  usageType;
        }

    }


}
