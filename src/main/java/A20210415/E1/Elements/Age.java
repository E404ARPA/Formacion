package A20210415.E1.Elements;

import A20210415.E1.DataElement;

import java.util.List;

public class Age implements DataElement {
    @Override
    public String extract(List<String> elements) {
        return elements.get(2);
    }
}
