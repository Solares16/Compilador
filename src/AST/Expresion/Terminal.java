package AST.Expresion;

/**
 *
 * @author Solares
 */
public abstract class Terminal implements Expresion {

    public Object value;

    public Terminal(Object value) {
        this.value = value;
    }
}
