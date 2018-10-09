package khaustau.homeworkFour.space;

import khaustau.homeworkFour.entity.MeteoSat;
import khaustau.homeworkFour.entity.NavSat;
import khaustau.homeworkFour.entity.Satallite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Satallite> succes = new ArrayList();
        List<Satallite> fault = new ArrayList();
        Random rand = new Random();

        LOOP : for (int i = 1; i <= 10; i++) {
            switch (rand.nextInt(2) + 1) {
                case 1 :
                {
                    MeteoSat meteo = new MeteoSat("BelWeatherSat", 12, 2.6);
                    meteo.setName(meteo.counter);
                    while (true) {
                        if (!meteo.launch("Ariane 5")) {
                            meteo.crash();
                            fault.add(meteo);
                            continue LOOP;
                        }
                        if (!meteo.reachDestination()) {
                            meteo.crash();
                            fault.add(meteo);
                            continue LOOP;
                        }
                        meteo.operate();
                        meteo.utilization();
                        System.out.println();
                        succes.add(meteo);
                        continue LOOP;
                    }
                }
                case 2 :
                {
                    NavSat navsat = new NavSat("Galileo", 15, 1.58);
                    navsat.setName(navsat.counter);
                    while (true) {
                        if (!navsat.launch("Souz 2")) {
                            navsat.crash();
                            fault.add(navsat);
                            continue LOOP;
                        }
                        if (!navsat.reachDestination()) {
                            navsat.crash();
                            fault.add(navsat);
                            continue LOOP;
                        }
                        navsat.operate();
                        navsat.utilization();
                        System.out.println();
                        succes.add(navsat);
                        continue LOOP;
                    }
                }
            }
        }

        if (fault.isEmpty() == false) {
            System.out.println("Unsuccessful satellites : ");
            for (Satallite sat : fault) {
                System.out.println(sat.getName() + ", " + sat.getType() + ", mass " +
                        sat.getMass() + ", life time " + sat.getLifeTime());
            }
            System.out.println();
        }

        if (succes.isEmpty() == false) {
            System.out.println("Successful satellites : ");
            for (Satallite sat : succes) {
                System.out.println(sat.getName() + ", " + sat.getType() + ", mass " +
                        sat.getMass() + ", life time " + sat.getLifeTime());
            }
        }
    }
}
