package life.ppgoal.iching_learnig_tool.entity;

public class GramLine {
    private boolean positive;
    private String lineText;
    private String xiangText;

    public String getXiangText() {
        return xiangText;
    }

    public void setXiangText(String xiangText) {
        this.xiangText = xiangText;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public String getLineText() {
        return lineText;
    }

    public void setLineText(String lineText) {
        this.lineText = lineText;
    }
}
