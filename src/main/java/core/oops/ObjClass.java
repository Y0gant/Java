package core.oops;

/**
 * This program contains use of toString(),
 * hashcode(),equals(Object obj),getClass()
 * & clone() method of object class.
 */
public class ObjClass implements Cloneable {
    String n;
    int r;

    ObjClass(int r) {
        this.r = r;
    }

    ObjClass(String n) {
        this.n = n;

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjClass obj1 = new ObjClass("Jon Snow");
        ObjClass obj2 = new ObjClass(1);
        ObjClass obj3 = new ObjClass(1);
        ObjClass obj4 = (ObjClass) obj3.clone();
        System.out.println(obj1);
        System.out.println(obj1.hashCode());
        System.out.println(obj2.equals(obj3));
        //getClass().getName() method (only class name)
        System.out.println(obj1.getClass().getName());
        // getClass() method ( class + class name)
        System.out.println(obj2.getClass());
        System.out.println("Cloned Object ID: " + obj1.n);

    }

    //clone() method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //toString() method
    @Override
    public String toString() {
        return "Name of Character :{" + n + "}";
    }

    //equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ObjClass objt = (ObjClass) obj;
        return r == objt.r;
    }
}

