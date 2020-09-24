package com.drlee.unit10_innerclass.test4;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event event)
    {
        eventList.add(event);
    }

    /**
     * 消费&执行时间，这个方法的设计中，你并不知道Event做了什么，这正是设计的关键所在
     * 使变化的事务与不变的事物相隔离。
     * 就是用不同的Event对象所具有不同的行为，而你通过创建不同的Event自类来表现不同的行为
     */
    public void run()
    {
        while (eventList.size() > 0)
        {
            for (Event e : new ArrayList<Event>(eventList)) {
                if (e.ready())
                {
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}

