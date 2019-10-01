package core;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static core.CheckersApp.TILE_SIZE;



public class Piece extends StackPane {

    private PieceType type;

    private double mouseX, mouseY;
    private double oldX, oldY;

    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PieceType type, int x, int y) {
        this.type = type;

        move(x, y);
        Circle pieceCircle = new Circle(TILE_SIZE * 0.3125);
        pieceCircle.setFill(type == PieceType.BLACK
                ? Color.valueOf("#000000") : Color.valueOf("#fff9f4"));

        pieceCircle.setStrokeWidth(TILE_SIZE * 0.03);

        pieceCircle.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
        pieceCircle.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(pieceCircle);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
        });
    }

    void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX, oldY);
    }

    void abortMove() {
        relocate(oldX, oldY);
    }
}
