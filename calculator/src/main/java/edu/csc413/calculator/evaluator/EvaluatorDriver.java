package edu.csc413.calculator.evaluator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EvaluatorDriver {
    /**
     * Driver class that uses Evaluator to evaluate expressions.
     * The expressions can either be given as a command line argument
     * OR typed in at the keyboard. If you wish to type in expressions
     * give NO commmand line arguments. Otherwise you may give a list of
     * strings as a command line argument and the driver will run all strings
     * in that list.
     *
     * @param args command line arguments.
     */
    public static void main(String... args){
        BufferedReader input;
        String exp;
        int res;

        Evaluator ev = new Evaluator();
        if(args.length == 0){
            try {
                input = new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    System.out.print("Enter an Expression: ");
                    exp = input.readLine();
                    res = ev.eval(exp);
                    System.out.printf("Expression : %s , Result %6d\n", exp, res);
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }else{
            for(String ex : args) {
                res = ev.eval(ex);
                System.out.printf("Expression : %s , Result: %-6d\n", ex, res);
            }

        }
    }
}
