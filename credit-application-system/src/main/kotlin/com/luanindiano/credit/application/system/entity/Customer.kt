package com.luanindiano.credit.application.system.entity

import jakarta.persistence.*

@Entity
data class Customer(
    @Column(nullable = false)
    var firstname: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    @Embedded var address: Address = Address(),

    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE], mappedBy = "customer")
    var credits: List<Credit> = mutableListOf(),

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long //PK da tabela no DB e o Generation faz com que seja incrementado o valor do ID automatico
)
