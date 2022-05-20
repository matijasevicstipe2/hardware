package hr.tvz.matijasevic.hardwareapp;

public enum TypeEnum {
    /*CPU, GPU, MBO, RAM,
    STORAGE ili OTHER*/
    CPU("CPU"),
    GPU("GPU"),
    MBU("MBU"),
    RAM("RAM"),
    STORAGE("STORAGE"),
    OTHER("OTHER");
    private String type;
    TypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
