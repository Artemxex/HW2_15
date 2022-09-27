package sky.pro.HW2_15;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.HW2_15.Exceptions.NullException;

import  static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertThrows;

public class HomeworkTest {
    Homework h = new Homework(10);
    int[]ar=new int[]{2,5,3,4,1,9,6,7,8,10};






    @Test
    public void add() {
        Integer expected = 5;
        Integer actual = h.add(5);
        assertEquals(expected,actual);

    }

    @Test
    public void contains() {
        boolean expected = true;
        boolean actual = h.contains(ar,9);
        assertEquals(expected,actual);
    }


public static Homework paramsForTests() {
    Homework h = new Homework(10);
    h.rndFill();
    int i = 5;
    return h;
}
}

