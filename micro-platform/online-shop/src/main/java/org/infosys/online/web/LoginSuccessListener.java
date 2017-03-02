package org.infosys.online.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	private HttpSession session;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		
		

	}

}
