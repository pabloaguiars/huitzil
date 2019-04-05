package program;

//import file stream reader and exceptions
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//Import dependencies from lexical/ directory
import lexical.Lexical;
import lexical.Token;
import lexical.LexicalConstants;

public class Program {
    public static void main(String[] args) {
        try {
            //file with huitzil code
            File file = new File("test.txt");
            //open stream
            Lexical lexical = new Lexical(new FileInputStream(file));
            //get token
            Token token = Lexical.getNextToken();
            //get token's kind
            String kind = LexicalConstants.tokenImage[token.kind];
            //get input huitzil code
            String image = token.image;
            //while It keeps finding tokens...
            while (token.kind != 0) {
                //print the token's kind and input huitzil code
                System.out.println(String.format("%s %s", kind, image));
                //get the next token
                token = Lexical.getNextToken();
                //get token's kind
                kind = LexicalConstants.tokenImage[token.kind];
                //get input huitzil code
                image = token.image;
            }
        } catch (Exception exception) {
            //If something went wrong... print the exception
            System.out.println("Something went wrong: ");
            System.out.println(exception.getMessage());
        }
    }
}