package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Suma extends Operacion {

    public Suma(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {

        /*
        Nota:  si tuvieramos diferentes tipos de datos, aqui se hacen las combinaciones 
                
        ENTERO - ENTERO 
        ENTERO - DECIMAL 
        DECIMAL - ENTERO
        DECIMAL - DECIMAL 
        .
        .
        etc
        Por cada tipo de dato que tengamos tendremos 2^(numero de tipos de dato) combinaciones 
                
         */
        //return (double) Op1.Ejecutar() + (double) Op2.Ejecutar();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
}
