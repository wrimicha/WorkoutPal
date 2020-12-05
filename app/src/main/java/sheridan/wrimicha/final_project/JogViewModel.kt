package sheridan.sharm212.workout

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch


class JogViewModel (application: Application) : AndroidViewModel(application) {

    private val _jogData: MutableLiveData<JogData> = MutableLiveData()
    val rollerData: LiveData<JogData> = _jogData

    private val rollerDao : JogDao = JogDatabase.getInstance(application).rollerDao

    fun submit(jogInfoData: JogData){
        _jogData.value = jogInfoData

        viewModelScope.launch{
        //rollerDao.insert(Roller(0,rollerInfoData.rollValue,rollerInfoData.rollValue1,rollerInfoData.rollValue2,rollerInfoData.total))
        }
    }
}