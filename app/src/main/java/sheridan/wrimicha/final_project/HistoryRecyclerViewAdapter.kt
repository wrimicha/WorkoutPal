package sheridan.wrimicha.final_project

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import sheridan.wrimicha.final_project.JogUpdateFragment.Companion.JOG_INFO


class HistoryRecyclerViewAdapter(private val context: Context,private val viewModel: HistoryViewModel,private val navController : NavController) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {

    var history: List<Jog>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jog = history!![position]
        holder.idView.text = "${position + 1}."
        holder.rollValueHistory1.text = jog.value
        holder.yearValue.text = jog.year.toString()
        holder.monthValue.text = jog.month.toString()
        holder.dayValue.text = jog.day.toString()
        holder.durationValue.text = jog.duration
        holder.delete.setOnClickListener{
            viewModel.deleteItem(jog.id)
        }
        holder.edit.setOnClickListener{
            val arguments = Bundle()
            val jogInfo = JogDataId(jog.id,jog.value, jog.year,jog.month,jog.day,jog.duration)
            arguments.putSerializable(JOG_INFO, jogInfo)
            navController.navigate(R.id.action_historyFragment_to_jogUpdateFragment,arguments)
        }
    }

    override fun getItemCount(): Int = history?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.rollValueHistory1)
        val rollValueHistory1 : TextView = view.findViewById(R.id.rollValueHistory1)
        val yearValue : TextView = view.findViewById(R.id.yearValue)
        val monthValue : TextView = view.findViewById(R.id.monthValue)
        val dayValue : TextView = view.findViewById(R.id.dayValue)
        val durationValue : TextView = view.findViewById(R.id.durationValue)
        val delete: Button = view.findViewById(R.id.delete)
        val edit: Button = view.findViewById(R.id.edit)
    }





}