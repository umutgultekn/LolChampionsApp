package com.umutg.lolchampionsapp.presentation.champion_list

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.umutg.lolchampionsapp.R
import com.umutg.lolchampionsapp.common.Utils
import com.umutg.lolchampionsapp.databinding.ChampionsItemBinding
import com.umutg.lolchampionsapp.domain.model.Champions


class ChampionsAdapter(
    private val champions: List<Champions>,
    private val listener: ChampionsItemClickListener
) :
    RecyclerView.Adapter<ChampionsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(val binding: ChampionsItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item

        val binding =
            ChampionsItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        val context = viewGroup.context

        return ViewHolder(binding, context)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        with(viewHolder) {
            with(champions[position]) {

                binding.championCardView.setOnClickListener {
                    listener.onClicked(this)
                }
                binding.name.text = this.name
                binding.title.text = this.title


                val requestBuilder: RequestBuilder<Drawable> = Glide.with(binding.image)
                    .asDrawable().sizeMultiplier(0.05f)

                val shimmer =
                    Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
                        .setDuration(1800) // how long the shimmering animation takes to do one full sweep
                        .setBaseAlpha(0.7f) //the alpha of the underlying children
                        .setHighlightAlpha(0.6f) // the shimmer alpha amount
                        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                        .setAutoStart(true)
                        .build()


                val shimmerDrawable = ShimmerDrawable().apply {
                    setShimmer(shimmer)
                }

                Glide.with(context)
                    .load(Utils.convertImageUrl(this.image))
                    .thumbnail(requestBuilder)
                    .placeholder(shimmerDrawable)
                    .error(AppCompatResources.getDrawable(context, R.drawable.champion_image))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.image)

            }
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = champions.size

}