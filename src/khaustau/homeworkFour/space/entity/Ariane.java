package khaustau.homeworkFour.space.entity;

public class Ariane extends LaunchVechicle {

    public Ariane() {
        name = "Ariane 5";
        stagesNumber = 3;
        isReturnable = false;

        boostSeconds = new int[stagesNumber];
        boostSeconds[0] = 300;
        boostSeconds[1] = 5000;
        boostSeconds[2] = 1200;
    }

    @Override
    public void production() {
        status = "Produced";
        isReadyForLaunch = true;
        System.out.println(name + " is produced and ready for launch");
    }
}
