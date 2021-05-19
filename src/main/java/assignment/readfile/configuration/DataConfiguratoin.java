package assignment.readfile.configuration;


import org.springframework.context.annotation.Configuration;

import assignment.readfile.service.DataService;
import assignment.readfile.service.DataServiceImpl;



@Configuration
public class DataConfiguratoin {

	//@Bean
	public DataService getDataService() {
		return new DataServiceImpl();
	}

}
