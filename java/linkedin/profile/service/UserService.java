package linkedin.profile.service;

import linkedin.profile.DTO.UserDto;
import linkedin.profile.Mapper.UserMapper;
import linkedin.profile.entity.User;
import linkedin.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    public UserDto getUserInfo(Long userId) {
        System.out.println(userId);
        UserDto userDto = userMapper.toUserDto(userRepository.findById(userId).orElseThrow());
        return userDto;
    }

    public UserDto addOrUpdateUser(UserDto userDto, User user) {
        System.out.println(userDto);
        user = userMapper.toUserEntity(userDto, user);
        userRepository.save(user);
        System.out.println(user + " User");
        return userMapper.toUserDto(user);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
