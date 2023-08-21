package linkedin.profile.controller;

import linkedin.profile.DTO.UserDto;
import linkedin.profile.Mapper.UserMapper;
import linkedin.profile.entity.User;
import linkedin.profile.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import linkedin.profile.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDto checkUser(@RequestBody UserDto userDto) throws NullPointerException{
        System.out.println(userDto);
        User user1 = userRepository.findByEmail(userDto.getEmail()).orElse(null);
        if (user1 != null && userDto.getEmail().equals(user1.getEmail()) && userDto.getPassword().equals(user1.getPassword())) {
            return userMapper.toUserDto(user1);
        }
        throw new NullPointerException();
    }
}
