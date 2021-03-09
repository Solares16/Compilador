package AST;

/**
 *
 * @author Solares
 */
public class Suma  extends Aritmetica{
    
    public Suma(Expresion Op1, Expresion Op2) {
        this.Op1 = Op1;
        this.Op2 = Op2;
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
        
        return (double)Op1.Ejecutar() + (double)Op2.Ejecutar();
        
    }        
}
