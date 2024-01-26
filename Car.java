import java.awt.*;

//WASSUUUUPPPP
//tjjjjjenare

abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    private double angle; // Direction the car travels in degrees
    private double x;
    private double y;
    public Car(int nrDoors, Color color, double enginePower, String modelname){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelname;
        this.x = 0;
        this.y = 0;
        stopEngine();
    }

    @Override
    public void move() {
        double angle = Math.toRadians(this.angle);
        x += Math.cos(angle) * this.currentSpeed;
        y += Math.sin(angle) * this.currentSpeed;
    }

    @Override
    public void turnLeft() {
        angle += Math.PI/2;
        this.move();
        System.out.println("Turning left");

    }

    @Override
    public void turnRight() {
        angle -= Math.PI/2;
        this.move();
        System.out.println("Turning right");

    }

    public int getNrDoors(){

        return this.nrDoors;
    }
    public double getEnginePower(){

        return this.enginePower;
    }

    public double getCurrentSpeed(){

        return this.currentSpeed;
    }

    public Color getColor(){

        return this.color;
    }

    public void setColor(Color clr){

        this.color = clr;
    }

    public void startEngine(){

        this.currentSpeed = 0.1;
    }

    public void stopEngine(){
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();


    private void incrementSpeed(double amount){
        this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,this.enginePower);
    }

    private void decrementSpeed(double amount){
        this.currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
        else {throw new IllegalArgumentException("Has to be between 0 and 1");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {throw new IllegalArgumentException("Has to be between 0 and 1");
        }


    }

    public double getAngle(){
        return this.angle;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public String getModelName(){
        return this.modelName;
    }

}



