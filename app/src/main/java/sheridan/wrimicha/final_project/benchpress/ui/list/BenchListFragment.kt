package sheridan.wrimicha.final_project.benchpress.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.wrimicha.final_project.HistoryRecyclerViewAdapter
import sheridan.wrimicha.final_project.HistoryViewModel
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.BenchListFragmentBinding


class BenchListFragment : Fragment() {

    private lateinit var binding: BenchListFragmentBinding
    private lateinit var adapter: BenchListAdapter
    private val viewModel : BenchListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BenchListFragmentBinding.inflate(inflater, container, false)

        // Set the adapter
        adapter = BenchListAdapter(requireContext(),viewModel,navController = findNavController())

        with(binding){
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(divider)
            recyclerView.adapter = adapter
        }

        viewModel.history.observe(viewLifecycleOwner){
            adapter.history = it

        }

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_history, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.clear -> {
                viewModel.clear()
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }


}