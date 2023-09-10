import javax.swing.*;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Principal {
    public static void main(String[] args) {

        //pedimos expresion a usuario
        String expresion= JOptionPane.showInputDialog("Ingresa la expresion PostScript");

        //separamos la expresion en tokens usando " " un espacio
        StringTokenizer stringTokenizer= new StringTokenizer(expresion," ");

        //definimos la pila en la que almacenaremos los tokens, ya sean datos numericos u operadores
        Stack <String> stack = new Stack<>();

        //contendremos los numeros que vayan saliendo
        ArrayList<Double> numerosList = new ArrayList<>();

        //variables temporales
        double resultado = 0;//guardamos operaciones entre ellos, la iniciamos en X valor pa q no este fregando
        String operacion;//guardamos la operacion temporalmente


        //Mientras nuestro tokenizer, el cual ya analizó previamente la expresión ingresada por el usuario
        //siga conteniendo tokens, haremos ... lo siguiente
            while(stringTokenizer.hasMoreTokens()) {

                //a nuestra pila añadimos los tokens hasta que no haya más
                //ya sean estos tokens: "12" "3" "4" "Xnumero" "mul" "div" "sub" "add"
                stack.add(stringTokenizer.nextToken());

            }

           try{

               //despues de haberlo rellenado vamos a intentar hacer operaciones con estos valores de la stack
               if(stack.peek().contains("add") || stack.peek().contains("sub") || stack.peek().contains("div") || stack.peek().contains("mul")){

                   operacion = stack.pop();

                   try{
                       boolean peekEsNumero = true;
                       while (peekEsNumero){
                           double token = Double.parseDouble(stack.peek());
                           numerosList.add(token);
                           stack.pop();

                           try{
                               double tokenPrueba = Double.parseDouble(stack.peek());

                           }catch (Exception e){
                               peekEsNumero = false;
                               //si truena y llega al catch, eso indica que el token de prueba fallo en el momento
                               //de parsear, por ende no es un numero y cortamos ahi y > peekEsNumero = false
                           }

                       }//fin while

                       System.out.println("Array de numeros: "+numerosList);
                   }catch (Exception e){
                       System.out.println("vuelva a intentarlo, error en try de parseo de stack.peek a double");
                   }



                   switch (operacion){

                       case "add":

                           //IMPORTANTE CAMBIAR LA VARIABLE "resultado" dependiendo de cada operacion
                           //si es una suma debe estar en cero para que de bien
                           //si es multiplicacion o division, y esta puesta en 0, vale mother todo
                           resultado = 0;
                           for (int i = 0; i < numerosList.size(); i++) {

                              resultado += numerosList.get(i);

                           }//fin for

                           break;

                       case "sub":

                           resultado = 0   ;
                           for (int i = 0; i < numerosList.size(); i++) {

                               resultado =  numerosList.get(i)  - resultado;

                           }

                           break;

                       case "mul":
                            resultado = 1;
                           for (int i = 0; i < numerosList.size(); i++) {

                               resultado *= numerosList.get(i);

                           }

                           break;

                       case "div":

                           resultado = 1   ;
                           for (int i = 0; i < numerosList.size(); i++) {

                               resultado = numerosList.get(i) / resultado;

                           }
                           break;

                   }//fin switch

                   //pusheamos el resultado a la stack para que se siga trabajando con el
                    stack.push(String.valueOf(resultado));

               }//fin if


           }catch (Exception e){
               System.out.println("Intentelo de nuevo, porfavor.");
           }

        System.out.println("respuesta: "+resultado);

    }//fin main

}//fin class