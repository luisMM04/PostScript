import javax.swing.*;
import javax.xml.stream.events.Characters;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        //pedimos expresion a usuario
        String expresion= JOptionPane.showInputDialog("Ingresa la expresion PostScript");

        //separamos la expresion en tokens usando " " un espacio
        StringTokenizer stringTokenizer= new StringTokenizer(expresion," ");

        //definimos la pila en la que almacenaremos los tokens, ya sean datos numericos u operadores
        Stack <String> stack = new Stack<>();


        //variables temporales
        int i = 0;//avanza index de la stack
        int temp;//guardamos los valores numericos temporalmente
        String operacion;//guardamos la operacion temporalmente


        //Mientras nuestro tokenizer, el cual ya analizó previamente la expresión ingresada por el usuario
        //siga conteniendo tokens, haremos ... lo siguiente
            while(stringTokenizer.hasMoreTokens()) {

                //a nuestra pila añadimos los tokens hasta que no haya más
                //ya sean estos tokens: "12" "3" "4" "Xnumero" "mul" "div" "sub" "add"
                stack.add(stringTokenizer.nextToken());

            }




    }//fin main

}//fin class