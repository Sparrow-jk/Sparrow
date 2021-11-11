import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Test {


    public static void main(String[] args) {
        String a;
        a = Integer.valueOf(20) + (Byte.valueOf((byte) 2).equals(Byte.valueOf((byte) 2)) ? "月" : "岁");
        System.out.println(a);
    }
}
