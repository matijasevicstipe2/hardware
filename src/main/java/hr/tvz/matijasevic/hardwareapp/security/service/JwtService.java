package hr.tvz.matijasevic.hardwareapp.security.service;


import hr.tvz.matijasevic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
