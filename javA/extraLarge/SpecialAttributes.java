package extraLarge;

import java.util.HashMap;
import java.util.Map;

public abstract class SpecialAttributes {
    protected Map<String, Double> attributes;

    public SpecialAttributes() {
        attributes = new HashMap<>();
        attributes.put("beauty", 0.0);
    }

    public Map<String, Double> getAttributes() {
        return attributes;
    }
}
