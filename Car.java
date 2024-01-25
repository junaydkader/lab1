import java.awt.*;

//WASSUUUUPPPP
//tjjjjjenare

public class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String modelName; // The car model name

    public double angle; // Direction the car travels in degrees

    public Car(int nrDoors, Color color, double enginePower, String modelname){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelname;
        stopEngine();
    }

    @Override
    public void move() {
        double angle = Math.toRadians(this.angle);
        double x = Math.cos(angle) * this.currentSpeed;
        double y = Math.sin(angle) * this.currentSpeed;

        if (x < 0 ) {
            turnLeft();
        }
        else if (x > 0) {
            turnRight();
        }
    }

    @Override
    public void turnLeft() {
        System.out.println("Turning left");

    }

    @Override
    public void turnRight() {
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

    public double speedFactor(){

        return this.enginePower * 0.01;
    }

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
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }

    }

}



