package Pck_Main;

import AST.Expresion.Expresion;
import Analyzer.Parser;
import Analyzer.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.LinkedList;


/**
 *
 * @author Solares
 */
public class Ejecutar {  
            
        public void Parsear(String PATH) {

        try {
            Parser Parser;
            //Parsear la Entrada 
            Parser = new Parser(new Scanner(new StringReader(LeerArchivo(PATH))));            
            Parser.parse();
            
            LinkedList<Expresion> Root = (LinkedList<Expresion>)Parser.GetAST();            
            System.out.println("Root recuperado en ejecutar");
                //System.out.println(Root.Ejecutar());
            

        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Error: " + e.getMessage() + " -> " + e.getLocalizedMessage());
        }

    }
    
    private String LeerArchivo(String Path) {
        String cadena;                                //se utiliza para leer el archivo seleccionado 
        String texto = "";                            //concatena todas las lineas del archivo que se leerà    
        try {                                         // LECTURA DEL ARCHIVO SELECCIONADO
            FileReader f = new FileReader(Path);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                texto = texto.concat(cadena);
                texto = texto.concat("\n");
            }
            b.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return texto;
    }
    
    
}
