package src.OOPS;

abstract class AnonymousAbst {
    abstract void abstractMethod();
}

public class NestedCls {

    static String str2 = "Static string variable accessed";
    final String STR3 = "Constant String variable accessed";
    private String str = "Private string variable accessed";

    public static void main(String[] args) {
        //Object of outer class
        NestedCls obj1 = new NestedCls();
        //Object of member inner class
        NestedCls.Inner obj2 = obj1.new Inner();
        //Object of StaticInner class
        NestedCls.StaticInner obj3 = new NestedCls.StaticInner();
        //Anonymous class Implementation
        AnonymousAbst obj5 = new AnonymousAbst() {
            @Override
            void abstractMethod() {
                System.out.println("Inside Anonymous class for implementing the abstract method");
            }
        };

        //Method Implementations
        obj1.showLocalInnerClass();
        obj2.showInner();
        obj3.showStaticInner();
        obj5.abstractMethod();


    }

    //Local Inner class
    void showLocalInnerClass() {
        class LocalClass {
            void localInnerMethod() {
                System.out.println("Inside Method localInnerMethod() of Member class " + getClass().getSimpleName());
                System.out.println(STR3);
            }
        }
        LocalClass obj4 = new LocalClass();
        obj4.localInnerMethod();
    }

    //Static Inner class
    static class StaticInner {
        void showStaticInner() {
            System.out.println("Inside Method showStaticInner() of static inner class " + getClass().getSimpleName());
            System.out.println(str2);
        }
    }

    //Member inner class
    class Inner {
        void showInner() {
            System.out.println("Inside Method showInner() of Member class " + NestedCls.this.getClass().getSimpleName());
            System.out.println(str);
        }
    }
}
