public class Vector2D {
    int x;
    int y;

    Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector2D vector2D){
        return (x == vector2D.x && y == vector2D.y);
    }
}
