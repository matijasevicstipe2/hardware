package hr.tvz.matijasevic.hardwareapp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements Serializable,HardwareService{

    private HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository){
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAllWithString(String string) {
        return hardwareRepository.findAllWithString(string).stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(this::mapHardwareToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {
        return hardwareRepository.findByCode(code).map(this::mapHardwareToDTO);
    }

    @Override
    public Optional<HardwareDTO> save(HardwareCommand command) {
        return hardwareRepository.save(command).map(this::mapHardwareToDTO);
    }

    @Override
    public void deleteByCode(String code) {
        hardwareRepository.deleteByCode(code);
    }


    private HardwareDTO mapHardwareToDTO(Hardware hardware){
        return new HardwareDTO(hardware.getName(),hardware.getPrice(),hardware.getCode());
    }


}
