package com.example.deepak.prototype2;

public class Product {

    private int id;
    private String title;
    private String timestamp;
    private String timeDuration;
    private String steps, calories;
    private int image;
    private int imageTravel;

    public Product(int id, String title, String timestamp, String timeDuration, String steps, String calories, int image, int imageTravel) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.timeDuration = timeDuration;
        this.steps = steps;
        this.calories = calories;
        this.image = image;
        this.imageTravel = imageTravel;
    }

    public Product(int id, String title, String timestamp, String timeDuration, String steps, String calories, int image) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.timeDuration = timeDuration;
        this.steps = steps;
        this.calories = calories;
        this.image = image;
        this.imageTravel = -1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public String getSteps() {
        return steps;
    }

    public String getCalories() {
        return calories;
    }

    public int getImage() {
        return image;
    }

    public int getImageTravel()
    {
        return  imageTravel;
    }
}
