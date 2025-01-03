package src.array;

public class ArrayOfObject {
    int roll_no;
    String name;

    void Student1(int roll_no, String name){
     this.name=name;
     this.roll_no=roll_no;
    }

    public static void main(String[] args) {
        ArrayOfObject[] obj1 = new ArrayOfObject[5];
        obj1[0].Student1(11,"Rahul");
        obj1[1].Student1(12,"Aditya");
        obj1[2].Student1(13,"Dhruv");
        obj1[3].Student1(14,"Abhishek");
        obj1[4].Student1(15,"Yash");

        for (int i=0;i<5;i++)
            System.out.println("Student "+(i+1)+"Roll no.:"+ obj1[i].roll_no+" name: "+obj1[i].name);
    }
}
