package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDTO entityToDto(User user)
    {

        ModelMapper mapper = new ModelMapper();
        UserDTO dto = mapper.map(user,UserDTO.class);

        return dto;

    }
    public List<UserDTO> entityToDto(List<User> users)
    {
        return users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public User dtoToEntity(UserDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        User entity = mapper.map(dto,User.class);

        return entity;

    }
    public List<User> dtoToEntity(List<UserDTO> userDTOS)
    {
        return userDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
