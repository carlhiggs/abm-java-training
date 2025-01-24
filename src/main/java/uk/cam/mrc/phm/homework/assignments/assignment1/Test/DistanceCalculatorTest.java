package uk.cam.mrc.phm.homework.assignments.assignment1.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.cam.mrc.phm.homework.assignments.assignment1.DistanceCalculatorImproved;


public class DistanceCalculatorTest {
    @Test
    public void testDistanceCalculator(){
        DistanceCalculatorImproved.Coordinate a = new DistanceCalculatorImproved.Coordinate((double) 0,(double) 3);
        DistanceCalculatorImproved.Coordinate b = new DistanceCalculatorImproved.Coordinate((double) 4,(double) 0);
        Assertions.assertEquals(
                5,
                DistanceCalculatorImproved.calculateDistance(a,b)
        );
    }
}
