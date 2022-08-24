package com.son.soundanimal.model;

import java.io.Serializable;

public class AnimalModel implements Serializable {
    private final int drawableId;
    private final String name;

    public AnimalModel(int drawableId,String name) {
        this.drawableId = drawableId;
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }
}
