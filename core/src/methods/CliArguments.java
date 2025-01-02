package src.methods;

/**
 * Example of command line arguments
 * printing the first index of cli arguments
 * using for loop to traverse cli arguments and print them
 * */

public class CliArguments {
    public static void main(String[] args) {
        System.out.println(args[0]);
        if (args.length>0) {
            for (String val : args)
                System.out.println(val);
        }
        else {
            System.out.println("Command line args empty");
        }

    }
}
