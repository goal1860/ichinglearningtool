package life.ppgoal.iching_learnig_tool.entity;

import java.util.List;

public class DoubleHexagram extends  Hexagram {
    private FuxiHexagram topHexagram;
    private FuxiHexagram buttomHexagram;
    private String gramText;
    private List<GramLine> lineList;

    public DoubleHexagram(int index, int presentation, String name, String alias, String gramText) {
        super(index, presentation, name, alias);
        this.gramText = gramText;
    }

    public FuxiHexagram getTopHexagram() {
        return topHexagram;
    }

    public void setTopHexagram(FuxiHexagram topHexagram) {
        this.topHexagram = topHexagram;
    }

    public FuxiHexagram getButtomHexagram() {
        return buttomHexagram;
    }

    public void setButtomHexagram(FuxiHexagram buttomHexagram) {
        this.buttomHexagram = buttomHexagram;
    }

    public String getGramText() {
        return gramText;
    }

    public void setGramText(String gramText) {
        this.gramText = gramText;
    }

    public List<GramLine> getLineList() {
        return lineList;
    }

    public void setLineList(List<GramLine> lineList) {
        this.lineList = lineList;
    }
}
