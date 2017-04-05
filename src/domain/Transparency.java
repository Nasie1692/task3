package domain;

public class Transparency extends VisualParameters {
    private int transparencyPersent;

    public Transparency() {
        super("Прозрачность");
    }

    @Override
    public void setValue(String value) {
        transparencyPersent = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(transparencyPersent) + "%";
    }

}
