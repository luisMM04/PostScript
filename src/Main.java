import javax.swing.*;
import javax.xml.stream.events.Characters;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        //objetos a usar
        String expresion= JOptionPane.showInputDialog("Ingresa la expresion PostScript");
        StringTokenizer stringTokenizer= new StringTokenizer(expresion," ");
        Stack <String> stack = new Stack<>();

        //variables temporales
        int i = 0;
        int temp;
        String operacion;

            while(stringTokenizer.hasMoreTokens()) {
                stack.add(stringTokenizer.nextToken());


                if(Character.isLetter(Integer.parseInt(stack.get(i)))){//si es un "mul" "div" "add" "sub"
                    //...
                    operacion = stack.get(i);
                    System.out.println(operacion+ " soy una operacion de else");
                }//fin else

                if(Character.isDigit(Integer.parseInt(stack.get(i)))){//si es operando
                    //...
                    temp = Integer.parseInt(stack.get(i));
                    System.out.println(temp+" soy un numero de if ");


                }//fin if

                i++;
            }//fin while






    }//fin main

}//fin class