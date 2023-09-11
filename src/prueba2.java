import javax.swing.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class prueba2 {
    private static final Logger logger = Logger.getLogger(prueba2.class.getName());
    public static void main(String[] args) {
        FileHandler fh;
        try {
            fh = new FileHandler("logfile.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String expresion = JOptionPane.showInputDialog("Ingresa la expresion PostScript");
        if (expresion.isEmpty()) {
            System.out.println("introduce una expresion");
            logger.severe("no hay una expresion");
        } else {

            StringTokenizer stringTokenizer = new StringTokenizer(expresion, " ");
            Stack<String> stack = new Stack<>();
            double resultado = 0;
            while (stringTokenizer.hasMoreTokens()) {
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
                                    logger.severe("division entre 0");
                                    throw new ArithmeticException("Division entre cero");

                                }
                                break;
                            default:
                                throw new IllegalArgumentException("Operador inválido: " + valor);

                        }
                        stack.push(Double.toString(resultado));
                    } catch (Exception e) {
                        logger.log(Level.WARNING, "Error en operación", e);
                        System.out.println(e.getMessage());
                    }

                } else {
                    stack.push(valor);
                }
            }
            System.out.println("El resultado es: " + resultado);
            logger.info("El resultado es: " + resultado);
        }
    }

    private static boolean esOperador(String token) {
        return token.equals("add") || token.equals("sub") || token.equals("mul") || token.equals("div");
    }
}
