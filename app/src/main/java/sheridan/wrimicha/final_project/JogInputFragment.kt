package sheridan.wrimicha.final_project

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import java.text.SimpleDateFormat
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

          if(binding.kmsJogged.text.isEmpty()){
                val required = getString(R.string.required)
                binding.kmsJogged.error = required
                Toast.makeText(context, required, Toast.LENGTH_LONG).show()
            }

               else if(binding.duration.text.isEmpty()){
                    val required = getString(R.string.required)
                    binding.duration.error = required
                    Toast.makeText(context, required, Toast.LENGTH_LONG).show()
                }
else{
                val jog = JogData(
                    binding.kmsJogged.text.toString(),
                    year1,
                    month1,
                    dayOfMonth1,
                    binding.duration.text.toString()
                )
                viewModel.submit(jog)


                findNavController().navigate(R.id.action_jogInputFragment_to_jogOutputFragment)
            }}
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