package com.autism.vr.configurations.persisntanses.db.entities

import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "students", schema = "autism_vr")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null,

    open var name: String? = null,

    open var code: String? = null,

    @CreatedDate
    @Column(name = "created_at")
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    @Column(name = "updated_at")
    open var updatedAt: LocalDateTime = createdAt
)