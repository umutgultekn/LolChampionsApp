package com.umutg.lolchampionsapp.presentation.favorite_champions

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.umutg.lolchampionsapp.common.Utils
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import com.umutg.lolchampionsapp.databinding.FavoriteChampionsItemBinding


class FavoriteChampionsAdapter :
    ListAdapter<FavoriteChampionEntity, FavoriteChampionsAdapter.ViewHolder>(
        FAVORITE_CHAMPION_COMPARATOR
    ) {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(val binding: FavoriteChampionsItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item

        val binding = FavoriteChampionsItemBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        val context = viewGroup.context

        return ViewHolder(binding, context)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val favoriteChampionEntity = getItem(position)

        with(viewHolder) {

            binding.name.text = favoriteChampionEntity.name
            binding.title.text = favoriteChampionEntity.title


            val requestBuilder: RequestBuilder<Drawable> =
                Glide.with(binding.image).asDrawable().sizeMultiplier(0.05f)

            Glide.with(context).load(Utils.convertImageUrl(favoriteChampionEntity.image))
                .thumbnail(requestBuilder).transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.image)
        }

    }


    companion object {

        private val FAVORITE_CHAMPION_COMPARATOR =
            object : DiffUtil.ItemCallback<FavoriteChampionEntity>() {
                override fun areItemsTheSame(
                    oldItem: FavoriteChampionEntity,
                    newItem: FavoriteChampionEntity
                ): Boolean {
                    return oldItem === newItem
                }

                override fun areContentsTheSame(
                    oldItem: FavoriteChampionEntity,
                    newItem: FavoriteChampionEntity
                ): Boolean {
                    return oldItem.id == newItem.id &&
                            oldItem.title == newItem.title &&
                            oldItem.image == newItem.image &&
                            oldItem.name == newItem.name
                }
            }
    }

}