package com.sirionrazzer.diary.history

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sirionrazzer.diary.Diary
import com.sirionrazzer.diary.models.TrackItem
import com.sirionrazzer.diary.models.TrackItemDao
import com.sirionrazzer.diary.util.DateUtils
import io.realm.Realm

class HistoryViewModel: ViewModel() {

    val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    private val trackItemDao: TrackItemDao = realm.trackItemDao
    private val dateUtils = DateUtils()

    var dates: ArrayList<String> = arrayListOf()
    var trackItemsByDate: HashMap<String, ArrayList<TrackItem>> = hashMapOf()

    init {
        Diary.app.appComponent.inject(this)
    }

    fun loadData() {
        dates = arrayListOf()
        trackItemsByDate = hashMapOf()

        var trackItems: List<TrackItem>? = trackItemDao.getAllTrackItemsSortByDate()
        if (trackItems == null) {
            trackItems = arrayListOf()
        }

        trackItems.forEach {
            val date = dateUtils.smartDate(dateUtils.dateFromMillis(it.date), false)

            if (!trackItemsByDate.containsKey(date)) {
                trackItemsByDate[date] = arrayListOf()
                dates.add(date)
            }

            trackItemsByDate[date]!!.add(it)
        }

        Log.d("HistoryViewModel", trackItems.size.toString())
    }
}

private val Realm.trackItemDao: TrackItemDao
    get() {
        return TrackItemDao(this)
    }
