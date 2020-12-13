package sheridan.wrimicha.final_project.benchpress.ui.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.JogDataId
import sheridan.wrimicha.final_project.JogUpdateFragment
import sheridan.wrimicha.final_project.JogViewModel
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.benchpress.domain.BenchDataId
import sheridan.wrimicha.final_project.databinding.FragmentBenchUpdateBinding
import sheridan.wrimicha.final_project.databinding.FragmentJogUpdateBinding

class BenchUpdateFragment : Fragment() {

    private val viewModel: BenchViewModel by activityViewModels()

    companion object{
        const val BENCH_INFO = "bench_info"
    }
    var year1 :Int=0
    var month1 :Int=0
    var dayOfMonth1 :Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentBenchUpdateBinding.inflate(inflater, container, false)
        binding.hid.visibility= View.GONE

        binding.benchInfo = arguments?.getSerializable(BenchUpdateFragment.BENCH_INFO) as BenchDataId

        binding.calendarView2.setOnDateChangeListener { view, year, month, dayOfMonth ->
            year1=year
            month1=month+1
            dayOfMonth1=dayOfMonth
        }

        binding.back.setOnClickListener{
            findNavController().navigate(R.id.action_benchUpdateFragment_to_launchFragment)
        }

        binding.dateChange.setOnClickListener{
            binding.hid.visibility= View.VISIBLE
        }

        binding.updateBench.setOnClickListener{

            if(year1==0 && month1==0 && dayOfMonth1==0){

                year1=binding.y2.text.toString().toInt()
                month1=binding.m2.text.toString().toInt()
                dayOfMonth1=binding.d2.text.toString().toInt()
            }

            viewModel.update(BenchDataId(binding.idHolderBench.text.toString().toLong(),binding.weightUsed.text.toString(),binding.reps.text.toString(),binding.sets.text.toString(),year1,month1,dayOfMonth1))
            findNavController().navigate(R.id.action_benchUpdateFragment_to_benchListFragment)
        }

        return binding.root
    }
}