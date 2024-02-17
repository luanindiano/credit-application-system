package com.luanindiano.credit.application.system.service

import com.luanindiano.credit.application.system.entity.Credit

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerID: Long): List<Credit>
    fun findByCreditCode(customerID: Long, creditCode: String): Credit
}