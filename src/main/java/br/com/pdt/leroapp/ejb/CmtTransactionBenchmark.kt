package br.com.pdt.leroapp.ejb

import br.com.pdt.leroapp.entity.TransactionEntity
import br.com.pdt.leroapp.util.Open
import javax.ejb.Asynchronous
import javax.ejb.Stateless
import javax.ejb.TransactionAttribute
import javax.ejb.TransactionAttributeType.REQUIRES_NEW
import javax.inject.Named
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import kotlin.system.measureTimeMillis

@Open
@Named
@Stateless
class CmtTransactionBenchmark {

    @PersistenceContext(unitName = "persistenceUnit")
    lateinit var em: EntityManager

    @Asynchronous
    fun tryAHundredThousandPersists(): Unit = measureTimeMillis {
        for (i in 1..100_000) {
            em.persist(TransactionEntity())
        }
    }.run { println("${this} ms") }

    @Asynchronous
        //    @TransactionTimeout(value = 5, unit = SECONDS)
        // TODO The timeout seems to affect the suspended transaction.
    fun tryAHundredThousandPersistsWithSubtransactions() {
        for (i in 1..100_000) {
            persist()
        }
    }

    @TransactionAttribute(REQUIRES_NEW)
    fun persist(): Unit = em.persist(TransactionEntity())

}
