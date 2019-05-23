package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int numOfArgs;

    @Override
    public void init(ArrayList args) {
        numOfArgs = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine VM) {
        VM.getRunStack().newFrameAt(numOfArgs);
    }
}
