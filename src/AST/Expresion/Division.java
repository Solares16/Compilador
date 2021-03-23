package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Division extends Operacion {

    public Division(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {
        /*
         
            tipos de datos
            numerico
            caracter
            booleano
                
         * double caracter      double       ---caracter se convierte a su forma ascii
         * caracter double      double
         
         * double   double      double 
         * caracter caracter    double 
         * booleano booleano    booleano     -- se realiza una operacion AND
         
         * double   booleano    double       --booleano se convierte a su forma ascii
         * booleano double      double      
        
         * booleano caracter    double 
         * caracter booleano    double
         
         */

        Object val_Uno = this.Op1.Ejecutar();
        Object val_Dos = this.Op2.Ejecutar();

        if ((val_Uno instanceof Double) && (val_Dos instanceof Character)) {
            return Dividir((double) val_Uno, (int) ((char) val_Dos));
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Double)) {
            return Dividir((int) ((char) val_Uno), (double) val_Dos);
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Double)) {
            return Dividir((double) val_Uno, (double) val_Dos);
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Character)) {
            return Dividir((int) ((char) val_Uno), (int) ((char) val_Dos));
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Boolean)) {
            int valBool_Uno = (boolean) val_Uno ? 1 : 0;
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return Dividir(valBool_Uno, valBool_Dos);
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 0 : 1;
            return Dividir((double) val_Uno, valBool_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Double)) {
            int valBool_Uno = (boolean) val_Uno ? 0 : 1;
            return Dividir(valBool_Uno, (double) val_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Character)) {
            int valBool_Uno = (boolean) val_Uno ? 0 : 1;
            return Dividir(valBool_Uno, (int) ((char) val_Dos));
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return Dividir((int) ((char) val_Uno), valBool_Dos);
        } else {
            System.err.println("Error de tipos en la Division");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }

    }

    private Object Dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.err.println("Error: No se pude realizar una division entre 0. " + " Valor: " + a + "Valor: " + b);
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }

}
