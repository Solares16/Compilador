package AST.Expresion;

/**
 *
 * @author Solares
 */
public class Suma extends Operacion {

    public Suma(Expresion Op1, Expresion Op2) {
        super(Op1, Op2);
    }

    @Override
    public Object Ejecutar() {

        /*
        combinaciones:  
                
        *double double       double
        *string string       string - concat
        *string double       string - concat
        *double String       string - concat

        *double char         double   -  el char se convierte a su ascii numerico 
        *char double         double   -  el char se convierte a su ascii numerico 
        *char char           double   -  el char se convierte a su ascii numerico    

        *double bool         double
        *bool double         double
        *bool bool           bool     - operacion logica or 

        *string char         string - concat
        *char string         string - concat

        *string bool         string - concat
        *bool string         string - concat
        
        *char bool           double -  char y bool se convierten a su forma numerica 
        *bool char           double -  char y bool se convierten a su forma numerica 

        Por cada tipo de dato que tengamos tendremos 2^(numero de tipos de dato) combinaciones 
                
         */
        Object val_Uno = this.Op1.Ejecutar();
        Object val_Dos = this.Op2.Ejecutar();

        if ((val_Uno instanceof Double) && (val_Dos instanceof Double)) {
            return (double) val_Uno + (double) val_Dos;
        } else if ((val_Uno instanceof String) && (val_Dos instanceof String)) {
            return (String) val_Uno + (String) val_Dos;
        } else if ((val_Uno instanceof String) && (val_Dos instanceof Double)) {
            return (String) val_Uno + (double) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof String)) {
            return (double) val_Uno + (String) val_Dos;
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Character)) {
            return (double) val_Uno + (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Double)) {
            return (int) ((char) val_Uno) + (double) val_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Character)) {
            //Para obtener el codigo  ascii de un caracter  basta con castearlo a int
            return (int) ((char) val_Uno) + (int) ((char) val_Dos);
        } else if ((val_Uno instanceof Double) && (val_Dos instanceof Boolean)) {
            // De esta forma se convierte un bool a su forma int, para realizar la suma double + bool
            int BoolInt_val = ((boolean) val_Dos) ? 1 : 0;
            return (double) val_Uno + BoolInt_val;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Double)) {
            // De esta forma se convierte un bool a su forma int, para realizar la suma bool + double
            int BoolInt_val = ((boolean) val_Uno) ? 1 : 0;
            return BoolInt_val + (double) val_Dos;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Boolean)) {
            return (boolean) val_Uno || (boolean) val_Dos;
        } else if ((val_Uno instanceof String) && (val_Dos instanceof Character)) {
            return (String) val_Uno + (char) val_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof String)) {
            return (char) val_Uno + (String) val_Dos;
        } else if ((val_Uno instanceof String) && (val_Dos instanceof Boolean)) {
            String Val_Bool = (boolean) val_Dos ? "verdadero" : "falso";
            return (String) val_Uno + Val_Bool;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof String)) {
            String Val_Bool = (boolean) val_Uno ? "verdadero" : "falso";
            return (String) Val_Bool + val_Dos;
        } else if ((val_Uno instanceof Character) && (val_Dos instanceof Boolean)) {
            int Val_Char = (char) val_Uno;
            int Val_Bool = (boolean) val_Dos ? 1 : 0;
            return Val_Char + Val_Bool;
        } else if ((val_Uno instanceof Boolean) && (val_Dos instanceof Character)) {
            int Val_Bool = (boolean) val_Uno ? 1 : 0;
            int Val_Char = (char) val_Dos;
            return Val_Bool + Val_Char;
        } else {
            System.err.println("Error de tipos en la suma");
            return null;
            //Aqui falta definir un Objeto Error para manipular esto de mejor forma
        }
    }
}
