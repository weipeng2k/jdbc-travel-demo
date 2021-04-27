package com.murdock.demo.jdbc.travel.demo;

import com.murdock.demo.jdbc.travel.demo.dao.UserDAO;
import com.murdock.demo.jdbc.travel.demo.dao.dataobject.UserDO;
import com.murdock.demo.jdbc.travel.demo.gen.IntGen;
import com.murdock.demo.jdbc.travel.demo.gen.StringGen;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.IntStream;

@SpringBootApplication
public class JdbcTravelDemoApplication implements CommandLineRunner {

	private final UserDAO userDAO;
	private final IntGen intGen;
	private final StringGen stringGen;

	public JdbcTravelDemoApplication(UserDAO userDAO, IntGen intGen, StringGen stringGen) {
		this.userDAO = userDAO;
		this.intGen = intGen;
		this.stringGen = stringGen;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcTravelDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		int sum = IntStream.range(0, 1_000_000).parallel()
				.peek(i -> {
					if (i % 1000 == 0) {
						System.out.println(i);
					}
				})
				.map(i -> {
					UserDO userDO = new UserDO();
					userDO.setAge(intGen.gen(18, 35));
					userDO.setEmail(stringGen.gen("email"));
					userDO.setDingTalkNo(stringGen.gen("ding"));
					userDO.setUserName(stringGen.gen("userName"));
					userDO.setLevel(intGen.gen(1, 15));
					userDO.setLevelType(stringGen.gen("M", "P"));
					userDO.setNickName(stringGen.gen("nickName"));
					userDO.setPhoneNum(stringGen.gen("p"));
					userDO.setWorkNum(stringGen.gen("w"));
					userDO.setSex(intGen.gen(0, 2));
					userDO.setType(intGen.gen(1, 10));

					return userDAO.insetUser(userDO);
				})
				.sum();
		System.out.println(sum);
	}
}
