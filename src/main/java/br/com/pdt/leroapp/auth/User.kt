package br.com.pdt.leroapp.auth

import br.com.pdt.leroapp.util.Open
import java.io.Serializable

@Open
class User(var name: String = "", var isLoggedIn: Boolean = false) : Serializable