package hr.tvz.matijasevic.hardwareapp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;
    private String title;
    private String info;
    private int evaluation;
    @ManyToOne
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    public Review(){

    }

    public Review(Long id, String title, String info, int evaluation, Hardware hardware) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.evaluation = evaluation;
        this.hardware = hardware;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
