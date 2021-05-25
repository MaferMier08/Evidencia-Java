import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        AdminBook adminBook = new AdminBook();
        DoctorBook doctorBook = new DoctorBook();
        PatientBook patientBook = new PatientBook();
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
        System.out.println("Hola Admin, Qué desea hacer?");
        Integer menu = 0;
        do{
            Scanner scannerMenu = new Scanner(System.in);
            System.out.println("1. Agregar a un doctor");
            System.out.println("2. Ver lista de doctores");
            System.out.println("3. Agregar un paciente");
            System.out.println("4. Ver lista de pacientes");
            System.out.println("0. Cerrar sesión");
            menu = scannerMenu.nextInt();
            switch (menu){
                case 1:
                    Scanner scannerD = new Scanner(System.in);
                    System.out.println("Ingrese nombre del doctor");
                    String doctor = scannerD.nextLine();
                    Scanner scannerS = new Scanner(System.in);
                    System.out.println("Ingrese especialidad de "+doctor);
                    String specialty = scannerS.nextLine();
                    doctorBook.save(doctor,specialty);
                    doctorBook.load();
                    break;
                case 2:
                    doctorBook.load();
                    doctorBook.list();
                    break;
                case 3:
                    Scanner scannerPN = new Scanner(System.in);
                    System.out.println("Ingrese nombre del paciente");
                    String patient = scannerPN.nextLine();
                    Scanner scannerPP = new Scanner(System.in);
                    System.out.println("Ingrese el celular de "+patient);
                    String phone = scannerPP.nextLine();
                    patientBook.save(phone,patient);
                    patientBook.load();
                    break;
                case 4:
                    patientBook.load();
                    patientBook.list();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Esa no es una opción, intentelo de nuevo");
                    break;
            }
        }while (menu != 0);

    }
}