package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Decremento extends Operacion {

    public Decremento(Expresion Op1) {
        super(Op1);
    }

    @Override
    public Object Ejecutar() {

        /*
            El decremento consiste en restar 1 unidad a la expresion 
            Solo aplica a tipos de dato numerico 
         */
        Object val_Uno = this.Op1.Ejecutar();

        if (val_Uno instanceof Double) {
            return (double) val_Uno - 1;
        } else {
            System.err.println("La operacion Decremento solo se aplica a tipos de dato numerico. ");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }

}
