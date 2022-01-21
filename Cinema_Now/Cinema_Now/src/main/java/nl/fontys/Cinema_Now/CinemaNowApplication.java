package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.converters.UserConverter;
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

			UserDTO user1 = new UserDTO(null,"mari","Maria","Zavaranu","123", "Str. Laleleor nr.4",20, "m.zavaroanu@gmail.com",false, new ArrayList<>(), new ArrayList<>());
			UserDTO user2 = new UserDTO(null,"puyaeboss","Puya","Oancea","123","Str. Logofatul Tautu nr.4",20, "m.zavaroanu@gmail.com",true, new ArrayList<>(), new ArrayList<>());
			UserDTO user3 = new UserDTO(null,"oanceaa","Maria","Oancea","123","Str. Alexandru Vlahuta",20, "m.zavaroanu@gmail.com", false, new ArrayList<>(), new ArrayList<>());

			userService.addUser(user1);
			userService.addUser(user2);
			userService.addUser(user3);

			userService.addRoleToUser(user1.getUsername(), role1.getName());
			userService.addRoleToUser(user2.getUsername(), role1.getName());
			userService.addRoleToUser(user3.getUsername(), role2.getName());

			RoomDTO room1 = new RoomDTO(null,"210", 25);
			RoomDTO room2 = new RoomDTO(null,"211", 25);
			RoomDTO room3 = new RoomDTO(null,"212", 25);
			RoomDTO room4 = new RoomDTO(null,"213", 25);
			RoomDTO room5 = new RoomDTO(null,"214", 25);
			RoomDTO room6 = new RoomDTO(null,"215", 25);

			roomService.createRoom(room1);
			roomService.createRoom(room2);
			roomService.createRoom(room3);
			roomService.createRoom(room4);
			roomService.createRoom(room5);
			roomService.createRoom(room6);

			ProjectionDTO projection1 = new ProjectionDTO(null,"20/01/2022","11:00");
			ProjectionDTO projection2 = new ProjectionDTO(null,"20/01/2022","12:00");
			ProjectionDTO projection3 = new ProjectionDTO(null,"20/01/2022","13:00");
			ProjectionDTO projection4 = new ProjectionDTO(null,"20/01/2022","14:00");
			ProjectionDTO projection5 = new ProjectionDTO(null,"20/01/2022","15:00");
			ProjectionDTO projection6 = new ProjectionDTO(null,"20/01/2022","16:00");
			ProjectionDTO projection7 = new ProjectionDTO(null,"20/01/2022","17:00");
			ProjectionDTO projection8 = new ProjectionDTO(null,"20/01/2022","18:00");


			projectionService.createProjection(projection1);
			projectionService.createProjection(projection2);
			projectionService.createProjection(projection3);
			projectionService.createProjection(projection4);
			projectionService.createProjection(projection5);
			projectionService.createProjection(projection6);
			projectionService.createProjection(projection7);
			projectionService.createProjection(projection8);


		};
	}

}
