package org.lava.trender.model;

import java.util.ArrayList;
import java.util.List;

public class Block
{
    private boolean solidRender;
    private boolean solidMotion;
    private List<Sprite> sprites;
    private int texture;
    private int colour;
    private int ceilingTexture;
    private int ceilingColour;
    private int floorTexture;
    private int floorColour;

    private Block(BlockBuilder builder)
    {
        this.solidRender = builder.solidRender;
        this.solidMotion = builder.solidMotion;
        this.sprites = builder.sprites;
        this.texture = builder.texture;
        this.colour = builder.colour;
        this.ceilingTexture = builder.ceilingTexture;
        this.ceilingColour = builder.ceilingColour;
        this.floorTexture = builder.floorTexture;
        this.floorColour = builder.floorColour;
    }

    public static class BlockBuilder
    {
        private boolean solidRender = false;
        private boolean solidMotion = false;
        private List<Sprite> sprites = new ArrayList<Sprite>();
        private int texture = 0;
        private int colour = 0x555555;
        private int ceilingTexture = 0;
        private int ceilingColour = 0x555555;
        private int floorTexture = 0;
        private int floorColour = 0x555555;

        public BlockBuilder setSolidRender(boolean solidRender)
        {
            this.solidRender = solidRender;
            return this;
        }

        public BlockBuilder setSolidMotion(boolean solidMotion)
        {
            this.solidMotion = solidMotion;
            return this;
        }

        public BlockBuilder addSprite(Sprite sprite)
        {
            sprites.add(sprite);
            return this;
        }

        public BlockBuilder setTexture(int texture)
        {
            this.texture = texture;
            return this;
        }

        public BlockBuilder setColour(int colour)
        {
            this.colour = colour;
            return this;
        }

        public BlockBuilder setCeilingTexture(int ceilingTexture)
        {
            this.ceilingTexture = ceilingTexture;
            return this;
        }

        public BlockBuilder setCeilingColour(int ceilingColour)
        {
            this.ceilingColour = ceilingColour;
            return this;
        }

        public BlockBuilder setFloorTexture(int floorTexture)
        {
            this.floorTexture = floorTexture;
            return this;
        }

        public BlockBuilder setFloorColour(int floorColour)
        {
            this.floorColour = floorColour;
            return this;
        }

        public Block build()
        {
            return new Block(this);
        }
    }

    public boolean isSolidRender()
    {
        return solidRender;
    }

    public boolean isSolidMotion()
    {
        return solidMotion;
    }

    public List<Sprite> getSprites()
    {
        return sprites;
    }

    public int getTexture()
    {
        return texture;
    }

    public int getColour()
    {
        return colour;
    }

    public int getCeilingTexture()
    {
        return ceilingTexture;
    }

    public int getCeilingColour()
    {
        return ceilingColour;
    }

    public int getFloorTexture()
    {
        return floorTexture;
    }

    public int getFloorColour()
    {
        return floorColour;
    }
}