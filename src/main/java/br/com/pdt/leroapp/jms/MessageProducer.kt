package br.com.pdt.leroapp.jms

import br.com.pdt.leroapp.util.Open
import javax.annotation.Resource
import javax.ejb.Stateless
import javax.inject.Named
import javax.jms.ConnectionFactory
import javax.jms.Session
import javax.jms.Topic

@Open
@Named
@Stateless
@Suppress("unused")
class MessageProducer {

    @Resource(lookup = "java:/ConnectionFactory")
    private lateinit var connectionFactory: ConnectionFactory

    @Resource(lookup = "java:/jms/LeroTopic")
    private lateinit var topic: Topic

    fun publishMessageOnTopic() {
        val connection = connectionFactory.createConnection()
        connection.start()
        val session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE)
        session.createProducer(topic).send(session.createTextMessage("Lero"))
        session.close()
        connection.close()
    }

}