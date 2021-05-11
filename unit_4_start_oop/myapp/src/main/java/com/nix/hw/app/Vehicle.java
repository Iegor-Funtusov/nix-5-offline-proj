package com.nix.hw.app;

import com.nix.hw.lib.Entity;

public class Vehicle extends Entity{

    private int engineVolume;

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        if (engineVolume > 0)
            this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + super.getId() +
                ", engineVolume=" + engineVolume + " cubic centimeters" +
                '}';
    }
}
