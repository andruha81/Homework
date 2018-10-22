package classes.satelite.entity;

import java.util.Random;

public class Satallite implements SpaceLifeCycle {
    protected String name;              //название спутника
    protected String type;              //тип спутника
    protected int lifeTime;             //срок действия
    protected double mass;              //масса
    protected boolean isWorking;        //эксплуатируется или нет
    Random rand = new Random();

    public Satallite(String name, int lifeTime, double mass) {
        this.name = name;
        this.lifeTime = lifeTime;
        this.mass = mass;
    }

    public void setName(int counter) {
        this.name += counter;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public double getMass() {
        return mass;
    }

    /*
    * запуск спутника на указанной ракете
    * проверка вероятности 1 к 10 аварии спутника
    * возврат false в случае аварии, если все в порядке true
     */
    @Override
    public boolean launch(String launchVechicle) {
        System.out.println(this.name + " is launched on " + launchVechicle);

        if (rand.nextInt(10) == 1) {
            return false;
        } else {
            return true;
        }
    }

    /*
    * включение двигателей
     */
    private void engineStartup() {
        System.out.println(this.name + " engine startup");
    }

    /*
    * выключение двигателей
     */
    private void engineShutdown() {
        System.out.println(this.name + " engine shutdown");
    }

    /*
    * переход к месту эксплуатации после запуска
    * проверка вероятности 1 к 10 аварии спутника
    * возврат false в случае аварии, если все в порядке true
     */
    @Override
    public boolean reachDestination() {
        this.engineStartup();

        if (rand.nextInt(10) == 1) {
            return false;
        }

        this.engineShutdown();

        System.out.println(this.name + " reached its destination");
        isWorking = true;
        return true;
    }

    /*
    * выполнение заданных функций, определяется в классах child
     */
    @Override
    public void operate() {
        System.out.println("sendind some data to earth");
    }

    /*
    * утилизация спутника после окончания срока
     */
    @Override
    public void utilization() {
        this.engineStartup();
        System.out.println(name + " is out of service");
        isWorking = false;
    }

    /*
    * авария спутника
     */
    @Override
    public void crash() {
        System.out.println(name + " is crashed and out of service");
        isWorking = false;
        System.out.println();
    }
}
