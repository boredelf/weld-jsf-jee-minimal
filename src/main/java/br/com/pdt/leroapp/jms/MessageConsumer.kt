package br.com.pdt.leroapp.jms

import br.com.pdt.leroapp.util.Open
import java.util.concurrent.TimeUnit.SECONDS
import java.util.logging.Logger
import javax.ejb.ActivationConfigProperty
import javax.ejb.MessageDriven
import javax.jms.Message
import javax.jms.MessageListener
import javax.jms.TextMessage

@Open
@Suppress("unused")
@MessageDriven(activationConfig = arrayOf(
    ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/LeroTopic")
))
class MessageConsumer : MessageListener {

    val logger = Logger.getLogger(this::class.java.name)

    override fun onMessage(message: Message?) = message?.let {
        logger.info("Message received: ${(message as TextMessage).text}")
        businessCall()
    } ?: Unit

    private fun businessCall() {
        SECONDS.sleep(7)
        logger.info("Thread awakens.")
    }

}