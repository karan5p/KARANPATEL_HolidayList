package com.profjk.holidaylist.adapters
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.profjk.holidaylist.network.Holiday
import kotlinx.android.synthetic.main.holiday_list_item.view.*
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.profjk.holidaylist.MainActivity
import com.profjk.holidaylist.R
class HolidayAdapter(
        val context: Context,
        val holidaysList: MutableList<Holiday>,
        val itemClickListener: MainActivity
) : RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): HolidayAdapter.HolidayViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.holiday_list_item, null)
        return HolidayViewHolder(view)
    }
    override fun getItemCount(): Int {
        return holidaysList.size
    }
    override fun onBindViewHolder(holder: HolidayAdapter.HolidayViewHolder, position: Int) {
        holder.bind(holidaysList[position], itemClickListener)
    }
    inner class HolidayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvDate: TextView = itemView.tvDate
        var tvHolidayName: TextView = itemView.tvHolidayName
        fun bind(holiday: Holiday, clickListener: MainActivity) {
            if (holiday.name != null)
                tvHolidayName.setText(holiday.name.toString())
            if (holiday.name != null)
                tvDate.setText(holiday.date.toString())
        }
    }
}