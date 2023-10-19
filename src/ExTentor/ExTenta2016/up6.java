package ExTentor.ExTenta2016;

import java.util.Stack;

interface Drawing {
    void clear();
    void useForegroundColor();
    void useBackgroundColor();
    void moveTo( int x , int y );
    void circle( int radius);
    void rectangle( int width , int height) ;
}

abstract class DrawCommand {
    protected int midPointX, midPointY;
    protected int length;
    protected Drawing drawing;

    public DrawCommand(int x, int y, int length) {
        midPointX = x;
        midPointY = y;
        this.length = length;
    }

    abstract protected void execute();

    public void draw(Drawing d) {
        this.drawing = d;
        drawing.moveTo(midPointX, midPointY);
        drawing.useForegroundColor();
        execute();
    };

    void undo() {
        drawing.useBackgroundColor();
        execute();
    };
}

interface Action {
    void execute(Drawing d, Stack<DrawCommand> history);
}

class DrawAction implements Action {
    private DrawCommand cmd;

    public DrawAction(DrawCommand cmd) {
        this.cmd = cmd;
    } 

    public void execute(Drawing d, Stack<DrawCommand> history) {
        cmd.draw(d);
        history.push(cmd);

    }
}

class Undo implements Action {

    public void execute(Drawing d, Stack<DrawCommand> history) {
        if(history.isEmpty()) {
            return;
        } else {
            history.pop().undo();
        }
    }
}

class Exit implements Action {

    public void execute(Drawing d, Stack<DrawCommand> history) {
        System.exit(0);
    }
}

interface GUI {
    Action next();
}

class Test {

    void run(GUI gui, Drawing d) {
        Stack<DrawCommand> history = new Stack<>();
        while(true) {
            gui.next().execute(d, history);
        }
    }
}
