package extraLarge.listSpecial;

public class CustomStringList extends DataList<String> {

    public CustomStringList() {
        super();
    }

    @Override
    public int searchByType(String type, String value) {
        for (String str : elements) {
            if (str.equals(value)) {
                return 1;
            }
        }
        return -1;
    }

}
