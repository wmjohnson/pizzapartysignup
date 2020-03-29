package org.pizzaparty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class PizzaPartySignUpApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaPartySignUpApplication.class, args);
	}

	@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAsyncExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setCorePoolSize(20);

		executor.setMaxPoolSize(1000);

		executor.setWaitForTasksToCompleteOnShutdown(true);

		executor.setThreadNamePrefix("Async-");

		return executor;

	}
}
