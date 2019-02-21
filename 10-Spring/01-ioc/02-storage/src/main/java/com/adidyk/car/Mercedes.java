package com.adidyk.car;

import com.adidyk.body.Body;
import com.adidyk.engine.Engine;
import com.adidyk.transmission.Transmission;

/**
 * Interface Storage defines next method for container of users: add.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 09.02.2019.
 * @version 1.0.
 */
public class Mercedes implements Car {

    /**
     *
     */
    private Body body;

    /**
     *
     */
    private Engine engine;

    /**
     *
     */
    private Transmission transmission;

    /**
     *
     */
    private String color;

    /**
     *
     */
    private boolean sound;

    /**
     *
     */
    private int price;

    Mercedes() {
    }

    Mercedes(Body body, Engine engine, Transmission transmission) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public Mercedes(Body body, Engine engine, Transmission transmission, String color, boolean sound, int price) {
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.sound = sound;
        this.price = price;
    }

    @Override
    public void showCar() {
        this.body.showBody();
        this.engine.showEngine();
        this.transmission.showTransmission();
        System.out.println("color-" + this.color);
        System.out.println("sound-" + this.sound);
        System.out.println("price-" + this.price);
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Body getBody() {
        return body;
    }


    public Engine getEngine() {
        return engine;
    }


    public Transmission getTransmission() {
        return transmission;
    }

}