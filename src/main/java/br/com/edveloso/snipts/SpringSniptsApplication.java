package br.com.edveloso.snipts;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.edveloso.snipts.model.User;
import br.com.edveloso.snipts.repository.UserRepository;

@EnableWebMvc
@SpringBootApplication
public class SpringSniptsApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SpringSniptsApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository userRepo) {
		return (args) -> {
//			inserteUsers(userRepo);
//			findUser(userRepo);
//			listUsers(userRepo);
		};
	}

	private void listUsers(UserRepository userRepo) {
		List<User> users = userRepo.findByLastnameOrEmailAddress("da Silva", "maria@bol");
		users.stream()
				.forEach(user -> System.out.println(user));
	}

	private void findUser(UserRepository userRepo) {
		User user = userRepo.findByEmailAddress("jose@bol");
		System.out.println(user);
	}

	private void inserteUsers(UserRepository userRepo) {
		User usuario = null;
			usuario = new User("jose", "bandeiras", "maria@bol");
		userRepo.save(usuario );
		usuario = new User("maria", "da Silva", "maria@bol");
		userRepo.save(usuario );
		usuario = new User("antonio", "da Silva", "antonio@bol");
		userRepo.save(usuario );
	}

}
