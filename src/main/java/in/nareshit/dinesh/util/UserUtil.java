package in.nareshit.dinesh.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

// UUID :  Universal Unique IDentifier : UUID (String)


@Component
public class UserUtil {

	public String genPwd() {
		return UUID.randomUUID()
				.toString()
				.replace("-","")
				.substring(0, 8);
	}
}
 