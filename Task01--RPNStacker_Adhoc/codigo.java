import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;

public class codigo {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<String> stack = new Stack<String>();
        File file = new File("Calc1.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String c = sc.nextLine();
            System.out.println(stack);
            String a = stack.pop();
            String b = stack.pop();

            if(c.equals("/") || c.equals("+") || c.equals("-") || c.equals("*")){
                if(c.equals("+")){
                    double d = Double.parseDouble(a) + Double.parseDouble(b);
                    String e = String.valueOf(d);
                    stack.push(e);
                }
                else if(c.equals("-")){
                    double d = Double.parseDouble(b) - Double.parseDouble(a);
                    String e = String.valueOf(d);
                    stack.push(e);
                }
                else if(c.equals("*")){
                    double d = Double.parseDouble(a) * Double.parseDouble(b);
                    String e = String.valueOf(d);
                    stack.push(e);
                }
                else if(c.equals("/")){
                    double d = Double.parseDouble(b) / Double.parseDouble(a);
                    if(Math.abs(d)<Double.POSITIVE_INFINITY) {
                        String e = String.valueOf(d);
                        stack.push(e);
                    }
                    else{
                        System.out.println("Divisao por zero");  
                    }
                }
            }
            else 
                stack.push(c);
        }
        System.out.println(stack);
        String f = stack.pop();
        System.out.println("O resultado eh: " + f);
        sc.close();
    }
}
