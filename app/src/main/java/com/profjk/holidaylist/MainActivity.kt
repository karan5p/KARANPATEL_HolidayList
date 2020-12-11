package com.profjk.holidaylist
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.profjk.holidaylist.network.Holiday
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private var countries : Array<String> = arrayOf("Canada", "USA", "Brazil", "Japan", "Netherlands")
    private var countryCodes : Array<String> = arrayOf("CA", "US", "BR", "JP", "NL")
    private var baseUrl = "https://date.nager.at/api/v2/publicholidays/2021/"
    private lateinit var rvHolidays : RecyclerView
    private lateinit var viewAdapter: HolidayAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var holidayList: MutableList<Holiday>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.rvHolidays = findViewById(R.id.rvHolidays)
        this.holidayList = mutableListOf()
        this.viewAdapter = HolidayAdapter(this.applicationContext,this.holidayList,this)
        this.rvHolidays.adapter = this.viewAdapter
        this.viewManager = LinearLayoutManager(this.applicationContext)
        this.rvHolidays.layoutManager = this.viewManager
        this.rvHolidays.setHasFixedSize(true)
        this.rvHolidays.addItemDecoration(DividerItemDecoration(this.applicationContext, DividerItemDecoration.VERTICAL))
        holidayViewModel = HolidayViewModel()
        this.initializeSpinner()
    }
    private fun initializeSpinner(){
        val titlesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        titlesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCountries.adapter = titlesAdapter
    }
}