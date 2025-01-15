package uk.cam.mrc.phm.homework.lectures.week12.io.tripReportTaskSolution;

public class TripReportRunner {
    public static void main(String[] args) {
        TripReportReaderWriter tripReportReaderWriter = new TripReportReaderWriter();

        tripReportReaderWriter.readData("scenarios/homework/week12/trip_report.csv");
        tripReportReaderWriter.processTrips();
        tripReportReaderWriter.writeOutData("scenarios/homework/week12/trip_report_processed.csv");

    }
}
