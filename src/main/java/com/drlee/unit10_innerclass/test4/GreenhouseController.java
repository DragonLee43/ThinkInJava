package com.drlee.unit10_innerclass.test4;

public class GreenhouseController {
    public static void main(String[] args) {
        GreenHouseControls gc = new GreenHouseControls();
        gc.addEvent(gc.new Bell(3000));
        Event[] eventList = {
                gc.new LightOn(5000),
                gc.new LightOff(7000),
                gc.new WaterOn(9000),
                gc.new WaterOff(11000)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.run();

    }
}
