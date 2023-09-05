class Notes {

}

class Drawing {

    public void setDrawMode() {

    }

    public void setEraseMode() {

    }

    public void arc(int x, int y, int width, int height, ){

    }

}

interface DrawCommand {

}


abstract class DrawShape implements DrawCommand {
    protected int x, y;
    private Drawing drawing;

    public DrawShape(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected abstract void drawShape(Drawing drawing); 

    //Execute och undo är template-metoderna
    public void execute(Drawing drawing) {
        this.drawing = drawing;
        drawing.setDrawMode();
        drawShape(drawing);
    }

    public void undo() {
        drawing.setEraseMode();
        drawShape(drawing);
    }

}

class DrawCircle extends DrawShape {
    private int radius;

    public DrawCircle (int x, int y, int radius) {
        super(x ,y);
        this.radius = radius;
    }

    protected void drawShape(Drawing drawing) {
        drawing.arc(x, y, radius, radius, 0, 2*Math.PI);
    }
}

class DrawSquare extends DrawShape {
    private int side;
    private Drawing drawing;

    public DrawSquare (int x, int y, int side) {
        super(x, y);
        this.side = side;
    }

    protected void drawShape(Drawing drawing) {

    }

}

class DrawMacro implements DrawCommand {
    private List<DrawCommand> shapes = new ArrayList<>();

    public DrawMacro (DrawCommand... shapes) {
        for (var shape : shapes) {
            this.shapes.add(shape);
        }
    }

    public void execute(Drawing drawing) {
        for (var shape : shapes) {
            shape.execute(drawing);
        }
    }

    
    public void undo(Drawing drawing) {
        for (var shape : shapes) {
            shape.execute(drawing);
        }
    }
}