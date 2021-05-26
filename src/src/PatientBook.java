import java.io.*;
import java.util.*;

public class PatientBook {
    final static  String inputFilePath = "src/src/patient.txt";
    HashMap<String, String> patient = new HashMap<String, String>();
    File inputFile = new File(inputFilePath);
    BufferedWriter bf = null;
    BufferedReader bfReader = null;

    public void load() {
        try {
            bfReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bfReader.readLine()) != null) {
                String[] parts = line.split(",");
                patient.put(parts[0], parts[1]);
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

    public void save(String phone, String name) {
        if (phone != "") {
            FileWriter fw = null;
            try {
                fw = new FileWriter(inputFile, true);
                bf = new BufferedWriter(fw);
                bf.write(phone + "," + name + "\n");
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
        System.out.println("Pacientes:");
        for (String i : patient.keySet()) {
            System.out.println("Paciente " + patient.get(i) + " celular: " + i);
        }
    }

    public String check(String phone){
        if (patient.containsKey(phone)) {
            String name = patient.get(phone);
            return name;
        } else {
            System.out.println("No se encontró al paciente");
            return "0";
        }
    }
}