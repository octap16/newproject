package ua.service.implementation;

import java.security.Principal;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.entity.Role;
import ua.entity.User;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUserEmail(username);
	}

	@Override
	public void save(User user) {

		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}

	@PostConstruct
	public void admin() {
		User user = userRepository.findByUserEmail("octap17@gmail.com");
		System.out.println(user);
		if (user == null) {
			user = new User();
			user.setEmail("octap17@gmail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userRepository.save(user);
		}
	}
	@Override
	public User findByUserEmail(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUserEmail(username);
	}
	@Override
	public String getUserId(Principal principal) {

		String name = principal.getName();

		return name;
	}

	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}