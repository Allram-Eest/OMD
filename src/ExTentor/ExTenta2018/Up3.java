package ExTentor.ExTenta2018;

public class Up3 {
    
}

interface Word {
    void add(Word left, Word right);
    void mul(Word left, Word right);
    void copy(Word other);
    boolean equals(Word other);
    String toString();
}

interface WordFactory {
    Word word(String s);
}

class BooleanWordFactory implements WordFactory {

    public BooleanWordFactory() {}

    @Override
    public Word word(String s) {
        if (s.equals("0")) {
            return new BooleanWord(false);
        } else {
            return new BooleanWord(true);
        }
    }

}

class BooleanWord implements Word {
    private boolean state;

    public BooleanWord(boolean state) {
        this.state = state;
    }

    @Override
    public void add(Word left, Word right) {
        state = ((BooleanWord) left).state||((BooleanWord) right).state; 
    }

    @Override
    public void mul(Word left, Word right) {
        state = ((BooleanWord) left).state&&((BooleanWord) right).state;
    }

    @Override
    public void copy(Word other) {
        state = ((BooleanWord) other).state;
    }

    @Override
    public boolean equals(Word other) {
        return state==((BooleanWord) other).state;
    }

    @Override
    public String toString() {
        if (state) {
            return "True";
        } else {
            return "False";
        }
    }
}

