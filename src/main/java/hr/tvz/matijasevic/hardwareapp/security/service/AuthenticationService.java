package hr.tvz.matijasevic.hardwareapp.security.service;



import hr.tvz.matijasevic.hardwareapp.security.command.LoginCommand;
import hr.tvz.matijasevic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
