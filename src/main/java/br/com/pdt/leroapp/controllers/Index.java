package br.com.pdt.leroapp.controllers;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.pdt.leroapp.auth.Produced;
import br.com.pdt.leroapp.auth.User;

@ManagedBean
@RequestScoped
public class Index {

	@Inject @Produced private User user;
	private String pswd;

	public String signIn() {
		return "signed-in?faces-redirect=true";
	}

	public String signOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}

	@Produces @SessionScoped @Produced
	public User userProducer() {
		return new User();
	}

	public User getUser() {
		return user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}
