package de.syntax_institut.filmestreamingservice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import de.syntax_institut.filmestreamingservice.R
import de.syntax_institut.filmestreamingservice.databinding.FragmentDetailBinding


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private var titleId = 0
    private var pictureId = 0
    private var screenId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: lade die benötigten IDs aus den Navigationsargumenten
        arguments?.let {
            titleId = it.getInt("titleId")
            pictureId = it.getInt("pictureId")
            screenId = it.getInt("screenId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // TODO: lade das Layout in die BindingVariable
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val offerText = getString(titleId)

        // TODO: lade den Titel in die TextView
        binding.detailsTextView.text = offerText

        // TODO: lade den Screenshot in die ImageView
        binding.detailsImageView.setImageResource(pictureId)

        // TODO: wenn auf den BackButton geklickt wird soll zurück zum HomeFragment navigiert werden
        binding.floatingActionButton.setOnClickListener {
        view.findNavController().navigateUp()
        }
    }
}
