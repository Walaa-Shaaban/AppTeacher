package com.selwan.schools365teacher.ui.examination.view_mark

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.exams.ViewMark
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class ExaminationViewMarkRepository(
    var compositeDisposable: CompositeDisposable,
    var context: Context
) {


    var getViewMark = MutableLiveData<ViewMark>()

    fun fetchAddViewMark(exam_id: String, class_id: String, section_id: String)
            : LiveData<ViewMark> {
        compositeDisposable.add(
            ApiUtils.apiService.getViewMark(exam_id, class_id, section_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        getViewMark.value = it
                    },
                    Consumer {
                        Toast.makeText(
                            context,
                            "Something Went Error ... The data couldn't be read",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                ))
        return getViewMark
    }


}