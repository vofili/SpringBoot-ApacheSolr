package com.example.spring_base_google_photo.desigpatterns.ducks;

public class BlueDuck extends Duck {

    String makeSound;

    public BlueDuck(){
        super();
    }
    @Override
    String quack(){
        return makeSound;
    }
}
