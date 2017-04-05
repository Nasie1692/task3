package domain;

public class GemColour extends VisualParameters {
    private String colour;

    public GemColour() {
        super("Цвет");
    }

    @Override
    public void setValue(String value) {
        colour = value;
    }

    @Override
    public String getValue() {
        return colour;
    }

}
