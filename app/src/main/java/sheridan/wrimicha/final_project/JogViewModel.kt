package sheridan.wrimicha.final_project

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch


class JogViewModel (application: Application) : AndroidViewModel(application) {

    private val _jogData: MutableLiveData<JogData> = MutableLiveData()
    val jogData: LiveData<JogData> = _jogData

    private val jogDao : JogDao = JogDatabase.getInstance(application).jogDao

    fun submit(jogInfoData: JogData){
        _jogData.value = jogInfoData

        viewModelScope.launch{
        jogDao.insert(Jog(0,jogInfoData.kms,jogInfoData.year,jogInfoData.month,jogInfoData.day,jogInfoData.duration))
        }
    }
}