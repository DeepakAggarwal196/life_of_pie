package com.example.deepak.prototype2;

public class Product {

    private int id;
    private String title;
    private String timestamp;
    private String timeDuration;
    private int steps, calories;
    private int image;

    public Product(int id, String title, String timestamp, String timeDuration, int steps, int calories, int image) {
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.timeDuration = timeDuration;
        this.steps = steps;
        this.calories = calories;
        this.image = image;
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

    public int getSteps() {
        return steps;
    }

    public int getCalories() {
        return calories;
    }

    public int getImage() {
        return image;
    }
}
