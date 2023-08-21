package linkedin.profile.controller;

import linkedin.profile.DTO.UserDto;
import linkedin.profile.entity.User;
import linkedin.profile.repository.UserRepository;
import linkedin.profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "showUser/{userId}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable String userId) {
        return userService.getUserInfo(Long.parseLong(userId));

    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
//     for @Controller (auto map to ResponseEntity is not done implicitly)
//    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
//        return new ResponseEntity<>(userService.addOrUpdateUser(userDto), HttpStatus.OK);
//    }
    public UserDto addUser(@RequestBody UserDto userDto) throws NullPointerException {
        System.out.println(userDto);
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new NullPointerException();
        }
        return userService.addOrUpdateUser(userDto, new User());
    }

    @RequestMapping(value = "updateUser/{userId}", method = RequestMethod.POST)
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long userId) {
        return userService.addOrUpdateUser(userDto,userRepository.findById(userId).orElse(new User()));

    }

    @RequestMapping(value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);

    }
}
