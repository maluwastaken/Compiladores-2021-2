import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class codigo {
    public static void main(String[] args) throws FileNotFoundException {
        List<Token> list;
        list = new ArrayList<Token>();
        File file = new File("Calc1.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String c = sc.nextLine();
            System.out.println("Lista atual: " + list);

            if(c.equals("/") || c.equals("+") || c.equals("-") || c.equals("*")){
                if(c.equals("+")){
                    Token symbol = new Token(TokenType.PLUS, c);
                    list.add(symbol);                    
                }
                else if(c.equals("-")){
                    Token symbol = new Token(TokenType.MINUS, c);
                    list.add(symbol);
                }
                else if(c.equals("*")){
                    Token symbol = new Token(TokenType.STAR, c);
                    list.add(symbol);
                }
                else if(c.equals("/")){
                    Token symbol = new Token(TokenType.SLASH, c);
                    list.add(symbol);
                }
            }
            else{
                try {
                    double test = Double.parseDouble(c);
                    Token number = new Token(TokenType.NUM, c);
                    list.add(number);
                } catch (NumberFormatException nfe) {
                    System.out.println("Error: Unexpected character: " + c);
                    System.exit(1);
                }
                
            }
        }
        while(list.size() != 1){
            Token c = list.remove(0);
            try {
                double test = Double.parseDouble(c.lexeme);

                Token a = list.remove(0);
                Token symb = list.remove(0);

                if(symb.lexeme.equals("/") || symb.lexeme.equals("+") || symb.lexeme.equals("-") || symb.lexeme.equals("*")){
                    if(symb.lexeme.equals("+")){
                        double d = Double.parseDouble(a.lexeme) + Double.parseDouble(c.lexeme);
                        Token e = new Token(TokenType.NUM, String.valueOf(d));
                        list.add(0, e);
                    }
                    else if(symb.lexeme.equals("-")){
                        double d = Double.parseDouble(c.lexeme) - Double.parseDouble(a.lexeme);
                        Token e = new Token(TokenType.NUM, String.valueOf(d));
                        list.add(0, e);
                    }
                    else if(symb.lexeme.equals("*")){
                        double d = Double.parseDouble(a.lexeme) * Double.parseDouble(c.lexeme);
                        Token e = new Token(TokenType.NUM, String.valueOf(d));
                        list.add(0, e);
                    }
                    else if(symb.lexeme.equals("/")){
                        double d = Double.parseDouble(c.lexeme) / Double.parseDouble(a.lexeme);
                        if(Math.abs(d)<Double.POSITIVE_INFINITY) {
                            Token e = new Token(TokenType.NUM, String.valueOf(d));
                            list.add(0, e);
                        }
                        else{
                            System.out.println("Divisao por zero");  
                        }
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: Unexpected character: " + c);
            }
            System.out.println("Lista atual: " + list);
        }
        Token f = list.remove(0);
        System.out.println("O resultado eh: " + f);
        sc.close();
    }
}
