package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String label;
    private  int addrs;

    @Override
    public void init(ArrayList args) {
        label = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
        if(VM.getRunStack().pop() == 0){
            VM.setPc(addrs);
        }

    }
}
