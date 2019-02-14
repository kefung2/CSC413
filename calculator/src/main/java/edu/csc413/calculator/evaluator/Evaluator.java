package edu.csc413.calculator.evaluator;


import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/() ";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {

        String token;

        // The 3rd argument is true to indicate that the delimiters should be used
        // as tokens, too. But, we'll need to remember to filter out spaces.
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        // initialize operator stack - necessary with operator priority schema
        // the priority of any operator in the operator stack other than
        // the usual mathematical operators - "+-*/" - should be less than the priority
        // of the usual operators


        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        throw new RuntimeException("*****invalid token******");
                    }


                    // TODO Operator is abstract - these two lines will need to be fixed:
                    // The Operator class should contain an instance of a HashMap,
                    // and values will be instances of the Operators.  See Operator class
                    // skeleton for an example.

                    Operator newOperator = Operator.getOperator(token);

                    if (operatorStack.isEmpty()) {
                        operatorStack.push(newOperator);                                  // stack is empty push operator
                    } else if (newOperator.priority() > operatorStack.peek().priority()) {
                        operatorStack.push(newOperator);                              // if new operator have higher priority
                    } else if (newOperator == Operator.getOperator("(")) {
                        operatorStack.push(newOperator);                              // push ( if find
                    } else if (newOperator == Operator.getOperator(")")) {               // if ) is find do everything between () and pop ( when it is find
                        while (operatorStack.peek() != Operator.getOperator("(")) {
                            DotheMath(operatorStack.pop());
                            /**
                             *      Operator oldOpr = operatorstack.pop();
                             *     Operand op2 = operandStack.pop();
                             *     Operand op1 = operandStack.pop();
                             *     operandStack.push(oldOpr.execute(op1, op2));
                             * */
                            if (operatorStack.isEmpty()) {                                // safety check in case of empty stack error, break out of loop if the stack is empty
                                break;
                            }
                        }
                        operatorStack.pop();
                    } else {

                        while (operatorStack.peek().priority() >= newOperator.priority()) { // check if there are higher priority before
                            // note that when we eval the expression 1 - 2 we will
                            // push the 1 then the 2 and then do the subtraction operation
                            // This means that the first number to be popped is the
                            // second operand, not the first operand - see the following code
                            DotheMath(operatorStack.pop());
                            if (operatorStack.isEmpty()) {                                  //safety check
                                break;
                            }
                        }

                        operatorStack.push(newOperator);                                  // push operator in
                    }
                }
            }
        }


        // Control gets here when we've picked up all of the tokens; you must add
        // code to complete the evaluation - consider how the code given here
        // will evaluate the expression 1+2*3
        // When we have no more tokens to scan, the operand stack will contain 1 2
        // and the operator stack will have + * with 2 and * on the top;
        // In order to complete the evaluation we must empty the stacks (except
        // the init operator on the operator stack); that is, we should keep
        // evaluating the operator stack until it only contains the init operator;
        // Suggestion: create a method that takes an operator as argument and
        // then executes the while loop.

        //operatorStack.removeElementAt(0);

        while (!(operatorStack.isEmpty())) {                                      // pop the rest of the operator and operand to finish off the calculation
            DotheMath(operatorStack.pop());
        }

        return operandStack.pop().getValue();                                   // return answer
    }

    private void DotheMath(Operator oldOpr) {
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push(oldOpr.execute(op1, op2));
    }
}
