package ExTentor.ExTenta2017;

public class up5 {
    
}

interface Instruction {

    public void execute(Memory memory, ProcramCounter pc);
}

abstract class JumpCommand implements Instruction {
    private int label;
    private Operand op1, op2;
    protected JumpChecker checker;

    public JumpCommand(int label, Operand op1, Operand op2) {
        this.label = label;
        this.op1 = op1;
        this.op2 = op2;
    }

    public void execute(Memory memory, ProgramCounter pc) {
        if (checker.shouldJump(op1.value(memory), op2.value(memory))) {
            pc.set(label);
        }
    }
}

interface JumpChecker {
    boolean shouldJump(double w1, double w2);
}

class JumpLess extends JumpCommand{

    public JumpLess(int label, Operand op1, Operand op2) {
        super(label, op1, op2);
        checker = (w1, w2) -> w1<w2;
    }

}