package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameObject;
import model.Moveable.Ball;
import model.Moveable.Bug;
import model.Moveable.Fireball;
import model.Moveable.Gamer;
import model.Moveable.MoveableObject;
import model.Moveable.Glider;
import model.Moveable.Walker;

public class Wall extends Tile {

    public BufferedImage image;

    public Wall(float x, float y) {
        super(x, y);

        try {
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Wall.png");
        } catch (Exception e) {
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) super.x, (int) super.y, (int) WIDTH, (int) HEIGHT, null);

        //Draw Collision Box
        //g.setColor(Color.blue);
        //g.draw(this.getCollisionBox());
    }

}
