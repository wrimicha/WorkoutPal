package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import androidx.lifecycle.*
import com.android.samples.donuttracker.database.BenchDao
import com.android.samples.donuttracker.database.BenchDatabase
import com.android.samples.donuttracker.database.BenchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.wrimicha.final_project.JogDao
import sheridan.wrimicha.final_project.JogData
import sheridan.wrimicha.final_project.JogDatabase
//import sheridan.wrimicha.final_project.benchpress.domain.BenchData
import java.util.*


class BenchViewModel (application: Application) : AndroidViewModel(application) {

//    //private val _pets = MutableLiveData
//    var benchLiveData: LiveData<BenchEntity>? = null
//
//    private val _benchData: MutableLiveData<BenchData> = MutableLiveData()
//    val benchData: LiveData<BenchData> = _benchData

    private val benchDao: BenchDao =
        BenchDatabase.getInstance(application).benchDao

    fun addData(benchEntity: BenchEntity){
        viewModelScope.launch(Dispatchers.IO){
            //val envelopeId = benchDao.insert(benchEntity)
            benchDao.insert(benchEntity)
            //_status.postValue(Status.SAVED_DATA)
        }
    }
}