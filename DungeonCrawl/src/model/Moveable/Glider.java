package model.Moveable;

import java.awt.Color;
import java.awt.Graphics2D;
import model.GameObject;

public class Glider extends Monster {
    public Glider(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //Draw Collision Box
        //g.setColor(Color.blue);
        //g.draw(this.getCollisionBox());
    }

    @Override
    public void update() {
        super.update();
        
        if(isSliding()){
            slide(moving);
        }
    }
    
    @Override
     public void collide(GameObject O){
         super.collide(O);
     }
}
