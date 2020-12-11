package sheridan.wrimicha.final_project

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
import java.util.*

class JogInputFragment : Fragment() {
    private lateinit var binding: FragmentJogInputBinding
    private val viewModel: JogViewModel by activityViewModels()

    var year1 :Int=0
    var month1 :Int=0
    var dayOfMonth1 :Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogInputBinding.inflate(inflater, container, false)


        val c = Calendar.getInstance()
val yearCurrent = c.get(Calendar.YEAR)
val monthCurrent = c.get(Calendar.MONTH)
val dayOfMonthCurrent = c.get(Calendar.DAY_OF_MONTH)

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            year1=year
            month1=month+1
            dayOfMonth1=dayOfMonth
        }




        binding.saveJog.setOnClickListener {

            if(year1==0 && month1==0 && dayOfMonth1==0){
               year1 = yearCurrent
                month1 = monthCurrent+1
                dayOfMonth1 = dayOfMonthCurrent
            }

val jog = JogData(binding.kmsJogged.text.toString(),year1,month1,dayOfMonth1,binding.duration.text.toString())
            viewModel.submit(jog)


            findNavController().navigate(R.id.action_jogInputFragment_to_jogOutputFragment)
        }
        binding.backIn.setOnClickListener {
            findNavController().navigate(R.id.action_jogInputFragment_to_launchFragment)

        }
     //   binding.lifecycleOwner = viewLifecycleOwner
      //  binding.viewModel = viewModel

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_jog, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.action_history -> {
                findNavController().navigate(R.id.action_global_to_history)
                true
            }
            else-> super.onOptionsItemSelected(item)
        }
    }

}