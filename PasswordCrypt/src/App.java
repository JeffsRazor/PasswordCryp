
import java.util.Scanner;

import org.mindrot.jbcrypt.*;


public class App {
    public static void main(String[] args) throws Exception {
       Boolean looped = true;
        do {
        System.out.println("Enter password to crypt: ");
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();
        System.out.println("Enter salt value: ");
        int salt = scan.nextInt();
        scan.nextLine(); //eats new line char
        String hashed = BCrypt.hashpw(pass, BCrypt.gensalt(salt)); //NOTE: increasing log_rounds will GREATLY slow down the speed of hashing 
        System.out.println("Enter your password again to verify: ");
        String check = scan.nextLine();
        if(BCrypt.checkpw(check, hashed)){
             System.out.println("Your hashed pass: " + hashed );
              looped= false;
              scan.close();
        }
        else {
            System.out.println("Error: hashed password does not match");
        }
    }while(looped);
    
    }
}