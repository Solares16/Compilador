
package AST;

/**
 *
 * @author Solares
 */
public class Division extends  Aritmetica{

    public Division(Expresion Op1, Expresion Op2) {
        this.Op1 = Op1;
        this.Op2 = Op2;
    }

    @Override
    public Object Ejecutar() {
        if ((double)Op2.Ejecutar() == 0) {
            System.err.println("No se puede realizar una operacion entre 0");
            return null;
        }else{
            return (double)Op1.Ejecutar() / (double)Op2.Ejecutar();
        }
    }
    
}
