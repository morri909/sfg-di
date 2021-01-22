package com.spydrone.sfgdi.config;

import com.spydrone.sfgdi.examplebeans.FakeDataSource;
import com.spydrone.sfgdi.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

	@Value("${spydrone.username}")
	String user;
	@Value("${spydrone.password}")
	String password;
	@Value("${spydrone.dburl}")
	String url;
	@Value("${spydrone.jms.username}")
	String jmsUser;
	@Value("${spydrone.jms.password}")
	String jmsPassword;
	@Value("${spydrone.jms.dburl}")
	String jmsUrl;

	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		return fakeDataSource;
	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUser(jmsUser);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setUrl(jmsUrl);
		return fakeJmsBroker;
	}

}
