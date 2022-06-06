import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("abcdefghijklmnop");

        System.out.println(buffer.length());
        System.out.println(buffer.indexOf("z"));
        buffer.delete(5,buffer.length());
        System.out.println(buffer.toString());
    }

}
