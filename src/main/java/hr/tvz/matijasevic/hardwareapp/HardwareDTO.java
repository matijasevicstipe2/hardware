package hr.tvz.matijasevic.hardwareapp;

public class HardwareDTO {
    private String name;
    private Integer price;
    private String code;

    public HardwareDTO(String name, Integer price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
