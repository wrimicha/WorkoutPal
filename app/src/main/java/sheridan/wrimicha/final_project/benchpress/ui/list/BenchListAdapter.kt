package sheridan.wrimicha.final_project.benchpress.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import sheridan.wrimicha.final_project.*
import sheridan.wrimicha.final_project.benchpress.domain.BenchDataId
import sheridan.wrimicha.final_project.benchpress.ui.entry.BenchUpdateFragment
import sheridan.wrimicha.final_project.databinding.BenchListFragmentBinding
import sheridan.wrimicha.final_project.dummy.DummyContent.DummyItem

class BenchListAdapter(private val context: Context, private val viewModel: BenchListViewModel, private val navController : NavController) : RecyclerView.Adapter<BenchListAdapter.ViewHolder>() {

    var history: List<BenchEntity>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bench_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bench = history!![position]
        holder.idView.text = "${position + 1}."
        holder.weight.text = bench.weight
        holder.reps.text =  bench.reps
        holder.sets.text = bench.sets


        holder.yearValue.text = bench.year.toString()
        holder.monthValue.text = bench.month.toString()
        holder.dayValue.text = bench.day.toString()

        holder.delete.setOnClickListener{

            viewModel.deleteItem(bench.id)

        }
holder.edit.setOnClickListener{
    val arguments = Bundle()
    val benchInfo = BenchDataId(bench.id,bench.weight, bench.reps,bench.sets,bench.year,bench.month,bench.day)
    arguments.putSerializable(BenchUpdateFragment.BENCH_INFO, benchInfo)
    navController.navigate(R.id.action_benchListFragment_to_benchUpdateFragment,arguments)
}

    }

    override fun getItemCount(): Int = history?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
       // val contentView: TextView = view.findViewById(R.id.rollValueHistory1)
        val weight : TextView = view.findViewById(R.id.weight)
        val reps : TextView = view.findViewById(R.id.reps)
        val sets : TextView = view.findViewById(R.id.sets)
        val yearValue : TextView = view.findViewById(R.id.year)
        val monthValue : TextView = view.findViewById(R.id.month)
        val dayValue : TextView = view.findViewById(R.id.day)
        val delete: Button = view.findViewById(R.id.deleteBench)
        val edit: Button = view.findViewById(R.id.editBench)
    }
}