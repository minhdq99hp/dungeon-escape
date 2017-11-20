public class GameObject {
    private Vector2D position;
    private char symbol;
    GameObject(){

    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void moveUp() {
        if(this.position.y > 0) this.position.y--;
    }
    public void moveDown() {
        if(this.position.y < Settings.GAME_HEIGHT - 1) this.position.y++;
    }
    public void moveLeft() {
        if(this.position.x > 0) this.position.x--;
    }
    public void moveRight(){
        if(this.position.x < Settings.GAME_WIDTH - 1) this.position.x++;
    }
}
