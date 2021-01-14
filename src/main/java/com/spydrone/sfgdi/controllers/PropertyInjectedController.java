package com.spydrone.sfgdi.controllers;

import com.spydrone.sfgdi.services.GreetingService;

public class PropertyInjectedController {

	public GreetingService greetingService;

	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
