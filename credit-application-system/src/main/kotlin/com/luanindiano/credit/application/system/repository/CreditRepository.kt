package com.luanindiano.credit.application.system.repository

import com.luanindiano.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//Com essa interface eu ja posso consulta o banco, nesse caso podemos usar para a tabela Credit
@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

}