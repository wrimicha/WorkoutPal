package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentLaunchBinding

class BenchInputFragment : Fragment() {
    private lateinit var binding: FragmentJogInputBinding
    private val viewModel: BenchViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogInputBinding.inflate(inflater, container, false)
        binding.saveJog.setOnClickListener {


            findNavController().navigate(R.id.action_jogInputFragment_to_jogOutputFragment)
        }
        binding.backIn.setOnClickListener {
            findNavController().navigate(R.id.action_jogInputFragment_to_launchFragment)

        }
     //   binding.lifecycleOwner = viewLifecycleOwner
      //  binding.viewModel = viewModel

        return binding.root
    }


}