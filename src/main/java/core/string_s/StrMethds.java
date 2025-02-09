package core.string_s;

public class StrMethds {
    public static void main(String[] args) {
        String name = "Sachin";
        System.out.println(name);
        //Get length of string
        int value = name.length();
        System.out.println(value);
        //Convert all character to lowercase
        System.out.println(name.toLowerCase());
        //Convert all character to uppercase
        System.out.println(name.toUpperCase());
        //Trim whitespaces from start and end
        String toTrim = "  hello   ";
        System.out.println(toTrim.trim());
        //Get sub-string
        System.out.println(name.substring(2));
        System.out.println(name.substring(1, 5));
        //Replace characters
        System.out.println(name.replace("a", "ia"));
        //check if string start or end with some characters
        System.out.println(name.startsWith("sa"));//false cause case-sensitive
        System.out.println(name.endsWith("in"));
        //return character at given index
        System.out.println(name.charAt(2));
        // return index of character
        String str = "aabbccdd";
        System.out.println(str.indexOf("a"));
        System.out.println(str.lastIndexOf("c"));
        //check equality operation for string
        System.out.println(name.equals("sachin"));
        System.out.println(name.equalsIgnoreCase("sAcHin"));

        //escape sequence character examples

        System.out.println("this is \"example\" of \nescape\tsequence  \bcharacters'\\");
    }
}

