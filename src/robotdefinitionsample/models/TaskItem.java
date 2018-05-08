/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.exceptions.WeightTooHigh;

/**
 *
 * @author ditlev
 */
class TaskItem {
    
    //Direction values
    private final int right = 0;
    private final int up = 270;
    private final int left = 180;
    private final int down = 90;
    
    private Robot robot;
    private ActionCondition ac;
    private boolean done;
    private int speed;
    
    public TaskItem(Robot robot, ActionCondition ac) {
        this.robot = robot;
        this.ac = ac;
        this.done = false;
        this.speed = 1;
    }
    
    public ActionCondition getAction() {
        return ac;
    }
    
    public void executeCommand(DesiredProps props) {
        //Maybe some general code can be done here.
        
        switch (ac) {
            case FORWARD:
                forward(props);
                break;
            case TURN_CW:
                turnCW(props);
                break;
            case TURN_CCW:
                turnCCW(props);
                break;
            case BACKWARD:
                backward(props);
                break;
        }
    }
    
    public boolean isDone() {
        return done;
    }
    
    private void forward(DesiredProps props) {
       
        int currentDirection = (int) robot.rotateProperty().get();

	        switch (currentDirection) {
	            case right:
	                props.setPos(robot.getPos().add(1, 0));
	                speed--;
	                break;
	            case left:
	                props.setPos(robot.getPos().add(-1, 0));
	                speed--;
	                break;
	            case up:
	                props.setPos(robot.getPos().add(0, -1));
	                speed--;
	                break;
	            case down:
	                props.setPos(robot.getPos().add(0, 1));
	                speed--;
	                break;
	        }

	        if (speed == 0) {
                done = true;
            }
    }
    
    private void backward(DesiredProps props) {
    	int currentDirection = (int) robot.rotateProperty().get();
        
    	while(speed > 0) {
	    	switch (currentDirection) {
	        case right:
	            props.setPos(robot.getPos().add(-speed, 0));
	            speed--;
	            break;
	        case left:
	            props.setPos(robot.getPos().add(speed, 0));
	            speed--;
	            break;
	        case up:
	            props.setPos(robot.getPos().add(0, speed));
	            speed--;
	            break;
	        case down:
	            props.setPos(robot.getPos().add(0, -speed));
	            speed--;
	            break;
	    	}
    	}

        if (speed == 0) {
            done = true;
        }
    }
    
    private void turnCW(DesiredProps props) {
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
        case right:
            props.setRotation(down);
            break;
        case left:
            props.setRotation(up);
            break;
        case up:
            props.setRotation(right);
            break;
        case down:
            props.setRotation(left);
            break;
        }  
        
        done = true;
    }
    
    private void turnCCW(DesiredProps props) {
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
        case right:
            props.setRotation(up);
            break;
        case left:
        	props.setRotation(down);
            break;
        case up:
        	props.setRotation(left);
            break;
        case down:
        	props.setRotation(right);
            break;
        }
        
        done = true;
    }
    
    public TaskItem setSpeed(int speed) {
    	this.speed = speed;
    	return this;
    }
}
