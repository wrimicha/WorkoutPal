package sheridan.wrimicha.final_project.benchpress.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.wrimicha.final_project.*

class BenchListViewModel(application: Application) :  AndroidViewModel(application) {

    private val benchDao: BenchDao =
        BenchDatabase.getInstance(application).benchDao

    val history: LiveData<List<BenchEntity>> = benchDao.getAll()

    fun clear(){
        viewModelScope.launch {
            benchDao.deleteAll()
        }
    }

    fun delete(bench: BenchEntity) = viewModelScope.launch(Dispatchers.IO) {
        benchDao.delete(bench)
    }

}