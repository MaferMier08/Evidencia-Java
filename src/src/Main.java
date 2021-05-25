
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        AdminBook adminBook = new AdminBook();
        Scanner scanner = new Scanner(System.in);
        String user="";
        String password="";
        int login = 0;
        adminBook.load();
        do {
            Scanner scannerU = new Scanner(System.in);
            System.out.println("Ingrese el nombre del usuario");
            user = scannerU.nextLine();
            Scanner scannerP = new Scanner(System.in);
            System.out.println("Ingrese la contraseña");
            password = scannerP.nextLine();
            if (adminBook.login(password) == 1) {
                login = 1;
            }
        }while (login != 1 );

    }
}
