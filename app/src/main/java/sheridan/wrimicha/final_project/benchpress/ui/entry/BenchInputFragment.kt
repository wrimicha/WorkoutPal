package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.android.samples.donuttracker.database.BenchEntity
import sheridan.wrimicha.final_project.R
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
            findNavController().navigate(R.id.action_jogInputFragment_to_launchFragment)

        }
        return binding.root
    }

    private fun save() {
        val weight = parseDouble(binding.weightUsed.toString())
        val reps = parseDouble(binding.reps.toString())
        val sets = parseDouble(binding.sets.toString())
        //var date = parseDouble(binding.weightUsed.toString())

        viewModel.addData(BenchEntity(weight, reps, sets))
    }
     //   binding.lifecycleOwner = viewLifecycleOwner
      //  binding.viewModel = viewModel
}