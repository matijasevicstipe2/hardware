package hr.tvz.matijasevic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAllWithString(String string);
    List<HardwareDTO> findAll();
    Optional<HardwareDTO> findByCode(String code);
    Optional<HardwareDTO> save(HardwareCommand command);
    void deleteByCode(String code);
}
