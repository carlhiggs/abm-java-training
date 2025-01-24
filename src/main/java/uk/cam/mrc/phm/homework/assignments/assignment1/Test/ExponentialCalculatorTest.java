package uk.cam.mrc.phm.homework.assignments.assignment1.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.cam.mrc.phm.homework.assignments.assignment1.ExponentialCalculator;


public class ExponentialCalculatorTest {
    // The test appears to pass for x in [1,9], with n>42
    // If x==1, then it passes with n=17, however further expansion
    // is required with increasing x.
    @Test
    public void testExponentialCalculator(){
        int x = 9;
        int n = 43;
        Assertions.assertEquals(
                Math.exp(x),
                ExponentialCalculator.calculateExp(x,n)
        );
    }
}
