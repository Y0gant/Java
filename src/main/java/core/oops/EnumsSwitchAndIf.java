package core.oops;

enum Status2 {
    Running,
    Failed,
    Pending,
    Sucess

}

public class EnumsSwitchAndIf {


    public static void main(String[] args) {
        Status2 s = Status2.Running;

        switch (s) {
            case Running:
                System.out.println("All Good");
                break;

            case Failed:
                System.out.println("Try Again");
                break;

            case Pending:
                System.out.println("Please Wait");
                break;

            default:
                System.out.println("Done");
                break;
        }

        if (s == Status2.Running)
            System.out.println("All Good");
        else if (s == Status2.Failed)
            System.out.println("Try Again");
        else if (s == Status2.Pending)
            System.out.println("Please Wait");
        else
            System.out.println("Done");
    }
}
