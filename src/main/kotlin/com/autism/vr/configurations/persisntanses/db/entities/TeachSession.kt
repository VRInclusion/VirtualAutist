package com.autism.vr.configurations.persisntanses.db.entities

import jakarta.persistence.*
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "teach_sessions", schema = "autism_vr")
data class TeachSession(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null,

    open var code: String? = null,

    @ManyToOne
    @JoinColumn(name = "student_id")
    open var student: Student? = null,

    @Column(name = "created_at")
    open var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    @UpdateTimestamp
    open var updatedAt: LocalDateTime = createdAt
)