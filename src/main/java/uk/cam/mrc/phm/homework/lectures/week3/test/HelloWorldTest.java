package uk.cam.mrc.phm.homework.lectures.week3.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.cam.mrc.phm.homework.lectures.week3.HelloWorldExample;


public class HelloWorldTest {
    @Test
    public void testReturnHelloWorld(){
        Assertions.assertEquals(
                "Hello World!",
                HelloWorldExample.printHello()
        );
    }
}
