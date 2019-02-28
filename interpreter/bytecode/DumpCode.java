package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private boolean dumping;

    @Override
    public void init(ArrayList args) {
        if((String) args.get(0) == "ON"){
            dumping = true;
        }else{
            dumping = false;
        }
    }

    @Override
    public void execute(VirtualMachine VM) {
    }
}
