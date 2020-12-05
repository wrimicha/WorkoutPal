package sheridan.sharm212.workout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.sharm212.workout.databinding.FragmentJogInputBinding
import sheridan.sharm212.workout.databinding.FragmentJogOutputBinding

class JogOutputFragment : Fragment() {
    private lateinit var binding: FragmentJogOutputBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJogOutputBinding.inflate(inflater, container, false)

        binding.backOut.setOnClickListener {
            findNavController().navigate(R.id.action_jogOutputFragment_to_launchFragment)

        }

        // Inflate the layout for this fragment
        return binding.root
    }

}