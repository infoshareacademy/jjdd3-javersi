package controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonParser {

    public List<ChargingPoint> jsonToChargingPointList(String json) {
        Type listType = new TypeToken<LinkedList<ChargingPoint>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(listType, new ChargingPointDeserializer());
        Gson gson = gsonBuilder.create();

        List<ChargingPoint> chargingPoints = gson.fromJson(json, listType);

        return chargingPoints;
    }

    public Set<Country> countries = new HashSet<>();

    private class ChargingPointDeserializer implements JsonDeserializer<List<ChargingPoint>> {
        public List<ChargingPoint> deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
                throws JsonParseException {
            List<ChargingPoint> chargingPoints = new LinkedList<ChargingPoint>();

            JsonArray jsonArray = json.getAsJsonArray();

            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                ChargingPoint chargingPoint = new ChargingPoint();

                JsonElement subElement = jsonObject.get("ID");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setId(subElement.getAsInt());
                }

                subElement = jsonObject.get("UUID");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setUuid(subElement.getAsString());
                }

                subElement = jsonObject.get("ParentChargePointID");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setParentChargePointID(subElement.getAsInt());
                }

                JsonElement object = jsonObject.get("OperatorInfo");
                if (!object.isJsonNull()) {
                    chargingPoint.setOperatorInfo(parseAsOperatorInfo(object));
                }

                subElement = jsonObject.get("UsageType");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setUsageType(parseAsUsageType(subElement));
                }

                subElement = jsonObject.get("UsageCost");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setUsageCost(subElement.getAsDouble());
                }

                subElement = jsonObject.get("AddressInfo");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setAddressInfo(parseAsAddressInfo(subElement));
                }

                subElement = jsonObject.get("StatusType");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setStatusType(parseAsStatusType(subElement));
                }

                subElement = jsonObject.get("DateLastStatusUpdate");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDateLastStatusUpdate(parseDate(subElement.getAsString()));
                }

                subElement = jsonObject.get("DataQualityLevel");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDataQualityLevel(subElement.getAsInt());
                }

                subElement = jsonObject.get("DateCreated");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDateCreated(parseDate(subElement.getAsString()));
                }

                subElement = jsonObject.getAsJsonArray("Connections");
                if (!subElement.isJsonNull()) {
                    List<Connection> connectionList = new ArrayList<Connection>();
                    for (JsonElement subArrayElement : subElement.getAsJsonArray()) {
                        if (!subArrayElement.isJsonNull())
                            connectionList.add(parseAsConnection(subArrayElement));
                    }
                    chargingPoint.setConnectionList(connectionList);
                }

                subElement = jsonObject.get("DateLastVerified");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDateLastVerified(parseDate(subElement.getAsString()));
                }

                subElement = jsonObject.get("NumberOfPoints");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setNumberOfPoints(subElement.getAsInt());
                }

                subElement = jsonObject.get("GeneralComments");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setGeneralComments(subElement.getAsString());
                }

                subElement = jsonObject.get("DatePlanned");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDatePlanned(parseDate(subElement.getAsString()));
                }

                subElement = jsonObject.get("DateLastConfirmed");
                if (!subElement.isJsonNull()) {
                    chargingPoint.setDateLastConfirmed(parseDate(subElement.getAsString()));
                }
                chargingPoints.add(chargingPoint);
            }

            return chargingPoints;
        }

        private OperatorInfo parseAsOperatorInfo(JsonElement jsonElement) {
            OperatorInfo operatorInfo = new OperatorInfo();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                operatorInfo.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("WebsiteURL");
            if (!subElement.isJsonNull()) {
                operatorInfo.setWebsiteURL(subElement.getAsString());
            }

            subElement = jsonObject.get("Comments");
            if (!subElement.isJsonNull()) {
                operatorInfo.setComments(subElement.getAsString());
            }

            subElement = jsonObject.get("AddressInfo");
            if (!subElement.isJsonNull()) {
                operatorInfo.setAddressInfo(parseAsAddressInfo(subElement));
            }

            subElement = jsonObject.get("BookingURL");
            if (!subElement.isJsonNull()) {
                operatorInfo.setBookingURL(subElement.getAsString());
            }

            subElement = jsonObject.get("ContactEmail");
            if (!subElement.isJsonNull()) {
                operatorInfo.setContactEmail(subElement.getAsString());
            }

            subElement = jsonObject.get("FaultReportEmail");
            if (!subElement.isJsonNull()) {
                operatorInfo.setFaultReportEmail(subElement.getAsString());
            }

            return operatorInfo;
        }

        private AddressInfo parseAsAddressInfo(JsonElement jsonElement) {
            AddressInfo addressInfo = new AddressInfo();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("ID");
            if (!subElement.isJsonNull()) {
                addressInfo.setId(subElement.getAsInt());
            }

            subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                addressInfo.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("AddressLine1");
            if (!subElement.isJsonNull()) {
                addressInfo.setAddressLine1(subElement.getAsString());
            }

            subElement = jsonObject.get("AddressLine2");
            if (!subElement.isJsonNull()) {
                addressInfo.setAddressLine2(subElement.getAsString());
            }

            subElement = jsonObject.get("Town");
            if (!subElement.isJsonNull()) {
                addressInfo.setTown(subElement.getAsString());
            }

            subElement = jsonObject.get("StateOrProvince");
            if (!subElement.isJsonNull()) {
                addressInfo.setStateOrProvince(subElement.getAsString());
            }

            subElement = jsonObject.get("Postcode");
            if (!subElement.isJsonNull()) {
                addressInfo.setPostcode(subElement.getAsString());
            }

            subElement = jsonObject.get("Country");
            if (!subElement.isJsonNull()) {
                addressInfo.setCountry(parseAsCountry(subElement));
            }

            subElement = jsonObject.get("Latitude");
            if (!subElement.isJsonNull()) {
                addressInfo.setLatitude(subElement.getAsDouble());
            }

            subElement = jsonObject.get("Longitude");
            if (!subElement.isJsonNull()) {
                addressInfo.setLongitude(subElement.getAsDouble());
            }

            subElement = jsonObject.get("ContactTelephone1");
            if (!subElement.isJsonNull()) {
                addressInfo.setContactTelephone1(subElement.getAsString());
            }

            subElement = jsonObject.get("ContactTelephone2");
            if (!subElement.isJsonNull()) {
                addressInfo.setContactTelephone2(subElement.getAsString());
            }

            subElement = jsonObject.get("ContactEmail");
            if (!subElement.isJsonNull()) {
                addressInfo.setContactEmail(subElement.getAsString());
            }

            subElement = jsonObject.get("AccessComments");
            if (!subElement.isJsonNull()) {
                addressInfo.setAccessComments(subElement.getAsString());
            }

            subElement = jsonObject.get("RelatedURL");
            if (!subElement.isJsonNull()) {
                addressInfo.setRelatedURL(subElement.getAsString());
            }

            return addressInfo;
        }

        private Country parseAsCountry(JsonElement jsonElement) {

            JsonObject jsonObject = jsonElement.getAsJsonObject();
            int id =-1;
            JsonElement subElement = jsonObject.get("ID");
            if (!subElement.isJsonNull()) {
                id= subElement.getAsInt();
            }

            final int idFinal = id;

            if(countries.stream().anyMatch(c -> c.getId() == idFinal)) {
                return countries.stream().filter(c -> c.getId() == idFinal).findFirst().get();
            }

            Country country = new Country();
            country.setId(idFinal);

            subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                country.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("ContinentCode");
            if (!subElement.isJsonNull()) {
                country.setContinentCode(subElement.getAsString());
            }

            subElement = jsonObject.get("ISOCode");
            if (!subElement.isJsonNull()) {
                country.setIsoCode(subElement.getAsString());
            }
            countries.add(country);
            return country;
        }

        private UsageType parseAsUsageType(JsonElement jsonElement) {
            UsageType usageType = new UsageType();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                usageType.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("IsPayAtLocation");
            if (!subElement.isJsonNull()) {
                usageType.setPayAtLocation(subElement.getAsBoolean());
            }

            subElement = jsonObject.get("IsMembershipRequired");
            if (!subElement.isJsonNull()) {
                usageType.setMembershipRequired(subElement.getAsBoolean());
            }

            subElement = jsonObject.get("IsAccessKeyRequired");
            if (!subElement.isJsonNull()) {
                usageType.setAccessKeyRequired(subElement.getAsBoolean());
            }

            return usageType;
        }

        private StatusType parseAsStatusType(JsonElement jsonElement) {
            StatusType statusType = new StatusType();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                statusType.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("IsOperational");
            if (!subElement.isJsonNull()) {
                statusType.setOperational(subElement.getAsBoolean());
            }

            subElement = jsonObject.get("IsUserSelectable");
            if (!subElement.isJsonNull()) {
                statusType.setUserSelectable(subElement.getAsBoolean());
            }

            return statusType;
        }

        private Date parseDate(String input) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            Date date = null;
            try {
                date = format.parse(input);
            } catch (ParseException e) {
                e.printStackTrace(); //Usunąć jak poznamy loggery
                return null;
            }

            return date;
        }

        private Connection parseAsConnection(JsonElement jsonElement) {
            Connection connection = new Connection();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Comments");
            if (!subElement.isJsonNull()) {
                connection.setComments(subElement.getAsString());
            }

            subElement = jsonObject.get("ConnectionType");
            if (!subElement.isJsonNull()) {
                connection.setConnectionType(parseAsConnectionType(subElement));
            }

            subElement = jsonObject.get("StatusType");
            if (!subElement.isJsonNull()) {
                connection.setStatusType(parseAsStatusType(subElement));
            }

            subElement = jsonObject.get("Level");
            if (!subElement.isJsonNull()) {
                connection.setLevel(parseAsLevel(subElement));
            }

            subElement = jsonObject.get("Amps");
            if (!subElement.isJsonNull()) {
                connection.setAmps(subElement.getAsDouble());
            }

            subElement = jsonObject.get("Voltage");
            if (!subElement.isJsonNull()) {
                connection.setVoltage(subElement.getAsDouble());
            }

            subElement = jsonObject.get("PowerKW");
            if (!subElement.isJsonNull()) {
                connection.setPowerKW(subElement.getAsDouble());
            }

            subElement = jsonObject.get("CurrentType");
            if (!subElement.isJsonNull()) {
                connection.setCurrentType(parseAsCurrentType(subElement));
            }

            subElement = jsonObject.get("Quantity");
            if (!subElement.isJsonNull()) {
                connection.setQuantity(subElement.getAsInt());
            }

            subElement = jsonObject.get("Comments");
            if (!subElement.isJsonNull()) {
                connection.setComments(subElement.getAsString());
            }

            return connection;
        }

        private ConnectionType parseAsConnectionType(JsonElement jsonElement) {
            ConnectionType connectionType = new ConnectionType();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                connectionType.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("FormalName");
            if (!subElement.isJsonNull()) {
                connectionType.setFormalName(subElement.getAsString());
            }


            subElement = jsonObject.get("IsDiscontinued");
            if (!subElement.isJsonNull()) {
                connectionType.setDiscontinued(subElement.getAsBoolean());
            }

            subElement = jsonObject.get("IsObsolete");
            if (!subElement.isJsonNull()) {
                connectionType.setObsolete(subElement.getAsBoolean());
            }

            return connectionType;
        }

        private Level parseAsLevel(JsonElement jsonElement) {
            Level level = new Level();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull())
                level.setTitle(subElement.getAsString());

            subElement = jsonObject.get("Comments");
            if (!subElement.isJsonNull())
                level.setComments(subElement.getAsString());


            subElement = jsonObject.get("IsFastChargeCapable");
            if (!subElement.isJsonNull())
                level.setFastChargeCapable(subElement.getAsBoolean());

            return level;
        }

        private CurrentType parseAsCurrentType(JsonElement jsonElement) {
            CurrentType currentType = new CurrentType();
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonElement subElement = jsonObject.get("Title");
            if (!subElement.isJsonNull()) {
                currentType.setTitle(subElement.getAsString());
            }

            subElement = jsonObject.get("Description");
            if (!subElement.isJsonNull()) {
                currentType.setDescription(subElement.getAsString());
            }

            return currentType;
        }
    }
}
