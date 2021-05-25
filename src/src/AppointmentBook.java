import java.io.*;
import java.util.*;

public class AppointmentBook {
    final static  String inputFilePath = "src/src/appointment.txt";
    HashMap<String, String> appointment = new HashMap<String, String>();
    File inputFile = new File(inputFilePath);
    BufferedWriter bf = null;
    BufferedReader bfReader = null;

    public void load() {
        try {
            bfReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bfReader.readLine()) != null) {
                String[] parts = line.split(",");
                appointment.put(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bfReader != null) {
                    bfReader.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int save(String date, String patient, String doctor, String specialty) {
        if (date != "") {
            FileWriter fw = null;
            try {
                fw = new FileWriter(inputFile, true);
                bf = new BufferedWriter(fw);
                bf.write(date + "," + patient + "," + doctor + "," + specialty + "\n");
                System.out.println("Cita confirmada ");
                System.out.println("Fecha: " + date);
                System.out.println("Paciente: " + patient);
                System.out.println("Doctor: " + doctor);
                System.out.println("Especialidad: " + specialty);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (bf != null) {
                        bf.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return 1;
        }else{
            System.out.println("Tiene que ingresar una fecha");
            return 0;
        }
    }

    public void list(){
        System.out.println("Pacientes:");
        for (String i : appointment.keySet()) {
            System.out.println("Paciente " + appointment.get(i) + " celular: " + i);
        }
    }
    public String check(String name){
        if (appointment.containsKey(name)) {
            System.out.println("Ya está ocupada esa fecha, por favor elija otra");
            return "0";
        } else {
            return "1";
        }
    }

}