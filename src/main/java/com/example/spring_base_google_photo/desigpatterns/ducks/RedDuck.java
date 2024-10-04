package com.example.spring_base_google_photo.desigpatterns.ducks;

public class RedDuck extends Duck{

    String makeSound;
    public RedDuck(){

    }

    @Override
    String quack(){
        return makeSound;
    }
}
