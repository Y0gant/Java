package core.ExceptionH;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    public void show() throws IOException {
        throw new IOException("IOException in Parent class");
    }
}

class Child extends Parent {
    @Override
    public void show() throws FileNotFoundException {
        throw new FileNotFoundException("FileNotFoundException in Child class");
    }
}

public class ExceptionHandlingOverriding {
    public static void main(String[] args) {
        Parent obj = new Child();

        try {
            obj.show();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        Parent obj2 = new Parent();

        try {
            obj2.show();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
