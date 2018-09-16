package com.example.deepak.prototype2;

public class StepsCard {
    private int id;
    private int type;
    private String count;
    private int image;
    private int image_small;

    public StepsCard(int id,int type, String count) {
        this.id = id;
        this.type = type;
        this.count = count;

        if(type == 1)
        {
            this.image = R.drawable.steps;
            this.image_small = R.drawable.shoes;
        }
        else if(type==2)
        {
            this.image = R.drawable.calories_heart;
            this.image_small = R.drawable.flame;
        }
    }

    public int getId() {
        return id;
    }

    public String getCount() {
        return count;
    }

    public int getImage() {
        return image;
    }

    public int getType(){
        return type;
    }

    public int getImage_small()
    {
        return image_small;
    }
}
