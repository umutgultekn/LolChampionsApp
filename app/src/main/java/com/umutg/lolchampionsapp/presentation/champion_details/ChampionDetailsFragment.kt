package com.umutg.lolchampionsapp.presentation.champion_details

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.umutg.lolchampionsapp.R
import com.umutg.lolchampionsapp.common.ErrorDialogListener
import com.umutg.lolchampionsapp.common.Resource
import com.umutg.lolchampionsapp.common.Utils
import com.umutg.lolchampionsapp.common.showErrorDialog
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import com.umutg.lolchampionsapp.databinding.FragmentChampionDetailsBinding
import com.umutg.lolchampionsapp.domain.model.Champion
import com.umutg.lolchampionsapp.presentation.MainActivity
import com.umutg.lolchampionsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class ChampionDetailsFragment :
    BaseFragment<FragmentChampionDetailsBinding>(FragmentChampionDetailsBinding::inflate) {

    private val viewModel: ChampionDetailsViewModel by viewModels()

    private val args: ChampionDetailsFragmentArgs by navArgs()

    private lateinit var favImageSelected: ImageView
    private lateinit var favImageUnselected: ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        favImageSelected = activity?.findViewById<ImageView>(R.id.favImageSelected)!!
        favImageUnselected = activity?.findViewById<ImageView>(R.id.favImageUnselected)!!

        favImageSelected.visibility = View.VISIBLE

        viewModel.isFavoriteChampion.observe(viewLifecycleOwner) { isFavorite ->

            if (isFavorite) {

                favImageUnselected.visibility = View.GONE
                favImageSelected.visibility = View.VISIBLE

            } else {

                favImageSelected.visibility = View.GONE
                favImageUnselected.visibility = View.VISIBLE
            }
        }

        favImageSelected.setOnClickListener {
            isFavImageSelected(false)
        }

        favImageUnselected.setOnClickListener {
            isFavImageSelected(true)
        }

        viewModel.championDetail.observe(viewLifecycleOwner) { state ->

            when (state) {

                is Resource.Success -> {

                    state.data?.map {
                        setChampionDetailsData(it)
                        binding.clChampionDetails.visibility = View.VISIBLE
                    }
                    binding.progressBar.visibility = View.GONE


                }
                is Resource.Error -> {

                    showErrorDialog(requireContext(), state.message, object : ErrorDialogListener {
                        override fun onTryAgain() {
                            viewModel.loadChampionDetails()
                        }
                    })

                    binding.progressBar.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.progressBar.progress
                }
            }

        }
    }

    private fun isFavImageSelected(selected: Boolean) {

        val favoriteChampionEntity = FavoriteChampionEntity(
            args.champions.id,
            args.champions.name,
            args.champions.title,
            args.champions.image
        )

        if (selected) {

            favImageUnselected.visibility = View.GONE
            favImageSelected.visibility = View.VISIBLE

            viewModel.addToFavorites(favoriteChampionEntity)

            Toast.makeText(
                context,
                "${args.champions.name} added to favorites.",
                Toast.LENGTH_SHORT
            ).show()

        } else {

            favImageSelected.visibility = View.GONE
            favImageUnselected.visibility = View.VISIBLE

            viewModel.deleteFromFavorites(favoriteChampionEntity)

            Toast.makeText(
                context,
                "${args.champions.name} removed from favorites.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun setChampionDetailsData(champion: Champion) {

        loadImage(binding.championImage, Utils.convertChampionDetailsImageUrl(champion.id), false)

        loadImage(
            binding.championSpellOneImage,
            Utils.convertChampionSpellImageUrl(champion.championSpell[0].image.full),
            true
        )

        loadImage(
            binding.championSpellTwoImage,
            Utils.convertChampionSpellImageUrl(champion.championSpell[1].image.full),
            true
        )

        loadImage(
            binding.championSpellThreeImage,
            Utils.convertChampionSpellImageUrl(champion.championSpell[2].image.full),
            true
        )

        loadImage(
            binding.championSpellFourImage,
            Utils.convertChampionSpellImageUrl(champion.championSpell[3].image.full),
            true
        )

        binding.championLoreText.text = champion.lore
    }


    private fun loadImage(imageView: AppCompatImageView, url: String, circle: Boolean) {


        val requestBuilder: RequestBuilder<Drawable> =
            Glide.with(imageView).asDrawable().sizeMultiplier(0.05f).circleCrop()

        val requestOptions = RequestOptions()

        if (circle) requestOptions.circleCrop()



        Glide.with(this).load(url).apply(requestOptions).thumbnail(requestBuilder)
            .transition(DrawableTransitionOptions.withCrossFade()).into(imageView)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).supportActionBar?.title =
            args.champions.name + " " + args.champions.title

    }

    override fun onDestroyView() {
        super.onDestroyView()
        favImageSelected.visibility = View.GONE
        favImageUnselected.visibility = View.GONE

    }

}