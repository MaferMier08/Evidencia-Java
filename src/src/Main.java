import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        AdminBook adminBook = new AdminBook();
        DoctorBook doctorBook = new DoctorBook();
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

        System.out.println("Agregar a un doctor");
        Scanner scannerD = new Scanner(System.in);
        System.out.println("Ingrese nombre del doctor");
        String doctor = scannerD.nextLine();
        Scanner scannerS = new Scanner(System.in);
        System.out.println("Ingrese especialidad de "+doctor);
        String specialty = scannerS.nextLine();
        // doctorBook.create(specialty, doctor);
        doctorBook.save(doctor,specialty);
        doctorBook.load();
        doctorBook.list();
    }
}