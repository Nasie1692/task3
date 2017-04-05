package domain;

import java.util.HashSet;
import java.util.Set;

public class Gem {
    private String id;
    private String name;
    private PreciousType preciousness;
    private String origin;
    private double value;
    private Set<VisualParameters> parameters = new HashSet<VisualParameters>();

    public String getIdentity() {
        return id;
    }

    public void setIdentity(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreciousness() {
        return preciousness.toString();
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = PreciousType.valueOf(preciousness);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Set<VisualParameters> getParameters() {
        return parameters;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(getIdentity()).append('\n');
        builder.append("Название: ").append(getName()).append('\n');
        builder.append("Степень драгоценности: ").append(getPreciousness()).append('\n');
        builder.append("Место добычи: ").append(getOrigin()).append('\n');
        for (VisualParameters parameter : getParameters()) {
            builder.append(parameter.getName()).append(": ").append(parameter.getValue()).append('\n');
        }
        builder.append("Размер: ").append(getValue()).append(" карат\n");
        return builder.toString();
    }

}
