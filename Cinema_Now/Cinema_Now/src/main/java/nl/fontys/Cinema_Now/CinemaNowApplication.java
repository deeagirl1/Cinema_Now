package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.converters.UserConverter;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.service.*;
import nl.fontys.Cinema_Now.dto.*;
import nl.fontys.Cinema_Now.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


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
	CommandLineRunner run(UserService userService, UserConverter converter, MovieService movieService, RoomService roomService, NewsService newsService, ProjectionService projectionService){
		return args -> {

				Role role1 = new Role(null, "ROLE_USER");
				Role role2 = new Role(null,"ROLE_ADMIN");

			userService.saveRole(role1);
			userService.saveRole(role2);

				UserDTO user1 = new UserDTO(null,"mari","Maria","Zavaranu","123", "some address", "m.zavaroanu@gmail.com",false, new ArrayList<>(), new ArrayList<>());
				UserDTO user2 = new UserDTO(null,"puyaeboss","Puya","Oancea","123","some address", "m.zavaroanu@gmail.com",true, new ArrayList<>(), new ArrayList<>());
				UserDTO user3 = new UserDTO(null,"oanceaa","Maria","Oancea","123","some address", "m.zavaroanu@gmail.com", false, new ArrayList<>(), new ArrayList<>());


			userService.addUser(user1);
			userService.addUser(user2);
			userService.addUser(user3);



			userService.addRoleToUser(user1.getUsername(), role1.getName());
			userService.addRoleToUser(user2.getUsername(), role1.getName());
			userService.addRoleToUser(user3.getUsername(), role2.getName());



//			RoomDTO roomDTO = new RoomDTO(null,"test",20,new ArrayList<>());
//			roomService.createRoom(roomDTO);

//			MovieDTO movie1 = new MovieDTO(null,"Cars", Genre.ANIMATION,180 , "26/06/2021","test", Format._4DX,"test");
//
//			movieService.addMovie(movie1);
//
//			roomService.addRoomToMovie(roomDTO.getName(),movie1.getName());





			NewsDTO news = new NewsDTO(null,"test","test","26/05/2021");
			newsService.createNewPost(news);


		};
	}

}
