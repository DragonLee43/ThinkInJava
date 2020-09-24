package com.drlee.unit10_innerclass.test4;

/**
 * 温室控制系统
 */
public class GreenHouseControls extends Controller{
    private boolean light = false;
    public class LightOn extends Event{

        public LightOn(long delayTime) {
            super(delayTime);
        }
        public void action() {
            light = true;
            System.out.println("温室控制系统中的灯开了");
        }
    }

    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = false;
            System.out.println("温室控制系统中的灯关了");
        }
    }

    private boolean water = false;
    public class WaterOn extends Event{

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = true;
            System.out.println("温室控制系统 水开了");
        }
    }
    public class WaterOff extends Event{

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = false;
            System.out.println("温室控制系统 水关了");
        }
    }

    public class Bell extends Event{

        public Bell(long delayTime) {
            super(delayTime);
        }

        public void action() {
            addEvent(new Bell(delayTime));
        }
    }

    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e: eventList) {
                addEvent(e);
            }
        }

        public void action() {
            for (Event e: eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }
    }
    public String toString()
    {
        return "restaring system";
    }
}
