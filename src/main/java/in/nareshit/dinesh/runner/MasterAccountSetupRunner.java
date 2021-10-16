package in.nareshit.dinesh.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.nareshit.dinesh.constants.UserRoles;
import in.nareshit.dinesh.entity.User;
import in.nareshit.dinesh.service.IUserService;
import in.nareshit.dinesh.util.UserUtil;

@Component
public class MasterAccountSetupRunner implements CommandLineRunner {

	@Value("${master.user.name}")
	private String displayName;
	
	@Value("${master.user.email}")
	private String username;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserUtil userUtil;
	
	public void run(String... args) throws Exception {
		if(!userService.findByUsername(username).isPresent()) {
			User user = new User();
			user.setDisplayName(displayName);
			user.setUsername(username);
			user.setPassword(userUtil.genPwd());
			user.setRole(UserRoles.ADMIN.name());
			userService.saveUser(user);
			//TODO : EMAIL SERVICE
		}
	}	

}
