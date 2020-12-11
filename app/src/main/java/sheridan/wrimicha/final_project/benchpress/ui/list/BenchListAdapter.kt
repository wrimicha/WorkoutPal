package sheridan.wrimicha.final_project.benchpress.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.wrimicha.final_project.BenchEntity
import sheridan.wrimicha.final_project.HistoryRecyclerViewAdapter
import sheridan.wrimicha.final_project.Jog
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.BenchListFragmentBinding
import sheridan.wrimicha.final_project.databinding.BenchListItemBinding
import sheridan.wrimicha.final_project.dummy.DummyContent.DummyItem

class BenchListAdapter(
    private var onEdit: (BenchEntity) -> Unit,
    private var onDelete: (BenchEntity) -> Unit) :
    ListAdapter<BenchEntity, BenchListAdapter.ViewHolder>(BenchDiffCallback()) {


    class ViewHolder(
        private val binding: BenchListItemBinding,
        private var onEdit: (BenchEntity) -> Unit,
        private var onDelete: (BenchEntity) -> Unit
        ) : RecyclerView.ViewHolder(binding.root) {
        private var id: Long = -1
        private var weight = binding.weight
        private var reps = binding.reps
        private var sets = binding.sets
        private var year = binding.year
        private var month = binding.month
        private var day = binding.day

        private var benchData: BenchEntity? = null

        fun bind(bench: BenchEntity) {
            id = bench.id
            weight.text = bench.weight.toString()
            sets.text = bench.sets.toString()
            reps.text = bench.reps.toString()
            year.text = bench.year.toString()
            month.text = bench.month.toString()
            day.text = bench.day.toString()
            this.benchData = bench
//                binding.delete.setOnClickListener {
//                    onDelete(bench)
//                }
            binding.root.setOnClickListener {
                onEdit(bench)
            }
        }
    }


    override fun onBindViewHolder(holder: BenchListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenchListAdapter.ViewHolder {

        return BenchListAdapter.ViewHolder(
            BenchListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onEdit,
            onDelete
        )
    }

        class BenchDiffCallback : DiffUtil.ItemCallback<BenchEntity>() {
        override fun areItemsTheSame(oldItem: BenchEntity, newItem: BenchEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BenchEntity, newItem: BenchEntity): Boolean {
            return oldItem == newItem
        }
    }
}

//    var history: List<BenchEntity>? = null
//        set(value){
//            field = value
//            notifyDataSetChanged()
//        }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.bench_list_item, parent, false)
//        return ViewHolder(view)
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val bench = history!![position]
//        holder.idView.text = "${position + 1}."
//        holder.weight.text = bench.weight
//        holder.reps.text =  bench.reps
//        holder.sets.text = bench.sets
//
//
//        holder.yearValue.text = bench.year.toString()
//        holder.monthValue.text = bench.month.toString()
//        holder.dayValue.text = bench.day.toString()
//
//    }

//    override fun getItemCount(): Int = history?.size ?: 0

//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val idView: TextView = view.findViewById(R.id.item_number)
//       // val contentView: TextView = view.findViewById(R.id.rollValueHistory1)
//        val weight : TextView = view.findViewById(R.id.weight)
//        val reps : TextView = view.findViewById(R.id.reps)
//        val sets : TextView = view.findViewById(R.id.sets)
//        val yearValue : TextView = view.findViewById(R.id.year)
//        val monthValue : TextView = view.findViewById(R.id.month)
//        val dayValue : TextView = view.findViewById(R.id.day)
//
//    }