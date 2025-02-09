package core.string_s;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StrBuilderAndBuffer {
    public static void main(String[] args) {
        System.out.println("Hello" + " World" // Modifies the original string
        ); // Output: Hello World

        System.out.println("Java" + " Programming" // Modifies the original string
        ); // Output: Hello Java


        StringTokenizer st = new StringTokenizer("Java is fun", " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringJoiner sj = new StringJoiner(" ", "[", "]");
        sj.add("Hello");
        sj.add("there");
        sj.add("how");
        sj.add("you");
        sj.add("doinn'");
        System.out.println(sj);
    }
}
