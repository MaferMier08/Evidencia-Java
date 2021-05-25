import java.io.*;
import java.util.*;

public class AdminBook {
    final static  String inputFilePath = "src/src/admin.txt";
    HashMap<String, String> user = new HashMap<String, String>();
    File inputFile = new File(inputFilePath);
    BufferedWriter bf = null;
    BufferedReader bfReader = null;

    public void load() {
        try {
            bfReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = bfReader.readLine()) != null) {
                String[] parts = line.split(",");
                user.put(parts[0], parts[1]);
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

    public void save(String password, String user) {
        if (password != "") {
            FileWriter fw = null;
            try {
                fw = new FileWriter(inputFile, true);
                bf = new BufferedWriter(fw);
                bf.write(password + "," + user + "\n");
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
    public int login(String password){
        if (user.containsKey(password)) {
            System.out.println("Sesión iniciada");
            return 1;
        } else {
            System.out.println("Usuario incorrecto");
            return 0;
        }
    }

}
