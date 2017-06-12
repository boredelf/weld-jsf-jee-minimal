package br.com.pdt.leroapp.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Suppress("unused")
@Table(name = "lero", schema = "transactions")
class TransactionEntity(
    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
)