package com.example.spring_base_google_photo.desigpatterns.ducks;

public class Duck {

    public Duck(){

    }


    String duckFly;
    String duckSound;
    String duckSwim;
    String duckDisplay;

    String quack(){
             this.duckSound="Quack";
             return this.duckSound;
    }
    String swim(){
        this.duckSwim="Swim";
        return this.duckSwim;
    }
    String display(){

        this.duckDisplay="Display";
        return this.duckDisplay;
    }

    String fly(){
        duckFly = "Fly";
        return this.duckFly;
    }

}
