package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String name;

    @Override
    public void init(ArrayList args) {
        name = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {

    }


}
