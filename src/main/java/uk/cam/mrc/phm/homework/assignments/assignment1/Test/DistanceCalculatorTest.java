package uk.cam.mrc.phm.homework.assignments.assignment1.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.cam.mrc.phm.homework.assignments.assignment1.DistanceCalculatorImproved;


public class DistanceCalculatorTest {
    @Test
    public void testDistanceCalculator(){
        DistanceCalculatorImproved.Coordinates a = new DistanceCalculatorImproved.Coordinates((double) 0,(double) 3);
        DistanceCalculatorImproved.Coordinates b = new DistanceCalculatorImproved.Coordinates((double) 4,(double) 0);
        Assertions.assertEquals(
                5,
                DistanceCalculatorImproved.calculateDistance(a,b)
        );
    }
}
