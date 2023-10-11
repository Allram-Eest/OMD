package Lek7;

public class Adapter {
    
}

interface A {
    public void operation();
}

class Example {
    
    public void op() {
        //gör samma sak som operation skall göra
    }
}

class AdapterExample {

    public void main(String[] args) {
        new AdapterExample().run();
    }

    void run() {
        var e = new Example();
        doSomething(e);
    }

    void doSomething(A a) {
        a.operation(); //då A har en metod op, som gör detsamma som operation, vet inte doSomething att det är den metoden som skall användas
    }
}

class ExampleToAAdaptObject implements A {
    private Example e;

    public void operation() {
        e.op();
    }
}

class ExampleToAAdaptClass implements A extends Example {
    
    public void operation() {
        this.op();
    }
}