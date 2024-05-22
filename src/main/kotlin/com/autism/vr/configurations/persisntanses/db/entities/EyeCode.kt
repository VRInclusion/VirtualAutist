package com.autism.vr.configurations.persisntanses.db.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "eye_code", schema = "autism_vr")
data class EyeCode(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null,

    @Column(name = "local_id")
    open var localId: String = "",

    open var answer: String = "",

    @ManyToOne
    @JoinColumn(name = "teach_session_id")
    open val teachSession: TeachSession? = null,
)