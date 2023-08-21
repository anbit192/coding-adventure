package extraLarge.spaces;

import extraLarge.Vulnerability;
import extraLarge.entities.Ghost;
import extraLarge.entities.Life;
import extraLarge.Relationship;
import extraLarge.Rule;
import extraLarge.entities.SpecialObject;
import extraLarge.listSpecial.ObjectsList;
import extraLarge.listSpecial.RulesList;

import java.util.ArrayList;

public class World {
    private ObjectsList objects;
    private RulesList rules;
    private River river;
    private Vulnerability vulnerability;

    public Vulnerability getVulnerability() {
        return vulnerability;
    }

    public River getRiver() {
        return river;
    }

    public ObjectsList getObjects() {
        return objects;
    }

    public void giveBestAward(String attribute, SpecialObject object) {

    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void sendMessage(String msg, SpecialObject object) {
        System.out.println(msg);
    }

    public Relationship getRelationship(SpecialObject obj1, SpecialObject obj2) {
        for (SpecialObject obj : obj1.getRelationships().getElements()) {
            if (obj.getNickname().equalsIgnoreCase(obj2.getNickname())) {
                return new Relationship(obj1, obj2);
            }
        }

        return null;
    }

    public Relationship setRelationship(Life object1, Life object2, String state) {
        if (state.equalsIgnoreCase("null")) {
            this.getRelationship(object1, object2).end();
        }
        return this.getRelationship(object1, object2);
    }

    public void execute(Life object) {
    }

    public void mute(Life object, String[] tags) {

    }

    public ArrayList<Life> getLifeTopOnePercent() {
        return this.objects.getElements();
    }

    public void addPollution(String space, String behaviour, Life object) {

    }

    public Ghost[] search(Life object, String kind) {
        return null;
    }
}
