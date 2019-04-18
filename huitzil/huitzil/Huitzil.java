package huitzil;

//import file stream reader and exceptions
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import dependencies from lexical/ directory
import lexical.Lexical;
import lexical.Token;
import lexical.LexicalConstants;
//list
import java.util.ArrayList;
import java.util.List;

public class Huitzil {
    public static void main(String[] args) {
        try {
            // file with huitzil code
            File file = new File("test.txt");
            // symbol table
            ArrayList<String> symbolTable = new ArrayList<String>();
            // open stream
            Lexical lexical = new Lexical(new FileInputStream(file));
            // get token
            Token token = Lexical.getNextToken();
            // get token's kind
            String kind = LexicalConstants.tokenImage[token.kind];
            // get input huitzil code
            String image = token.image;
            // while the token is not EOF [End Of File]...
            while (token.kind != LexicalConstants.EOF) {
                // if token is a var name, it could be added to the symbol table
                if (token.kind == LexicalConstants.t_var_name) {
                    // if the symbol is not in the symbol table, add it
                    if (!symbolTable.contains(image)) {
                        // add to the symbol table
                        symbolTable.add(image);
                    }
                    // print token's kind and index in the symbol table
                    System.out.println(String.format("%s %d", kind, symbolTable.indexOf(image)));
                } else {
                    // print the token's kind and input huitzil code
                    System.out.println(String.format("%s %s", kind, image));
                }
                // get the next token
                token = Lexical.getNextToken();
                // get token's kind
                kind = LexicalConstants.tokenImage[token.kind];
                // get input huitzil code
                image = token.image;
            }

            // [optinal]
            // print symbol table
            int i = symbolTable.size() - 1;
            System.out.print(String.format("\n\nSymbol Table; Items: %d\n", symbolTable.size()));
            for (int c = 0; c <= i; c++) {
                System.out.println(String.format("%d %s", c, symbolTable.get(c)));
            }
        } catch (Exception exception) {
            // If something went wrong... print the exception
            System.out.println("\n\nSomething went wrong: ");
            System.out.println(exception.getMessage());
        }
    }
}