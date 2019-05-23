package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    int val;
    String name;

    @Override
    public void init(ArrayList args) {
        val = Integer.parseInt((String) args.get(0));
        if (args.size() == 2){
            name = (String) args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine VM) {
        VM.getRunStack().push(val);
    }
}
