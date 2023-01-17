package com.saadahmedsoft.fakestoreapp.utils

import androidx.lifecycle.MutableLiveData
import com.saadahmedsoft.kotlinhelper.utils.DataState
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object ObserverUtil {

    /**
     * This class hase been made by Saad Ahmed on 01-Jan-2023
     * The reason behind making this class to simplify api calls using RxJava
     */

    /**
     * @param observable takes an Observable to observe
     * @param mutableLiveData takes a Mutable Live Data to Post the results
     */

    fun <T : Any>observe(observable: Observable<T>, mutableLiveData: MutableLiveData<DataState<T>>) {
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onSubscribe(d: Disposable) {
                    mutableLiveData.postValue(DataState.Loading())
                }

                override fun onNext(t: T) {
                    mutableLiveData.postValue(DataState.Success(t))
                }

                override fun onError(e: Throwable) {
                    mutableLiveData.postValue(DataState.Failed(e.localizedMessage))
                }

                override fun onComplete() {}
            })
    }
}