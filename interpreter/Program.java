package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.FalseBranchCode;
import interpreter.bytecode.GotoCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void setByte(ByteCode bytecode){

        /**
         * add code here
         * Check for Label
         *
         * if(byteCOde instanceof LabelCode){
         *     //somehow map the label the the statement
         * }
         */

        this.program.add(bytecode);

    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
        for(ByteCode byteCode : program.program){

            if(byteCode instanceof GotoCode || byteCode instanceof FalseBranchCode || byteCode instanceof CallCode){

            }
        }
    }





}
