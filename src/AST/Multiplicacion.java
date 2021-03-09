
package AST;

/**
 *
 * @author Solares
 */
public class Multiplicacion extends Aritmetica{

    public Multiplicacion(Expresion Op1, Expresion Op2) {
        this.Op1=Op1;
        this.Op2=Op2;
    }

    @Override
    public Object Ejecutar() {
        return (double)Op1.Ejecutar() * (double)Op2.Ejecutar();
    }
    
}
