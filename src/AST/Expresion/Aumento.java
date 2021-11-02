
package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Aumento extends Operacion{

    public Aumento(Expresion Op1) {
        super(Op1);
    }

    @Override
    public Object Ejecutar() {
                
        /*
            El aumento consiste en incrementar 1 unidad a la expresion 
            Solo aplica a tipos de dato numerico 
        */
        
        Object val_Uno = this.Op1.Ejecutar();
        
        if (val_Uno instanceof Double) {
            return (double)val_Uno  + 1;
        }else{
            System.err.println("La operacion incremento solo se aplica a tipos de dato Numerico");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }
    
}
