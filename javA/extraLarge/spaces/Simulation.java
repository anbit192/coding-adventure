package extraLarge.spaces;

import extraLarge.entities.Life;

public class Simulation {
    Life object;
    World world;
    int year;
    int number;

    public Simulation(Life object, World world, int year, int number) {
        this.object = object;
        this.world = world;
        this.year = year;
        this.number = number;
    }

    public int compareToOriginal(Life object) {
        if (this.object == object) {
            return 100;
        }

        return 0;
    }
}
