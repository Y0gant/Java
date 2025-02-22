package core.java_io;

import java.io.*;
import java.util.Scanner;

public class FileInputExample {
    public static void main(String[] args) {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter your name :");
            String str = buffReader.readLine();
            System.out.println("Heyy " + str);

            //explicit parsing for numeric input
            int num = Integer.parseInt(buffReader.readLine());
            System.out.println(num * 2);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number format");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Incorrect input ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error !!!");
        }

        try (Scanner scn = new Scanner(System.in)) {

            System.out.println("Byte :" + Byte.MAX_VALUE);
            byte byt = scn.nextByte();
            System.out.println("Integer :" + Integer.MAX_VALUE);
            int num2 = scn.nextInt();
            System.out.println("Double :" + Double.MAX_VALUE);
            double dob = scn.nextDouble();
            System.out.println("Float :" + Float.MAX_VALUE);
            float flt = scn.nextFloat();
            System.out.println("Short :" + Short.MAX_VALUE);
            short srt = scn.nextShort();
            System.out.println("Long :" + Long.MAX_VALUE);
            long lng = scn.nextLong();

            System.out.println("Numeric values :");
            System.out.println("Integer :" + num2 + "\n Byte :" + byt + "\n Double :" + dob + "\n Float :" + flt + "\n Long :" + lng + "\n Short :" + srt);
        } catch (Exception e) {
            System.out.println("Error !!!");
        }

        //System.console() does not work in most IDEs. Use a terminal or command prompt.
        Console csn = System.console();
        if (csn != null) {
            System.out.println("Enter your password :(Console)");
            char[] pass = csn.readPassword();
            String password = new String(pass);
            System.out.println(password);
        } else System.out.println("Console not available");

        //Useful for competitive programming and scripts.
        if (args != null) {
            System.out.println("Command line arguments are :");

            for (String arg : args) {
                System.out.println(arg);
            }
        }

        DataInputStream dis = new DataInputStream(System.in);
        try {
            System.out.print("Enter an integer: ");
            int num = 0;
            num = Integer.parseInt(dis.readUTF());
            System.out.print("Enter a string: ");
            String str = dis.readUTF();
            System.out.println("You entered integer: " + num);
            System.out.println("You entered string: " + str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}