package com.autism.vr.configurations.persisntanses.db.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "results", schema = "autism_vr")
data class Result(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null,

    open var results: String? = null,

    @ManyToOne
    @JoinColumn(name = "teach_session_id")
    open var teachSession: TeachSession? = null,

)
