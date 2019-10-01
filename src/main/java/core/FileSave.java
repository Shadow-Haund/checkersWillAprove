package core;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSave {
    void ReadFile (){

    }
    void WriteFile(){
        File file = new File("resources/CheckersSavePosition.txt");
        try {
            PrintWriter output = new PrintWriter(file);
            output.println("Mes");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
