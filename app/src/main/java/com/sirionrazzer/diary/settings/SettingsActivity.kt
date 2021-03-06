package com.sirionrazzer.diary.settings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.sirionrazzer.diary.R
import com.sirionrazzer.diary.models.TrackItemDao
import io.realm.Realm
import kotlinx.android.synthetic.main.toolbar.*


class SettingsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.settings,
                SettingsFragment()
            )
            .commit()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        val realm: Realm by lazy {
            Realm.getDefaultInstance()
        }
        private val trackItemDao: TrackItemDao = realm.trackItemDao

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            val button = findPreference<Preference>(getString(R.string.deleteHistoryButton))
            button!!.onPreferenceClickListener = Preference.OnPreferenceClickListener {
                trackItemDao.deleteAllTrackItems()
                Toast.makeText(context, getString(R.string.history_deleted), Toast.LENGTH_SHORT).show()
                true
            }
        }
    }
}

private val Realm.trackItemDao: TrackItemDao
    get() {
        return TrackItemDao(this)
    }