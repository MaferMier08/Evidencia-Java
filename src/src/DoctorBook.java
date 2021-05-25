import java.io.*;
import java.util.*;

public class DoctorBook {
    final static  String inputFilePath = "src/src/doctor.txt";
    HashMap<String, String> doctor = new HashMap<String, String>();
    File inputFile = new File(inputFilePath);
    BufferedWriter bf = null;
    BufferedReader bfReader = null;

    public void load() {
        try {
            bfReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bfReader.readLine()) != null) {
                String[] parts = line.split(",");
                doctor.put(parts[0], parts[1]);
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

    public void save(String doctor, String speciality) {
        if (doctor != "") {
            FileWriter fw = null;
            try {
                fw = new FileWriter(inputFile, true);
                bf = new BufferedWriter(fw);
                bf.write(doctor + "," + speciality + "\n");
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
        }else{}
    }

    public void list(){
        System.out.println("Doctores:");
        for (String i : doctor.keySet()) {
            System.out.println("Doctor " + i + " especialidad: " + doctor.get(i));
        }
    }


    public String check(String name){
        if (doctor.containsKey(name)) {
            String specialty = doctor.get(name);
            return specialty;
        } else {
            System.out.println("No se encontró al doctor");
            return "0";
        }
    }


}