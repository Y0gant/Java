package src.OOPS;

/**
 * This program contains use of toString()
<<<<<<< HEAD
 * & hashcode() method of
 * .
=======
 * & hashcode() method of object class.
>>>>>>> 2f576c7eb2365f88a077123069b9b4484724035a
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
