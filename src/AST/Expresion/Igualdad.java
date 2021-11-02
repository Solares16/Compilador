package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Igualdad extends Operacion {

    public Igualdad(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {
        // Op1       Op2       Resultado         
        // string   double     Error 
        // double   string     Error 
        // bool     string     Error     
        // string   bool       Error     
        
        // string   string     bool      --Solo operacion = o !=
        // char     string     bool      --Solo operacion = o !=   , convertir char a string
        // string   char       bool      --Solo operacion = o !=   , convertir char a string
        // double   double     bool     
        // char     char       bool      -- Char se convierte a su forma ascii
        // bool     bool       bool      -- bool se conveirte a su forma numerica   
        // char     double     bool      -- Char se convierte a su forma ascii 
        // double   char       bool      -- Char se convierte a su forma ascii
        // bool     double     bool      -- bool se conveirte a su forma numerica 
        // double   bool       bool      -- bool se conveirte a su forma numerica 
        // bool     char       bool      -- bool se convierte a su forma numerica y Char se convierte a su forma ascii
        // char     bool       bool      -- bool se convierte a su forma numerica y Char se convierte a su forma ascii
        Object val_Uno = this.Op1.Ejecutar();
        Object val_Dos = this.Op2.Ejecutar();

        if ((val_Uno instanceof String) && (val_Dos instanceof String)) {
            return val_Uno.toString().equals(val_Dos.toString());
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof String)) {
            return val_Uno.toString().equals(val_Dos.toString());
        } else if ((val_Uno instanceof String) && (val_Dos instanceof Character)) {
            return val_Uno.toString().equals(val_Dos.toString());
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Double)) {
            return (double) val_Uno == (double) val_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Character)) {
            return (int) ((char) val_Uno) == (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Boolean)) {
            int valBool_Uno = (boolean) val_Uno ? 1 : 0;
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return valBool_Uno == valBool_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Double)) {
            return (int) ((char) val_Uno) == (double) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Character)) {
            return (double) val_Uno == (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Double)) {
            int valBool_Uno = (boolean) val_Uno ? 1 : 0;
            return valBool_Uno == (double) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return (double) val_Uno == valBool_Dos;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Character)) {
            int valBool_uno = (boolean) val_Uno ? 1 : 0;
            return valBool_uno == (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Boolean)) {
            int valBool_Dos = (boolean) val_Dos ? 1 : 0;
            return (int) ((char) val_Uno) == valBool_Dos;
        } else {
            System.err.println("Error: Tipo de dato incorrecto");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }

    }

}
