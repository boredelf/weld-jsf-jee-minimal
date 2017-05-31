package br.com.pdt.leroapp.controllers;

import java.time.LocalTime;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@RequestScoped
@ManagedBean(name = "cdiAsyncEvents")
public class CDIAsyncEvents {

	private Logger logger = Logger.getLogger(CDIAsyncEvents.class.getName());

	@Inject private Event<String> event;

	public void dispatchEvent() {
		logger.info("Firing event...");
		event.fire(LocalTime.now().toString());
		logger.info("Event fired.");
	}

}
