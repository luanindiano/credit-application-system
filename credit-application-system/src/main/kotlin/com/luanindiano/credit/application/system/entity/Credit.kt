package com.luanindiano.credit.application.system.entity
import com.luanindiano.credit.application.system.entity.ennumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.random.Random as Random1

@Entity
@Table(name = "Credit")
data class Credit (
    @Column(nullable = false, unique = true, length = 10)
    val creditCode: String = generateUniqueCode(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    val dayFirstinstallment: LocalDate,

    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    val customer: Customer? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
fun generateUniqueCode(length: Int = 10): String {
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val random = Random1.Default
    val code = StringBuilder()

    for (i in 0 until length) {
        val randomIndex = random.nextInt(characters.length)
        code.append(characters[randomIndex])
    }

    return code.toString()
}