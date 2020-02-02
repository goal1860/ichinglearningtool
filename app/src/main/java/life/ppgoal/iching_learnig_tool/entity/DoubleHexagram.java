package life.ppgoal.iching_learnig_tool.entity;

import java.util.List;

public class DoubleHexagram extends  Hexagram {
    private FuxiHexagram topHexgram;
    private FuxiHexagram buttomHexgram;
    private String gramText;
    private List<GramLine> lineList;

    public DoubleHexagram(int index, int presentation, String name, String alias) {
        super(index, presentation, name, alias);
    }

    public FuxiHexagram getTopHexgram() {
        return topHexgram;
    }

    public void setTopHexgram(FuxiHexagram topHexgram) {
        this.topHexgram = topHexgram;
    }

    public FuxiHexagram getButtomHexgram() {
        return buttomHexgram;
    }

    public void setButtomHexgram(FuxiHexagram buttomHexgram) {
        this.buttomHexgram = buttomHexgram;
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
