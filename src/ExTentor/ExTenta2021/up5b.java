package ExTentor.ExTenta2021;

class JumpInstruction {
    private int target;
    private Operand left, right;
    WordComparator wc; 

    public JumpInstruction(int target, Operand left, Operand right, WordComparator wc) {
        this.target = target;
        this.left = left;
        this.right = right;
        this.wc = wc;
    }

    public void execute(Memory memory, PC pc) {
        if (wc.compare(left.getWord(memory), right.getWord(memory))) {
            pc.jumpTo(target);
        } else {
            pc.step();
        }
    }
}


interface WordComparator {
    public boolean compare(Word w1, Word w2);
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

//För att implementera JumpEq

class Test {
    public static void main(String[] args) {
        JumpInstruction jumpEq = new JumpInstruction(0, O1, O2, (w1, w2) -> w1.equals(w2));
        JumpInstruction jumpNeq = new JumpInstruction(0, O1, O2, (w1, w2) -> !w1.equals(w2));
    }
}