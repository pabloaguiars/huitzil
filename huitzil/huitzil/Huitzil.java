package huitzil;

//import file stream reader and exceptions
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import dependencies from parser/ directory
import parser.Parser;
import parser.Token;
import parser.ParserConstants;
//list
import java.util.ArrayList;
import java.util.List;

public class Huitzil {
    public static void main(String[] args) {
        try {
            // file with huitzil code
            File file = new File("test.txt");

            // open stream
            Parser p = new Parser(new FileInputStream(file));
            p.g_program();
        } catch (Exception exception) {
            // If something went wrong... print the exception
            System.out.println("\n\nSomething went wrong: ");
            System.out.println(exception.getMessage());
        }
    }
}