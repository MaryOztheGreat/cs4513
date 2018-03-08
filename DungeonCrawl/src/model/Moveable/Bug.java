package model.Moveable;

import controller.ImageFinder;
import controller.ObjectAnimator;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Direction;
import model.GameObject;
import model.Immoveable.Tile.Fire;
import model.Immoveable.Tile.Wall;
import model.Immoveable.Tile.Water;

public class Bug extends Monster {
    public BufferedImage[] Bug_S;
    public BufferedImage[] Bug_N;
    public BufferedImage[] Bug_W;
    public BufferedImage[] Bug_E;
    
    private ObjectAnimator bugMoves;
    private int counter;

    public Bug(float x, float y, Direction d) {
        super(x, y);
        bugMoves = new ObjectAnimator();
        super.direction = d;
        moving = d;
        
        Bug_S = new BufferedImage[1];
        Bug_N = new BufferedImage[1];
        Bug_W = new BufferedImage[1];
        Bug_E = new BufferedImage[1];
        
        try {
            BufferedImage image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Bug_S.png");
            Bug_S[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Bug_N.png");
            Bug_N[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Bug_W.png");
            Bug_W[0] = image;
            image = (BufferedImage) ImageFinder.getImage("ImagesFolder", "Bug_E.png");
            Bug_E[0] = image;
        } catch (Exception e) {
        }
        bugMoves.setFrames(Bug_E);
    }    

    @Override
    public void render(Graphics2D g) {
        g.drawImage(bugMoves.getImage(),(int) super.x, (int) super.y, (int) HEIGHT, (int) WIDTH,
                null);
        
        //Draw Collision Box
        //g.setColor(Color.yellow);
        //g.draw(this.getCollisionBox());
    }

    @Override
    public void update() {
        super.update();
        
        if (isSliding()) {
            direction = moving;
            slide(moving);
        } else {
            if (counter == 1000) {
                counter = 0;
                switch (direction) {
                    case LEFT:
                        bugMoves.setFrames(Bug_W);
                        super.x -= MOVEMENT;
                        break;
                    case RIGHT:
                        bugMoves.setFrames(Bug_E);
                        super.x += MOVEMENT;                                                
                        break;
                    case UP:
                        bugMoves.setFrames(Bug_N);
                        super.y -= MOVEMENT;                        
                        break;
                    case DOWN:
                        bugMoves.setFrames(Bug_S);
                        super.y += MOVEMENT;                        
                        break; 
                }
                moving = direction;
            } else {
                counter += 100;
            }
        }
        bugMoves.update();
    }
    
    public void turn(Direction d) {
        direction = d;
        moving = d;
    }               
    
    @Override
    public void collide(GameObject O){
        if(O instanceof Gamer){
            super.collide(O);
        } else if (O instanceof Wall) {            
            direction = direction.getOppositeDirection();
        }
    }
}
