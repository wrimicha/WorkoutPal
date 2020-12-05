package sheridan.sharm212.workout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sheridan.sharm212.workout.databinding.FragmentJogInputBinding
import sheridan.sharm212.workout.databinding.FragmentLaunchBinding

class JogInputFragment : Fragment() {
    private lateinit var binding: FragmentJogInputBinding
    private val viewModel: JogViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogInputBinding.inflate(inflater, container, false)
        binding.saveJog.setOnClickListener {

val jog = JogData(binding.kmsJogged.text.toString())
            viewModel.submit(jog)


            findNavController().navigate(R.id.action_jogInputFragment_to_jogOutputFragment)
        }
        binding.backIn.setOnClickListener {
            findNavController().navigate(R.id.action_jogInputFragment_to_launchFragment)

        }
       // binding.lifecycleOwner = viewLifecycleOwner
       // binding.viewModel = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }


}