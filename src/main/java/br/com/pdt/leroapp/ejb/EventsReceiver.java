package br.com.pdt.leroapp.ejb;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;

@Singleton
public class EventsReceiver {

	private Logger logger = Logger.getLogger(EventsReceiver.class.getName());

	@Asynchronous
	public void consumer(@Observes String event) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		logger.info("Event consumed: " + event);
	}

}
