package sheridan.wrimicha.final_project.benchpress.domain

import java.io.Serializable
import java.util.*

data class BenchData(
        var weight: String,
        var reps: String,
        var sets: String,
): Serializable {
}