package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.BenchEntity
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.benchpress.domain.BenchData
import sheridan.wrimicha.final_project.databinding.FragmentBenchInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentLaunchBinding
import java.lang.Double.parseDouble

class BenchInputFragment : Fragment() {
    private lateinit var binding: FragmentBenchInputBinding
    private val viewModel: BenchViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBenchInputBinding.inflate(inflater, container, false)
        binding.send.setOnClickListener { save() }

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_benchInputFragment_to_launchFragment)

        }
        return binding.root
    }

    private fun save() {
        val weight = binding.weightUsed.text.toString()
        val reps = binding.reps.text.toString()
        val sets = binding.sets.text.toString()
        //var date = parseDouble(binding.weightUsed.toString())

        viewModel.addData(BenchData(weight, reps, sets))
    }
     //   binding.lifecycleOwner = viewLifecycleOwner
      //  binding.viewModel = viewModel
}