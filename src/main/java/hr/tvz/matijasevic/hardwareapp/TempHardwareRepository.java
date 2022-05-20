package hr.tvz.matijasevic.hardwareapp;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;

@Repository
public class TempHardwareRepository implements Serializable, HardwareRepository{

    private  List<Hardware> TEMP_HARDWARE_REPOSITORY = new ArrayList<>(Arrays.asList(

            new Hardware("Intel Core i9","ic9-770",615,TypeEnum.valueOf("CPU"),9872),
            new Hardware("NVIDIA GEFORCE RTX 3070","nrtx4-3000",500,TypeEnum.valueOf("GPU"),1000),
            new Hardware("ASUS PRIME TRX40-PRO","sTRX4amd",818,TypeEnum.valueOf("MBU"),7022),
            new Hardware("Corsair Vengeance LPX","ddr4ven",80,TypeEnum.valueOf("RAM"),17897),
            new Hardware("SAMSUNG 970 EVO Plus SSD","nvMe2tb",200,TypeEnum.valueOf("STORAGE"),6320),
            new Hardware("HighPoint SSD6204 PCI-Express 3.0","x8PCI",323,TypeEnum.valueOf("OTHER"),2314)

    ));


    @Override
    public List<Hardware> findAllWithString(String string) {
        return TEMP_HARDWARE_REPOSITORY;
    }
    @Override
    public List<Hardware> findAll() {
        return TEMP_HARDWARE_REPOSITORY;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return TEMP_HARDWARE_REPOSITORY.stream().filter(one -> Objects.equals(one.getCode(),code)).findAny();
    }

    @Override
    public Optional<Hardware> save(HardwareCommand command) {

        Optional<Hardware> optionalHardware = TEMP_HARDWARE_REPOSITORY
                .stream()
                .filter(one -> Objects.equals(one.getCode(),command.getCode())).findAny();

        Optional<Hardware> hardwareTemp = Optional.empty();
        if(optionalHardware.isEmpty()){
            hardwareTemp = Optional.of(new Hardware(command.getName(), command.getCode(),
                    command.getPrice(), command.getType(), command.getCount()));
            TEMP_HARDWARE_REPOSITORY.add(hardwareTemp.get());
        }
        return hardwareTemp;

    }

    @Override
    public int deleteByCode(String code) {
        Optional<Hardware> optionalHardware = TEMP_HARDWARE_REPOSITORY
                .stream()
                .filter(one -> Objects.equals(one.getCode(),code)).findAny();

        optionalHardware.ifPresent(hardware -> TEMP_HARDWARE_REPOSITORY.remove(hardware));

        return 0;
    }
}
