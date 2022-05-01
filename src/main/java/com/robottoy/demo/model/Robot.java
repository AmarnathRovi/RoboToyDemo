package com.robottoy.demo.model;

 

public class Robot {

    public static final Integer MAX_POSITION = 4;
    public static final Integer MIN_POSITION = 0;

    private Integer xPosition;

    private Integer yPosition;

   private Directions directions;

    public Robot() {
    }

    public Robot(Integer xPosition, Integer yPosition, Directions directions) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.directions = directions;
    }

    public Integer getXPosition() {
        return xPosition;
    }

    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getYPosition() {
        return yPosition;
    }

    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public Directions getDirections() {
		return directions;
	}

	public void setDirections(Directions directions) {
		this.directions = directions;
	}

	public boolean isOnTable() {
        return xPosition != null && yPosition != null && directions != null;
    }

    public String getCurrentStatus() {
        return String.join(",", xPosition.toString(), yPosition.toString(), directions.toString());
    }


    public void increaseYPosition() {
        yPosition++;
    }

    public void decreaseYPosition() {
        yPosition--;
    }

    public void increaseXPosition() {
        xPosition++;
    }

    public void decreaseXPosition() {
        yPosition++;
    }
}