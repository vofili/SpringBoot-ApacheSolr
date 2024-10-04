package com.example.spring_base_google_photo.desigpatterns.ducks;

public class RubberDuck extends Duck {
    String duckSound;
    public RubberDuck(){

    }
    @Override
    String quack(){
        this.duckSound = "squeak";
        return this.duckSound;
    }
}
