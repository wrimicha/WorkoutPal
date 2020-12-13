package sheridan.wrimicha.final_project.benchpress.domain

import java.io.Serializable
import java.util.*

data class BenchDataId(
        var id:Long,
        var weight: String,
        var reps: String,
        var sets: String,
        var year:Int,
        var month: Int,
        var day: Int
): Serializable {
}