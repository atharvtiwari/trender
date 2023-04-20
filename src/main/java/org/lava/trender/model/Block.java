package org.lava.trender.model;

import java.util.ArrayList;
import java.util.List;

// import org.lava.trender.model.Sprite;

public class Block
{
    public boolean SOLID_RENDER = false;
    public boolean SOLID_MOTION = false;
    public List<Sprite> sprites = new ArrayList<Sprite>();
    public int texture = 0;
    public int colour = 0x555555;
    public int ceilingTexture = 0;
    public int ceilingColour = 0x555555;
    public int floorTexture = 0;
    public int floorColour = 0x555555;

    public void addSprite(Sprite sprite)
    {
        sprites.add(sprite);
    }
}
