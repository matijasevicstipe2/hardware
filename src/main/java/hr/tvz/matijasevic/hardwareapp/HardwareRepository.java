package hr.tvz.matijasevic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();
    List<Hardware> findAllWithString(String string);
    Optional<Hardware>  findByCode(String code);
    Optional<Hardware> save(HardwareCommand command);
    int deleteByCode(String code);

}
