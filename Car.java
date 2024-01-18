import java.awt.*;

public class Car {
    public boolean turboOn;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    public Car(int nrDoors, Color color, double enginePower, String modelname){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelname;
        stopEngine();
    }

    public int getNrDoors(){

        return nrDoors;
    }
    public double getEnginePower(){

        return enginePower;
    }

    public double getCurrentSpeed(){

        return currentSpeed;
    }

    public Color getColor(){

        return color;
    }

    public void setColor(Color clr){

        color = clr;
    }

    public void startEngine(){

        currentSpeed = 0.1;
    }

    public void stopEngine(){

        currentSpeed = 0;
    }

    public double speedFactor(){

        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){

        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){

        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){

        decrementSpeed(amount);
    }

    

}
