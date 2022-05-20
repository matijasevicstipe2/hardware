package hr.tvz.matijasevic.hardwareapp;

public class ReviewDTO {
    private String title;
    private int evaluation;
    private String info;


    public ReviewDTO(String title, int evaluation, String info) {
        this.title = title;
        this.evaluation = evaluation;
        this.info = info;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
