import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class prueba2 {
    public static void main(String[] args) {
        String expresion= JOptionPane.showInputDialog("Ingresa la expresion PostScript");

        StringTokenizer stringTokenizer= new StringTokenizer(expresion," ");
        Stack<String> stack = new Stack<>();
        double resultado = 0;
        while(stringTokenizer.hasMoreTokens()) {
            String valor = stringTokenizer.nextToken();
            if (esOperador(valor)) {
                double expresion1 = Double.valueOf(stack.pop());
                double expresion2 = Double.valueOf(stack.pop());

                try {
                    switch (valor) {
                        case "add":
                            resultado = expresion1 + expresion2;
                            break;
                        case "sub":
                            resultado = expresion1 - expresion2;
                            break;
                        case "mul":
                            resultado = expresion1 * expresion2;
                            break;
                        case "div":
                            if (expresion2 != 0) {
                                resultado = expresion1 / expresion2;
                            } else {
                                throw new ArithmeticException("Division entre cero");
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Operador inválido: " + valor);

                    }
                    stack.push(Double.toString(resultado));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                stack.push(valor);
            }
        }
        System.out.println("El resultado es: "+resultado);
    }

    private static boolean esOperador(String token) {
        return token.equals("add") || token.equals("sub") || token.equals("mul") || token.equals("div");
    }
}
