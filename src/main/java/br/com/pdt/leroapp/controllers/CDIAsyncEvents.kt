package br.com.pdt.leroapp.controllers

import java.time.LocalTime
import java.util.logging.Logger
import javax.enterprise.event.Event
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.inject.Inject

@RequestScoped
@ManagedBean(name = "cdiAsyncEvents")
class CDIAsyncEvents {

    private val logger = Logger.getLogger(CDIAsyncEvents::class.java.name)

    @Inject
    private lateinit var event: Event<String>

    fun dispatchEvent() {
        logger.info("Firing event...")
        event.fire(LocalTime.now().toString())
        logger.info("Event fired.")
    }

}