package ExTentor.ExTenta2021;

abstract class JumpInstruction {
    private int target;
    private Operand left, right;

    public JumpInstruction(int target, Operand left, Operand right) {
        this.target = target;
        this.left = left;
        this.right = right;
    }

    public abstract boolean evaluate(Word w1, Word w2);

    public void execute(Memory memory, PC pc) {
        if (evaluate(left.getWord(memory), right.getWord(memory)) {
            pc.jumpTo(target);
        } else {
            pc.step();
        }
    }
}

class JumpEq extends JumpInstruction implements Instruction{

    public JumpEq(int target, Operand left, Operand right) {
        super(target, left, right);
    }

    public boolean evaluate(Word w1, Word w2) {
        return w1.equals(w2);
    }
}

class JumpNeq extends JumpInstruction implements Instruction{

    public JumpNeq(int target, Operand left, Operand right) {
        super(target, left, right);
    }

    public boolean evaluate(Word w1, Word w2) {
        return !w1.equals(w2);
    }
}

interface Word {

}

interface Operand {

    public Word getWord(Memory memory);
}

interface Memory {

}

interface PC {
    public void step();

    public void jumpTo(int target);
}