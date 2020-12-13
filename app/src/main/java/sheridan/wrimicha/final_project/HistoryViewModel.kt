package sheridan.wrimicha.final_project

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.wrimicha.final_project.Jog
import sheridan.wrimicha.final_project.JogDao
import sheridan.wrimicha.final_project.JogDatabase
import sheridan.wrimicha.final_project.databinding.FragmentHistoryBinding

class HistoryViewModel(application: Application) : AndroidViewModel(application){

    private val jogDao: JogDao =
            JogDatabase.getInstance(application).jogDao

    val history: LiveData<List<Jog>> = jogDao.getAll()

    fun clear(){
        viewModelScope.launch {
            jogDao.deleteAll()
        }
    }
    fun deleteItem(id:Long){
        viewModelScope.launch {
            jogDao.delete(id)
        }
    }

}