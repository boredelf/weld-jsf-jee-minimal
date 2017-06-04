package br.com.pdt.leroapp.ejb

import br.com.pdt.leroapp.util.Open
import java.util.concurrent.TimeUnit
import java.util.logging.Logger
import javax.ejb.Asynchronous
import javax.ejb.Singleton
import javax.enterprise.event.Observes

@Open
@Singleton
class EventsReceiver {

    private val logger = Logger.getLogger(EventsReceiver::class.java.name)

    @Asynchronous
    @Throws(InterruptedException::class)
    fun consumer(@Observes event: String) {
        TimeUnit.SECONDS.sleep(2)
        logger.info("Event consumed: " + event)
    }

}