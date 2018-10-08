package khaustau.homeworkFour.space.entity;

public class LaunchVechicle implements LifeCycle{
    protected String name;
    protected int stagesNumber;
    protected int missionsNumber = 0;
    protected String status = "Under producing";
    protected boolean isReturnable;
    protected boolean isReadyForLaunch  = false;
    protected int counter;
    protected int[] boostSeconds;
    protected int[] boostBackSeconds;

    @Override
    public void production() {
        this.status = "Produced";
        System.out.println(name + " is produced");
    }

    @Override
    public void testing() {
        this.status = "Tested";
        this.isReadyForLaunch = true;
        System.out.println(name + " is ready for launch");
    }

    protected void engineStartup(int stageNum, int seconds) {
        System.out.println("Stage " + stageNum + " engines startup for " + seconds + " seconds");
    }

    protected void engineStartup(int stageNum, int seconds, String strBack) {
        System.out.println("Stage " + stageNum + " engines " + strBack + " startup for " + seconds + " seconds");
    }

    protected void engineShutdown(int stageNum) {
        System.out.println("Stage " + stageNum + " engines shutdown");
    }

    protected void separation(int stageEnd, int stageBegin) {
        System.out.println("separation between stages " + stageEnd + " and " + stageBegin + " completed");
    }

    protected void separation(int stageEnd) {
        System.out.println(" separation of payload completed");
    }

    @Override
    public void launching() {
        System.out.println(name + " is launching");
        for (int i = 1; i <= this.stagesNumber; i++) {
            engineStartup(i, boostSeconds[i-1]);
            engineShutdown(i);

            if ( i < this.stagesNumber) {
                separation(i, i + 1);
            } else {
                separation(i);
            }
        }
    }

    @Override
    public void landing() {
        System.out.println("Stage 1 felt into the ocean");
        this.status = "Retired";
        this.missionsNumber += 1;
    }

    @Override
    public void refurbishment() {
        this.status = "Refurbished";
    }

    @Override
    public void utilization() {
        this.status = "Retired";
    }
}
