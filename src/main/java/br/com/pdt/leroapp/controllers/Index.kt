package br.com.pdt.leroapp.controllers

import br.com.pdt.leroapp.auth.Produced
import br.com.pdt.leroapp.auth.User
import javax.enterprise.context.SessionScoped
import javax.enterprise.inject.Produces
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.faces.context.FacesContext
import javax.inject.Inject

@ManagedBean
@RequestScoped
class Index {

    @Inject
    @Produced
    lateinit var user: User
    var pswd: String? = null

    fun signIn(): String {
        user.isLoggedIn = true
        return "signed-in?faces-redirect=true"
    }

    fun signOut(): String {
        FacesContext.getCurrentInstance().externalContext.invalidateSession()
        return "index?faces-redirect=true"
    }

    @Produces
    @Produced
    @SessionScoped
    fun userProducer() = User()

}