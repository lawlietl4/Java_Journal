package file.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class readFile {
    public static String read() {
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            LocalDate date = LocalDate.now();
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            String naming = br.readLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Path p1 = Paths.get(System.getProperty("user.home"), "\\Documents\\" + dtf.format(date) + "\\");
            File searchFile = new File(p1.toString());
            FileReader fr = new FileReader(searchFile + "\\" + naming + ".txt");
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            fr.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("I could not find the file specified");
        } catch (IOException ioe) {
            System.out.println("Problem occurred, please kill process");
        }
        return sb.toString();
    }
}
