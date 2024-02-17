package com.luanindiano.credit.application.system.service.impl

import com.luanindiano.credit.application.system.entity.Credit
import com.luanindiano.credit.application.system.repository.CreditRepository
import com.luanindiano.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }
    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomer(customerId)
    override fun findByCreditCode(customerID: Long, creditCode: String): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode $creditCode not found"))
    return if (credit.customer?.id == customerID) credit else throw RuntimeException("Contact admin")

    }
}