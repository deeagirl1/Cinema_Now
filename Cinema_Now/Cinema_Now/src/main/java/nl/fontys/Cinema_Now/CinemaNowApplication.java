package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.DTO.NewsDTO;
import nl.fontys.Cinema_Now.DTO.RoomDTO;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Enums.Format;
import nl.fontys.Cinema_Now.Model.Enums.Genre;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.Role;
import nl.fontys.Cinema_Now.Repository.UserDALJPA;
import nl.fontys.Cinema_Now.Service.MovieService;
import nl.fontys.Cinema_Now.Service.NewsService;
import nl.fontys.Cinema_Now.Service.RoomService;
import nl.fontys.Cinema_Now.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.UUID;


@SpringBootApplication
public class CinemaNowApplication {

	@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaNowApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, MovieService movieService, RoomService roomService, NewsService newsService){
		return args -> {

				Role role1 = new Role(null, "ROLE_USER");
				Role role2 = new Role(null,"ROLE_ADMIN");

			userService.saveRole(role1);
			userService.saveRole(role2);

				UserDTO user1 = new UserDTO("1","mari","Maria","Zavaranu","123", "m.zavaroanu@gmail.com");
				UserDTO user2 = new UserDTO("2","puyaeboss","Puya","Oancea","123", "m.zavaroanu@gmail.com");
				UserDTO user3 = new UserDTO("3","oanceaa","Maria","Oancea","123", "m.zavaroanu@gmail.com");
			userService.addUser(user1);
			userService.addUser(user2);
			userService.addUser(user3);

			userService.addRoleToUser(user1.getUsername(), role1.getName());
			userService.addRoleToUser(user3.getUsername(), role2.getName());
			movieService.addMovie(new MovieDTO("Cars",Genre.ANIMATION.toString(),180 , "26/06/2021","test",Format._4DX.toString(),"test"));

			newsService.createNewPost(new NewsDTO("test","test","26/05/2021"));

		};
	}

}
