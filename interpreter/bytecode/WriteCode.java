package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    private int val;

    @Override
    public void init(ArrayList args) {

    }

    @Override
    public void execute(VirtualMachine VM) {
        val = VM.getRunStack().peek();
        System.out.println(val);
    }
}
