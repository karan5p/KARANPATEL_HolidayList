//991519115 Karan Patel
package com.profjk.holidaylist.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.profjk.holidaylist.network.Holiday
import com.profjk.holidaylist.network.HolidaysApi
import kotlinx.coroutines.launch
import java.lang.Exception
class HolidayViewModel : ViewModel() {
    private val holiday = MutableLiveData<List<Holiday>>()
    val response: MutableLiveData<List<Holiday>>
        get() = holiday
    fun getHolidayInfo(apiUrl: String){
        viewModelScope.launch{
            try{
                val holiday = HolidaysApi.RETROFIT_SERVICE_HOLIDAY.retrieveResponse(apiUrl)
                  this@HolidayViewModel.holiday.postValue(holiday)
            }catch (ex: Exception){
                Log.e("Holidays", ex.localizedMessage)
            }
        }
    }
}