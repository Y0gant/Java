package src.string_s;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StrBuilderAndBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World"); // Modifies the original string
        System.out.println(sb); // Output: Hello World

        StringBuilder sb2 = new StringBuilder("Java");
        sb2.append(" Programming"); // Modifies the original string
        System.out.println(sb2); // Output: Hello Java


        StringTokenizer st = new StringTokenizer("Java is fun", " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        StringJoiner sj = new StringJoiner(" ", "[", "]");
        sj.add("Hello");
        sj.add("there");
        sj.add("how");
        sj.add("you");
        sj.add("doinn\'");
        System.out.println(sj);
    }
}
