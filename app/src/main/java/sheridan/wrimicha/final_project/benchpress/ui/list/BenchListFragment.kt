package sheridan.wrimicha.final_project.benchpress.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.wrimicha.final_project.*
import sheridan.wrimicha.final_project.benchpress.ViewModelFactory
import sheridan.wrimicha.final_project.databinding.BenchListFragmentBinding


class BenchListFragment : Fragment() {

    private lateinit var binding: BenchListFragmentBinding
    //private lateinit var adapter: BenchListAdapter
    private var viewModel : BenchListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    private var adapter = BenchListAdapter(
        onEdit = { bench ->
            findNavController().navigate(BenchListFragmentDirections.actionBenchListFragmentToBenchInputFragment(bench.id))
        },
        onDelete = { bench ->
            viewModel.delete(bench)
        }
    )

    override fun onViewCreated(savedInstanceState: Bundle?) {
        //val binding = DonutListBinding.bind(view)
        val benchDao = BenchDatabase.getInstance(requireContext()).benchDao()
        viewModel = ViewModelProvider(this, ViewModelFactory(benchDao))
            .get(BenchListViewModel::class.java)

        viewModel.history.observe(viewLifecycleOwner) { donuts ->
            adapter.submitList(donuts)
        }

//        recyclerView.adapter = adapter
//
//        binding.fab.setOnClickListener { fabView ->
//            fabView.findNavController().navigate(
//                DonutListFragmentDirections.actionListToEntry()
//            )
//        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BenchListFragmentBinding.inflate(inflater, container, false)

        // Set the adapter
        adapter = BenchListAdapter(requireContext())

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