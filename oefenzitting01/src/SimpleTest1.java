
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

/**
 * Testen voor de prikklok-API.
 */
public class SimpleTest1 {

    private static DrieSomProbleem dsp;


    @BeforeClass public static void init() {
        dsp = new MijnDrieSomProbleem();
    }

    @Test
    public void test1() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -5, 1, 2, 3, 7, 8
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        TripletIndices oplTriplet = new TripletIndices(0, 2, 3);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test2() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -16, -3, 2, 3, 5, 6, 7, 19
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        TripletIndices oplTriplet = new TripletIndices(0, 1, 7);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test3() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -16, -3, 2, 3, 5, 6, 7
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertEquals(null, antwTriplet);

    }


    @Test
    public void test4() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -9, -8, -3, -1, 2, 5, 7, 13, 18
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        TripletIndices oplTriplet = new TripletIndices(0, 4, 6);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test5() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -4, -4, -2, 3, 5, 8, 10
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        TripletIndices oplTriplet = new TripletIndices(0, 1, 5);
        Assert.assertEquals(oplTriplet, antwTriplet);

    }

    @Test
    public void test6() {

        //Er wordt verondersteld dat de invoer gesorteerd is!
        List<Integer> invoer = Arrays.asList(
                -4, -4, 3, 5, 9, 10
        );

        TripletIndices antwTriplet = dsp.zoekNulSomTriplet(Collections.unmodifiableList(invoer));

        Assert.assertEquals(null, antwTriplet);

    }

}