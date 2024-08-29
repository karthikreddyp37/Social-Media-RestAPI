package com.karthik.rest.webservices.restful_web_services.hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloworld()
	{
		return "Helloworld";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloworldbean()
	{
		return new HelloWorldBean("Helloworld");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldbeanpathvariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Helloworld, %s",name));
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloworldinternationalized()
	{
		return "Helloworld";
	}
}
