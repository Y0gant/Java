package core.oops;

enum Status {
    Running,
    Failed,
    Pending,
    Sucess

}

public class Enums {
    public static void main(String[] args) {
        Status s = Status.Sucess;
        Status[] ss = Status.values();
        System.out.println(s);
        System.out.println(ss[1]);
        for (Status i : ss) {
            System.out.println(i + " : " + i.ordinal());
        }
    }
}
