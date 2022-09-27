package sky.pro.HW2_15.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s){
        System.out.println(s);
    }
}
