package AST.Expresion;

/**
 *
 * @author Solares
 */
public abstract class Operacion implements Expresion {

    public Expresion Op1;
    public Expresion Op2;

    public Operacion(Expresion Op1, Expresion Op2) {
        this.Op1 = Op1;
        this.Op2 = Op2;
    }

    public Operacion(Expresion Op1) {
        this.Op1 = Op1;
    }

}
