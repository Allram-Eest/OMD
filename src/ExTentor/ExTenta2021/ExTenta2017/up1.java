package ExTentor.ExTenta2021.ExTenta2017;

public class up1 {
    
}

class D {

}

interface Strategy {
    public int op(D d);
}
class A {
    private Strategy operator;

    public A(Strategy op) {
        operator = op;
    }

    public int dolt(D d) {
        return operator.op(d);
    }

    public void setStrategy(Strategy op) {
        operator = op;
    }

}

class B implements Strategy {
    public int op(D d) {
        return 25;
    }
}

class C implements Strategy {
    public int op(D d) {
        return 32;
    }
}

class Run{
    public static void main(String[] args) {
        Strategy b = new B();
        Strategy c = new C();
        D d = new D();
        A a = new A(b);
        a.dolt(d);
        a.setStrategy(c);
        a.dolt(d);

    }
}