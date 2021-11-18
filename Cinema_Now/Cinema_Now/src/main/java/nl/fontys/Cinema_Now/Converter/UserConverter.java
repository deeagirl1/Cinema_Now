package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDTO entityToDto(AppUser appUser)
    {

        ModelMapper mapper = new ModelMapper();
        UserDTO dto = mapper.map(appUser,UserDTO.class);

        return dto;

    }
    public List<UserDTO> entityToDto(List<AppUser> appUsers)
    {
        return appUsers.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public AppUser dtoToEntity(UserDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        AppUser entity = mapper.map(dto, AppUser.class);

        return entity;

    }
    public List<AppUser> dtoToEntity(List<UserDTO> userDTOS)
    {
        return userDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
