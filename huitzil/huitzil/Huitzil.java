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
            File file = new File(args[0]);

            // instance parse and pass file stream
            Parser p = new Parser(new FileInputStream(file));

            // start parser
            p.g_program();

            System.out.println("\nParser successfully");
            System.out.print("\nSymbols table: ");
            // print symbol table
            System.out.println(Parser.table);


            // // symbol table
            // ArrayList<String> symbolTable = new ArrayList<String>();
            // // get token
            // Token token = Parser.getNextToken();
            // // get token's kind
            // String kind = ParserConstants.tokenImage[token.kind];
            // // get input huitzil code
            // String image = token.image;
            // // while the token is not EOF [End Of File]...
            // while (token.kind != ParserConstants.EOF) {
            //     // if token is a var name, it could be added to the symbol table
            //     if (token.kind == ParserConstants.t_object_name) {
            //         // if the symbol is not in the symbol table, add it
            //         if (!symbolTable.contains(image)) {
            //             // add to the symbol table
            //             symbolTable.add(image);
            //         }
            //         // print token's kind and index in the symbol table
            //         System.out.println(String.format("%s %d", kind, symbolTable.indexOf(image)));
            //     } else {
            //         // print the token's kind and input huitzil code
            //         System.out.println(String.format("%s %s", kind, image));
            //     }
            //     // get the next token
            //     token = Parser.getNextToken();
            //     // get token's kind
            //     kind = ParserConstants.tokenImage[token.kind];
            //     // get input huitzil code
            //     image = token.image;
            // }

            // // [optinal]
            // // print symbol table
            // int i = symbolTable.size() - 1;
            // System.out.print(String.format("\n\nSymbol Table; Items: %d\n", symbolTable.size()));
            // for (int c = 0; c <= i; c++) {
            //     System.out.println(String.format("%d %s", c, symbolTable.get(c)));
            // }
        } catch (IOException exception) {
            //can't read the file
	        System.out.println("\nCan't read the file");
        } catch (Exception exception) {
            // if something went wrong... print the exception
            System.out.println("\nCan't parse the file. Something went wrong: ");
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        } 
    }
}