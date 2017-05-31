package br.com.pdt.leroapp.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.pdt.leroapp.auth.Produced;
import br.com.pdt.leroapp.auth.User;

@ManagedBean
@RequestScoped
public class SignedIn {

	@Inject @Produced private User user;

	public User getUser() {
		return user;
	}
}
