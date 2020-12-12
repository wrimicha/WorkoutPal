package sheridan.wrimicha.final_project

import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.databinding.FragmentJogUpdateBinding
import java.lang.StringBuilder
import java.text.SimpleDateFormat


class JogUpdateFragment : Fragment() {

    private val viewModel: JogViewModel by activityViewModels()
    companion object{
        const val JOG_INFO = "jog_info"
    }
    var year1 :Int=0
    var month1 :Int=0
    var dayOfMonth1 :Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding = FragmentJogUpdateBinding.inflate(inflater, container, false)

        binding.jogInfo = arguments?.getSerializable(JOG_INFO) as JogDataId

        binding.cView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            year1=year
            month1=month+1
            dayOfMonth1=dayOfMonth
        }
        binding.hiding.visibility= GONE
//Test Code
binding.changeDate.setOnClickListener{
    binding.hiding.visibility= VISIBLE
    println("I am here bud")
}

        binding.back.setOnClickListener{
            findNavController().navigate(R.id.action_jogUpdateFragment_to_launchFragment)
        }
        //

        binding.updateJog.setOnClickListener{

            if(year1==0 && month1==0 && dayOfMonth1==0){

                year1=binding.y1.text.toString().toInt()
                month1=binding.m1.text.toString().toInt()
                dayOfMonth1=binding.d1.text.toString().toInt()
            }

            viewModel.update(JogDataId(binding.idHolder.text.toString().toLong(),binding.kmsJogged.text.toString(),year1,month1,dayOfMonth1,binding.duration.text.toString()))
        findNavController().navigate(R.id.action_jogUpdateFragment_to_historyFragment)
        }

        return binding.root
    }

}