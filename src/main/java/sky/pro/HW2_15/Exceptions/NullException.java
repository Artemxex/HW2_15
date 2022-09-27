package sky.pro.HW2_15.Exceptions;

public class NullException extends RuntimeException {
    public NullException(String s){
        System.out.println(s);
    }
}