package com.guide.bridge.people;

import com.guide.bridge.road.AbstractRoad;
import lombok.Data;

@Data
public abstract class AbstractPeople {
    private AbstractRoad road;
    public abstract void run();
}
