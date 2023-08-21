package extraLarge.listSpecial;

import extraLarge.entities.Life;
import extraLarge.entities.SpecialObject;

public class ObjectsList extends DataList<Life> {

    public ObjectsList() {
    }

    public void remove(SpecialObject object) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getNickname().equalsIgnoreCase(object.getNickname())) {
                elements.remove(i);
            }
        }
    }

    @Override
    public int searchByType(Life type, Life value) {
        return 0;
    }

    public void sortByAttribute(String attribute) {
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 1; j < elements.size(); j++) {
                if (Double.compare(elements.get(j).getAttributes().get(attribute),
                        elements.get(j - 1).getAttributes().get(attribute)) < 0) {
                    Life temp = elements.get(j);
                    elements.set(j, elements.get(j - 1));
                    elements.set(j - 1, temp);
                }
            }
        }
    }

    public SpecialObject getFirst() {
        if (elements.size() == 0) {
            return null;
        }
        return elements.get(0);
    }
}
