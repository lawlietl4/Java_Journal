package file.io;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Write {
    public static void writeFile() {
        String brString;
        BufferedReader br;
        try {
            LocalDate date = LocalDate.now();
            br = new BufferedReader(new InputStreamReader(System.in));
            String entryString = br.readLine();
            System.out.println("What to write to the file?: \n");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            File createDir = new File(System.getProperty("user.home") + "\\Documents\\" + dtf.format(date) + "\\");
            boolean dirMade = createDir.mkdir();
            FileWriter writer = new FileWriter(createDir + "\\" + entryString + ".txt");
            brString = br.readLine();
            if (dirMade) {
                System.out.println("File directory created successfully");
            }
            writer.write(brString);
            writer.append("\n\n\nWritten by Nick Roberson 2020\n\n");
            writer.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("The file could not be found");
        } catch (IOException ioe) {
            System.out.println("There has been a major error, please kill process");
        }
    }

}
