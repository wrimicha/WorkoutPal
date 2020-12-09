package sheridan.wrimicha.final_project

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.Jog

import sheridan.wrimicha.final_project.dummy.DummyContent.DummyItem
import java.nio.file.Files.size

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class HistoryRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {

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

    }

    override fun getItemCount(): Int = history?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.rollValueHistory1)
        val rollValueHistory1 : TextView = view.findViewById(R.id.rollValueHistory1)

    }
}