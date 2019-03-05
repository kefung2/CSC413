package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    //sample base function given
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
             if(isDumping) {
                runStack.dump(); // Used to dump runstack state
              }
            pc++;
        }
    }

    public RunTimeStack getRunStack() {
        return runStack;
    }

    public void setRunning(){
        isRunning = false;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getReturnAddrs(){
        return returnAddrs.pop();
    }

    public void setDumping (boolean dumpState) {
        isDumping = dumpState;
    }
}
