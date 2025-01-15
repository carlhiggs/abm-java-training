package uk.cam.mrc.phm.homework.lectures.week12.io.tripReportTaskSolution;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TripReportReaderWriter {

    private Map<Integer, Trip> tripMap = new HashMap<>();
    private Map<Integer, Trip> tripMapAfterFilter = new HashMap<>();

    public void readData(String s) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(s));
            String newline;

            //read header
            String[] str = reader.readLine().split(",");
            int indexOriginX = findIndexInArray("origin_x",str);
            int indexOriginY = findIndexInArray("origin_y",str);
            int indexDestinationX = findIndexInArray("destination_x",str);
            int indexDestinationY = findIndexInArray("destination_y",str);
            int indexDepartureTime = findIndexInArray("departure_time",str);
            int indexTravelTime = findIndexInArray("travel_time",str);

            //read body
            int count = 1;
            while((newline = reader.readLine()) != null){
                String[] strArray = newline.split(",");
                Trip trip = new Trip(count);

                trip.setOriginX(Double.parseDouble(strArray[indexOriginX]));
                trip.setOriginY(Double.parseDouble(strArray[indexOriginY]));
                trip.setDestinationX(Double.parseDouble(strArray[indexDestinationX]));
                trip.setDestinationY(Double.parseDouble(strArray[indexDestinationY]));
                trip.setDepartureTime(Double.parseDouble(strArray[indexDepartureTime]));
                trip.setTravelTime(Double.parseDouble(strArray[indexTravelTime]));

                tripMap.put(count,trip);
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Wrong path: " + s);
        } catch (IOException e) {
            System.out.println("IOExceprion. Please check input file: " + s);
        }

    }

    public void processTrips() {
        for (Trip trip : tripMap.values()){
            //convert travel time to min, round to two integer
            trip.setTravelTimeInMin(Math.round(trip.getTravelTime()/60*100d) / 100d);

            //convert departure time
            int hour = (int) (trip.getDepartureTime()/3600);
            int min = (int) (trip.getDepartureTime()/60%60);
            String hourStr = String.valueOf(hour);
            String minStr = String.valueOf(min);

            if(hour < 10){
                hourStr = "0" + hourStr;
            }

            if(min < 10){
                minStr = "0" + minStr;
            }

            trip.setDepartureTimeHHMM(hourStr + ":" + minStr);

            //calculate distance and speed
            double distance = calculateDistance(trip.getOriginX(),trip.getDestinationX(),trip.getOriginY(),trip.getDestinationY());
            trip.setDistance(distance/1000.);
            trip.setSpeed(distance/1000./(trip.getTravelTime()/3600.));

            //trip filter under 500 meters
            if(distance >= 500) {
                tripMapAfterFilter.put(trip.getId(),trip);
            }
        }
    }

    public void writeOutData(String filePath) {
        PrintWriter writer;

        try {

            writer = new PrintWriter(filePath);

            writer.print("origin_x");
            writer.print(",");
            writer.print("origin_y");
            writer.print(",");
            writer.print("destination_x");
            writer.print(",");
            writer.print("destination_y");
            writer.print(",");
            writer.print("departure_time");
            writer.print(",");
            writer.print("travel_time");
            writer.print(",");
            writer.print("travel_time_min");
            writer.print(",");
            writer.print("departure_time_HHMM");
            writer.print(",");
            writer.print("distance_km");
            writer.print(",");
            writer.println("speed_kmh");

            for(Trip trip : tripMapAfterFilter.values()){
                writer.print(trip.getOriginX());
                writer.print(",");
                writer.print(trip.getOriginY());
                writer.print(",");
                writer.print(trip.getDestinationX());
                writer.print(",");
                writer.print(trip.getDestinationY());
                writer.print(",");
                writer.print(trip.getDepartureTime());
                writer.print(",");
                writer.print(trip.getTravelTime());
                writer.print(",");
                writer.print(trip.getTravelTimeInMin());
                writer.print(",");
                writer.print(trip.getDepartureTimeHHMM());
                writer.print(",");
                writer.print(Math.round(trip.getDistance()*100d) / 100d);
                writer.print(",");
                writer.println(Math.round(trip.getSpeed()*100d) / 100d);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wrong path!");
        }
    }

    private double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    private int findIndexInArray(String colname, String[] str) {
        int position = -1;
        for (int a =0; a<str.length;a++){
            if(str[a].equalsIgnoreCase(colname)){
                position = a;
            }
        }

        if (position == -1){
            throw new RuntimeException("Could not find column called: " + colname);
        }
        return position;
    }

}
