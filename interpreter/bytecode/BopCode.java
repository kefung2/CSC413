package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String opreator;
    @Override
    public void init(ArrayList args) {
        opreator = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
        int ans;
        int op1 = VM.getRunStack().pop();
        int op2 = VM.getRunStack().pop();

        switch(opreator){
            case "+":
                ans = op1 + op2;
                VM.getRunStack().push(ans);
                break;
            case "-":
                ans = op2 - op1;
                VM.getRunStack().push(ans);
                break;
            case "/":
                ans = op2/op1;
                VM.getRunStack().push(ans);
                break;
            case "*":
                ans = op1 * op2;
                VM.getRunStack().push(ans);
                break;
            case "==":
                if (op1 == op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case "!=":
                if (op1 != op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case "<=":
                if (op1 <= op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case ">":
                if (op1 > op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case ">=":
                if (op1 >= op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case "<":
                if (op1 < op2){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case "|":
                if(op1 == 1 || op2 == 1){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;
            case "&":
                if(op1 == 1 && op2 == 1){
                    ans = 1;
                }else{
                    ans = 0;
                }
                VM.getRunStack().push(ans);
                break;

        }

    }
}
