package khaustau.homeworkFour.space.entity;

public class Falcon extends LaunchVechicle {

    public Falcon() {
        name = "Falcon 9";
        stagesNumber = 2;
        isReturnable = true;

        boostSeconds = new int[stagesNumber];
        boostSeconds[0] = 270;
        boostSeconds[1] = 10000;

        boostBackSeconds = new int[2];
        boostBackSeconds[0] = 3;
        boostBackSeconds[1] = 10;
    }

    @Override
    public void landing() {
        super.engineStartup(1, boostBackSeconds[0], "boosback");
        super.engineShutdown(1);

        super.engineStartup(1, boostBackSeconds[1],"landind");
        System.out.println("Stage 1 succesfully landed");
        super.engineShutdown(1);
        status = "Landed";
    }
}
