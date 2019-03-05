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
        System.out.println(" ");
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
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame(){
        int val = peek();
        int frame = framePointer.pop();
        while(runTimeStack.size() >= frame){
            pop();
        }

        push(val);
    }

    public int store (int offset){
        int val = pop();
        //runTimeStack.add(framePointer.peek() - offset);

        return val;
    }

    public int load (int offset){
        int val = runTimeStack.get(framePointer.peek() - offset);
        push(val);
        return val;
    }

    public Integer push(Integer val){
        runTimeStack.add(val);
        return 0;
    }
}
