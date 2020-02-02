package life.ppgoal.iching_learnig_tool.entity;

public class Hexagram {
    private int index;
    private int presentation;
    private String name;
    private String alias;

    public Hexagram(int index, int presentation, String name, String alias) {
        this.index = index;
        this.presentation = presentation;
        this.name = name;
        this.alias = alias;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPresentation() {
        return presentation;
    }

    public void setPresentation(int presentation) {
        this.presentation = presentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
