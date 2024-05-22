package com.autism.vr.configurations.persisntanses.db.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "scenes", schema = "autism_vr")
data class Scene(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: UUID? = null,

    open var name: String? = null,

    @Column(name = "local_id")
    open val localId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "teach_session_id")
    open val teachSession: TeachSession? = null,

    )
