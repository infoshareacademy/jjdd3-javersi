public class Data {

    public void dataIn(){

    }

    public void findChargingStationAtTown(){


    }

    public void findClosestChargingStation(double szerokosc,double długość, String id){
        int k=0;
        double latitude;
        double longtitude;
        String pointid;
        double closest = latitude[0]*latitude[0]+longtitude[0]*longtitude[0];
        for(int i=0; i<szerokosc.length; i++) {
            distance=szerokosc*szerokosc+długość*długość;
            if (distance<closest){
               closest=distance;
                pointid=id;
            }
        }

    }

    public void findChargingStationAtArea(double szerokosc,double długość, String id, double radius){
        int k=0;
        double[] latitude;
        double[] longtitude;
        String[] pointid;
        for(int i=0; i<szerokosc.length; i++) {
            distance=szerokosc*szerokosc+długość*długość;
            if (distance<radius*radius){

                k++;
                latitude[k]=szerokość;
                longtitude[k]=długość;
                pointid[k]=id;
            }
        }

    }


}
