package br.com.pdt.leroapp.ejb

import br.com.pdt.leroapp.entity.TransactionEntity
import br.com.pdt.leroapp.util.Open
import javax.annotation.Resource
import javax.ejb.Asynchronous
import javax.ejb.Stateless
import javax.ejb.TransactionManagement
import javax.ejb.TransactionManagementType.BEAN
import javax.inject.Named
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.UserTransaction
import kotlin.system.measureTimeMillis

@Open
@Named
@Stateless
@TransactionManagement(BEAN)
class BmtTransactionBenchmark {

    @PersistenceContext(unitName = "persistenceUnit")
    lateinit var em: EntityManager

    @Resource
    lateinit var userTransaction: UserTransaction

    @Asynchronous
    fun tryAHundredThousandTransactions(): Unit = measureTimeMillis {
        for (i in 1..100_000) {
            userTransaction.begin()
            em.persist(TransactionEntity())
            userTransaction.commit()
        }
    }.run { println("${this} ms") }

    @Asynchronous
    fun tryAThousandBatchedTransactions(): Unit = measureTimeMillis {
        val persistsNumber = 100_000
        val persistsBatchSize = 100_000
        for (i in 1..(persistsNumber / persistsBatchSize)) {
            userTransaction.setTransactionTimeout(30)
            userTransaction.begin()
            for (ii in 1..persistsBatchSize) {
                em.persist(TransactionEntity())
            }
            userTransaction.commit()
        }
    }.run { println("${this} ms") }


}