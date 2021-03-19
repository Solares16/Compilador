package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Resta extends Operacion {

    public Resta(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {
        /**
        tipos de datos 
        
        numerico
        caracter
        booleano       

        
        numerico    caracter    double    caracter se convierte a su forma ascii 
        caracter    numerico    double
        
        numerico    numerico    double    
        caracter    caracter    double
        booleano    booleano    double

        numerico    booleano    double      booleano se convierte a su forma ascii
        booleano    numerico    double      

        booleano    caracter    double
        caracter    booleano    double

         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
