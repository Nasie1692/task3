package domain;

public class Facets extends VisualParameters {
    private int facetCount;

    public Facets() {
        super("Количество граней");
    }

    @Override
    public void setValue(String value) {
        facetCount = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(facetCount);
    }

}
