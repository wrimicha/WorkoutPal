package sheridan.wrimicha.final_project.benchpress.domain

import java.io.Serializable
import java.util.*

data class BenchData(
        var weight: Double,
        var reps: Double,
        var sets: Double,
        var id: Long = 0L
        //var date: Date
)