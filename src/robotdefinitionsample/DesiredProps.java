/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import robotdefinitionsample.models.Vector2;

/**
 *
 * @author stefh
 */
public class DesiredProps {
    
    private Vector2 pos;
    private int rotation;
    private boolean discarded;
    private String shelfNameToPickUp;

    public DesiredProps(Vector2 pos, int rotation) {
        this.pos = pos;
        this.rotation = rotation;
        this.discarded = false;
        this.shelfNameToPickUp = "";
    }

    public Vector2 getPos() {
        return pos;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isDiscarded() {
        return discarded;
    }

    public String getShelfNameToPickUp() {
        return shelfNameToPickUp;
    }

    public void setPos(int x, int y) {
        this.pos = new Vector2(x, x);
    }
    
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    public void setShelfNameToPickUp(String shelfNameToPickUp) {
        this.shelfNameToPickUp = shelfNameToPickUp;
    }
    
}
