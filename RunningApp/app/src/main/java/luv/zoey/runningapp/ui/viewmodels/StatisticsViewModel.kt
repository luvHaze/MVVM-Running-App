package luv.zoey.runningapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import luv.zoey.runningapp.repositories.MainRepository
import javax.inject.Inject

// 뷰모델은 그냥 Inject로 하려면 ViewModelFactory 에
// 복잡한 과정을 거치기 때문에 DaggerHilt에선 ViewModelInject를 만들었다?
class StatisticsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel(){

}