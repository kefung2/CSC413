package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    private String label;

    @Override
    public void init(ArrayList args) {
        label = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {

    }
}
