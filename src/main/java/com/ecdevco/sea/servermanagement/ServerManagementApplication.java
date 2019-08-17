package com.ecdevco.sea.servermanagement;

import com.ecdevco.sea.servermanagement.util.SNMPManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ServerManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServerManagementApplication.class, args);
	}

	@Bean
	public SNMPManager snmpManager(){
		return new SNMPManager("198.143.182.68/161");
	}
}
