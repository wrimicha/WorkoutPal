package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.wrimicha.final_project.*
import sheridan.wrimicha.final_project.benchpress.domain.BenchData
import sheridan.wrimicha.final_project.benchpress.domain.BenchDataId
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

    fun addData(benchEntity: BenchData){

        _benchData.value = benchEntity
        viewModelScope.launch{
            //val envelopeId = benchDao.insert(benchEntity)
            benchDao.insert(BenchEntity(0,benchEntity.weight,benchEntity.reps,benchEntity.sets,benchEntity.year,benchEntity.month,benchEntity.day))
        }
    }

    fun update(benchDataId: BenchDataId){
        viewModelScope.launch{
            benchDao.update(BenchEntity(benchDataId.id,benchDataId.weight,benchDataId.reps,benchDataId.sets,benchDataId.year,benchDataId.month,benchDataId.day))
        }
    }
}