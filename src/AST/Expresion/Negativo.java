
package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Negativo extends Operacion{

    public Negativo(Expresion Op1) {
        super(Op1);
    }

    @Override
    public Object Ejecutar() {
        
        /*
            Solo aplica  * -1   para un tipo double
            el resto son error
        */        
        
        
        Object val_Uno = this.Op1.Ejecutar();
        
        if (val_Uno instanceof Double) {
            return (double)val_Uno  * -1;
        }else{
            System.err.println("Error, solo se puede aplicar Negativo a un elemento tipo Numerico");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }
    
}
