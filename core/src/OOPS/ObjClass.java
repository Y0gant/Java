package src.OOPS;

/**
 * This program contains use of toString()
 * & hashcode() method of
 * .
 */
public class ObjClass {
    String n;

    ObjClass(String n) {
        this.n = n;

    }

    public static void main(String[] args) {
        ObjClass obj1 = new ObjClass("John Snow");
        System.out.println(obj1);
        System.out.println(obj1.hashCode());
    }

    @Override
    public String toString() {
        return "Name of Character :{" + n + "}";
    }
}
