package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.FragmentBenchOutputBinding

class BenchOutputFragment : Fragment() {
    private lateinit var binding: FragmentBenchOutputBinding
    private val viewModel : BenchViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBenchOutputBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.backOut.setOnClickListener {
            findNavController().navigate(R.id.action_benchOutputFragment_to_launchFragment)

        }

        // Inflate the layout for this fragment
        return binding.root
    }

}