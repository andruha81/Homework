package khaustau.homeworkFour.space;

import khaustau.homeworkFour.space.entity.Ariane;
import khaustau.homeworkFour.space.entity.Falcon;
import khaustau.homeworkFour.space.entity.LaunchVechicle;

public class Main {

    public static void main(String[] args) {
        LaunchVechicle falcon;
        LaunchVechicle ariane;

        ariane = new Ariane();
        ariane.production();
        ariane.launching();
        ariane.landing();

        falcon = new Falcon();
        falcon.production();
        falcon.testing();
        falcon.launching();
        falcon.landing();
    }
}
