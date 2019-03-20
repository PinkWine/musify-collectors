package dev.cstv.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GatewayMain {

	private final static String[] configFilesGatewayDemo = { "/META-INF/spring/common.xml",

			"/META-INF/spring/songCollectorGateway.xml" };

	public static void main(String[] args) {

	//	final Scanner scanner = new Scanner(System.in);

//	    RouteOrderGateway orderGateway;

		System.out.println("    Loading songCollectorGateway...");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFilesGatewayDemo, GatewayMain.class);

		applicationContext.getBean(GatewayMain.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) {
		// Wait for Messages
	}

}
