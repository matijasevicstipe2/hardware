package hr.tvz.matijasevic.hardwareapp;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class HardwareCommand {

    private long id;
    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    private String code;

    @NotNull(message = "Price must be entered")
    @PositiveOrZero(message = "Price must be postive number")
    @Max(message = "Highest price must be 1000 dollars", value = 10000)
    private Integer price;

    @NotNull(message = "Type must not be empty")
    private TypeEnum type;

    @PositiveOrZero(message = "Count must be positive number")
    @Max(message = "Highest count must be 20 000", value = 20000)
    private Integer count;

    public HardwareCommand(long id, String name, String code, Integer price, TypeEnum type, Integer count) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
