package br.com.pdt.leroapp.controllers

import br.com.pdt.leroapp.auth.Produced
import br.com.pdt.leroapp.auth.User
import javax.annotation.PostConstruct
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.faces.context.FacesContext
import javax.inject.Inject

@ManagedBean
@RequestScoped
class SignedIn {

    @Inject
    @Produced
    lateinit var user: User
        private set

    @PostConstruct
    fun postConstructor() {
        if (!user.isLoggedIn) {
            FacesContext.getCurrentInstance().externalContext.redirect("index.xhtml")
        }
    }

}