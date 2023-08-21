package extraLarge;

import extraLarge.entities.Life;
import extraLarge.entities.SpecialObject;

public class Relationship {
    SpecialObject obj1;
    SpecialObject obj2;

    int sustain;

    public int getSustain() {
        return sustain;
    }

    public void setSustain(int sustain) {
        this.sustain = sustain;
    }

    public void increaseSustain() {
        this.sustain++;
    }

    public Relationship(SpecialObject obj1, SpecialObject obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void challenge() {

    }

    public void start() {
        obj1.getRelationships().add((Life) obj2);
        obj2.getRelationships().add((Life) obj1);

    }

    public void end() {
        obj1.getRelationships().remove(obj2);
        obj2.getRelationships().remove(obj1);
        obj1.setLove(0);
        obj2.setLove(0);
    }
}
