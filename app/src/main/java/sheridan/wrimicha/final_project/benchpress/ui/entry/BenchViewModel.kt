package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.wrimicha.final_project.*
import sheridan.wrimicha.final_project.benchpress.domain.BenchData
//import sheridan.wrimicha.final_project.benchpress.domain.BenchData
import java.util.*


class BenchViewModel (application: Application) : AndroidViewModel(application) {

//    //private val _pets = MutableLiveData
//    var benchLiveData: LiveData<BenchEntity>? = null
//
    private val _benchData: MutableLiveData<BenchData> = MutableLiveData()
    val benchData: LiveData<BenchData> = _benchData

    private val benchDao: BenchDao =
        BenchDatabase.getInstance(application).benchDao

    fun addData(benchEntity: BenchEntity){
        viewModelScope.launch(Dispatchers.IO){
            //val envelopeId = benchDao.insert(benchEntity)
            benchDao.insert(benchEntity)
            var benchValues = BenchData(
                benchEntity.weight,
                benchEntity.reps,
                benchEntity.sets,
                benchEntity.id
            )
            _benchData.value = benchValues
        }
    }
}