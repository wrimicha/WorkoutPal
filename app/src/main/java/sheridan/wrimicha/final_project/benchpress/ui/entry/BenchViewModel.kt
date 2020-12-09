package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.app.Application
import androidx.lifecycle.*
import com.android.samples.donuttracker.database.BenchDao
import com.android.samples.donuttracker.database.BenchDatabase
import com.android.samples.donuttracker.database.BenchEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class BenchViewModel (application: Application) : AndroidViewModel(application) {

    //private val _pets = MutableLiveData
    var benchLiveData: LiveData<BenchEntity>? = null

    private val benchDao: BenchDao =
        //BenchDatabase.getDatabase(application).benchDao

    fun addData(benchEntity: BenchEntity){
//        viewModelScope.launch(Dispatchers.IO){
//            envelopeId = benchDAO.insert(envelope)
//            _status.postValue(Status.SAVED_DATA)
//        }
    }
}