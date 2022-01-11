package a.nikolskii.mtdds;

import a.nikolskii.mtdds.entity.User;
import a.nikolskii.mtdds.repository.UserRepository;
import a.nikolskii.mtdds.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MtddsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtddsApplication.class, args);
	}

}
