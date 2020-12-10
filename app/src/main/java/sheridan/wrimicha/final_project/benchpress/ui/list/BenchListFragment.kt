package sheridan.wrimicha.final_project.benchpress.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.BenchListFragmentBinding

class BenchListFragment : Fragment() {

    companion object {
        fun newInstance() = BenchListFragment()
    }

    private lateinit var viewModel: BenchListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.bench_list_fragment, container, false)

        val binding = BenchListFragmentBinding.inflate(inflater, container, false)


        //Add divider
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)

        val adapter = BenchListAdapter(requireContext())
        binding.recyclerView.adapter = adapter

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BenchListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}