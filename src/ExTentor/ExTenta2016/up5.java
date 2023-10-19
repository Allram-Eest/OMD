package ExTentor.ExTenta2016;

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

class DrawCircle extends DrawCommand {

    public DrawCircle(int x, int y, int length) {
        super(x, y, length);
    }

    protected void execute() {
        drawing.circle(length);
    }
}

class DrawSquare extends DrawCommand {

    public DrawSquare(int x, int y, int length) {
        super(x, y, length);
    }

    protected void execute() {
        drawing.rectangle(length, length);
    }
}
