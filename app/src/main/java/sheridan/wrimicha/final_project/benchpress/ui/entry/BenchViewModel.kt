package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
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

    private var benchLiveData: LiveData<BenchEntity>? = null

    private val benchDao: BenchDao =
        BenchDatabase.getInstance(application).benchDao

    fun get(id: Long): LiveData<BenchEntity> {
        return benchLiveData ?: liveData {
            emit(benchDao.get(id))
        }.also {
            benchLiveData = it
        }
    }

    fun submit(
        id: Long,
        weight: Double,
        reps: Double,
        sets: Double,
        day: Int,
        month: Int,
        year: Int
    ) {
        val bench = BenchEntity(id, weight, reps, sets, day, month, year)

        CoroutineScope(Dispatchers.Main.immediate).launch {
            if (id > 0) {
                update(bench)
            } else {
                insert(bench)
            }
        }
    }

    private suspend fun insert(bench: BenchEntity): Long {
        return benchDao.insert(bench)
    }

    private fun update(bench: BenchEntity) = viewModelScope.launch(Dispatchers.IO) {
        benchDao.update(bench)
    }


//    fun addData(benchEntity: BenchData){
//
//        _benchData.value = benchEntity
//        viewModelScope.launch{
//            //val envelopeId = benchDao.insert(benchEntity)
//            benchDao.insert(BenchEntity(0,benchEntity.weight,benchEntity.reps,benchEntity.sets,benchEntity.year,benchEntity.month,benchEntity.day))
//
//            /*val benchValues = BenchData(
//                benchEntity.weight,
//                benchEntity.reps,
//                benchEntity.sets,
//                benchEntity.id
//            )
//            _benchData.value = benchValues*/
//        }
//    }
}