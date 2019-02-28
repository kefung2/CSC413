package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){

    }

    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1);
    }

    public int pop(){

        int itemToPop = runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        return itemToPop;
    }

    public void newFrameAt(int offset){

    }

    public void popFrame(){

    }

    public int store (int offset){
        return 0;
    }

    public int load (int offset){
        return 0;
    }

    public Integer push(Integer val){
        return 0;
    }
}
