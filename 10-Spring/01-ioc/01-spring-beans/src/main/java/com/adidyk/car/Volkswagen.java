package com.adidyk.car;

import com.adidyk.body.Body;
import com.adidyk.engine.Engine;
import com.adidyk.transmission.Transmission;

/**
 * Class Volkswagen create car mercedes with param: body, engine, transmission, color, sound, price.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class Volkswagen implements Car {

    /**
     * @param body - link variable to object of interface Body.
     */
    private Body body;

    /**
     * @param engine - link variable to object of interface Engine.
     */
    private Engine engine;

    /**
     * @param transmission - link variable to object of interface Transmission.
     */
    private Transmission transmission;

    /**
     * @param color - color car.
     */
    private String color;

    /**
     * @param sound - sound in car.
     */
    private boolean sound;

    /**
     * @param price - price car.
     */
    private int price;

    /**
     * Volkswagen - constructor.
     */
    Volkswagen() {
    }

    /**
     * Volkswagen - constructor.
     * @param body - body car.
     * @param engine - engine car.
     * @param transmission - transmission car.
     */
    Volkswagen(Body body, Engine engine, Transmission transmission) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    /**
     * Volkswagen - constructor.
     * @param body - body car.
     * @param engine - engine car.
     * @param transmission - transmission car.
     * @param color - color car.
     * @param sound - sound car.
     * @param price - price car.
     */
    public Volkswagen(Body body, Engine engine, Transmission transmission, String color, boolean sound, int price) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.sound = sound;
        this.price = price;
    }

    /**
     * showCar - shows all information about car.
     */
    @Override
    public void showCar() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println("--------------------");
        this.body.showBody();
        this.engine.showEngine();
        this.transmission.showTransmission();
        System.out.println("color-" + this.color);
        System.out.println("sound-" + this.sound);
        System.out.println("price-" + this.price);
        System.out.println("--------------------");
    }

    /**
     * setBody - sets body for car.
     * @param body - body car.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * setEngine - sets engine for car.
     * @param engine - engine car.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * setTransmission - sets transmission for car.
     * @param transmission - transmission car.
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    /**
     * setColor - sets color car.
     * @param color - color car.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * setSound - sets sound car.
     * @param sound - sound car.
     */
    public void setSound(boolean sound) {
        this.sound = sound;
    }

    /**
     * setPrice - sets price car.
     * @param price - price car.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * getBody - returns body car.
     * @return - returns body car.
     */
    public Body getBody() {
        return body;
    }

    /**
     * getEngine - returns engine car.
     * @return - returns engine car.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * getTransmission - returns transmission car.
     * @return - returns transmission car.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * getColor - returns color car.
     * @return - returns color car.
     */
    public String getColor() {
        return color;
    }

    /**
     * getSound - returns sound car.
     * @return - returns sound car.
     */
    public boolean getSound() {
        return sound;
    }

    /**
     * getPrice - returns price car.
     * @return - returns price car.
     */
    public int getPrice() {
        return price;
    }

}