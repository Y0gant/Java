import java.util.Random;
import java.util.Scanner;
public class RockPaperScissor {
public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);
for (int i=0;i<=4;i++)
{ 
    System.out.println("Rock-1 Paper-2 Scissor-3");
    System.out.println("Enter your input: ");
   byte UI = Sc.nextByte();
   int max=3 , min=1;
   Random rand = new Random();
   int ra = rand.nextInt(max - min + 1) + min;

           if (UI == ra){
          System.out.println("TIE");
          }
                  else {
                         switch (UI) {
                           case 1 -> {
                        if(ra==2){
                            System.out.println("Rock vs Paper" );
                          System.out.println("you loose");
                      }
                      else {if (ra==3){
                        System.out.println("Rock vs Scissor");
                        System.out.println("you win");
                      }      
                      }
                    }
                      case 2 -> {
                        if(ra==1){
                            System.out.println("Paper vs Rock" );
                          System.out.println("you win");
                      }
                      else if (ra==3){
                        System.out.println("paper vs scissor");
                        System.out.println("you loose");
                      }       

                      }

                      case 3 ->{
                        if(ra==1){
                            System.out.println("Scissor vs Rock" );
                          System.out.println("you loose ");
                      }
                      else if (ra==2){
                        System.out.println("scissor vs paper");
                        System.out.println("you win");
                      }       
                      }
                    
    default -> System.out.println("Enter valid input(1-3)");
}
   
}

} 
    Sc.close();

}
}