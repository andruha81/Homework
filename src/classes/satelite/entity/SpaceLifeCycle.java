package classes.satelite.entity;

public interface SpaceLifeCycle {
    boolean launch(String launchVechicle);
    boolean reachDestination();
    void operate();
    void utilization();
    void crash();
}
