package hr.tvz.matijasevic.hardwareapp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hardwares")
public class Hardware implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String code;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    private Integer count;
    @OneToMany(mappedBy = "hardware", fetch = FetchType.EAGER)
    private List<Review> reviews;

    public Hardware(){

    }

    public Hardware(String name, String code, Integer price, TypeEnum type, Integer count) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public Hardware(Long id, String name, String code, Integer price, TypeEnum type, Integer count) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hardware hardware = (Hardware) o;
        return id.equals(hardware.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
