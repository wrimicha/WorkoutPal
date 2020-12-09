package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import androidx.lifecycle.*
import com.android.samples.donuttracker.database.BenchEntity
import java.util.*


class BenchViewModel (application: Application) : AndroidViewModel(application) {

    //private val _pets = MutableLiveData
    var benchLiveData: LiveData<BenchEntity> = null

    fun addData(
        id: Long,
        weight: Double,
        reps: Int,
        sets: Int,
        date: Date
    ){

    }
}