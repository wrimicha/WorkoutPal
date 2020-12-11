package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.BenchEntity
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.benchpress.domain.BenchData
import sheridan.wrimicha.final_project.databinding.FragmentBenchInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import sheridan.wrimicha.final_project.databinding.FragmentLaunchBinding
import java.lang.Double.parseDouble
import java.util.*

class BenchInputFragment : Fragment() {
    private lateinit var binding: FragmentBenchInputBinding
    private val viewModel: BenchViewModel by activityViewModels()

    var year1 :Int=0
    var month1 :Int=0
    var dayOfMonth1 :Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBenchInputBinding.inflate(inflater, container, false)
        val c = Calendar.getInstance()
        val yearCurrent = c.get(Calendar.YEAR)
        val monthCurrent = c.get(Calendar.MONTH)
        val dayOfMonthCurrent = c.get(Calendar.DAY_OF_MONTH)

        binding.calendarView2.setOnDateChangeListener { view, year, month, dayOfMonth ->
            year1=year
            month1=month+1
            dayOfMonth1=dayOfMonth
        }

        binding.send.setOnClickListener {

            if(year1==0 && month1==0 && dayOfMonth1==0){
                year1 = yearCurrent
                month1 = monthCurrent+1
                dayOfMonth1 = dayOfMonthCurrent
            }

            if(binding.weightUsed.text.isEmpty()){
                val required = getString(R.string.required)
                binding.weightUsed.error = required
                Toast.makeText(context, required, Toast.LENGTH_LONG).show()
            }
            else{
            if(binding.reps.text.isEmpty()){
                val required = getString(R.string.required)
                binding.reps.error = required
                Toast.makeText(context, required, Toast.LENGTH_LONG).show()
            }
                else{
if(binding.sets.text.isEmpty()){
    val required = getString(R.string.required)
    binding.sets.error = required
    Toast.makeText(context, required, Toast.LENGTH_LONG).show()
}
else {
    val weight = binding.weightUsed.text.toString()
    val reps = binding.reps.text.toString()
    val sets = binding.sets.text.toString()
    //var date = parseDouble(binding.weightUsed.toString())

    viewModel.addData(
        BenchData(
            weight, reps, sets, year1,
            month1,
            dayOfMonth1,
        )
    )
    findNavController().navigate(R.id.action_benchInputFragment_to_benchOutputFragment)
}

            }

        }}

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_benchInputFragment_to_launchFragment)

        }
        return binding.root
    }


     //   binding.lifecycleOwner = viewLifecycleOwner
      //  binding.viewModel = viewModel
}