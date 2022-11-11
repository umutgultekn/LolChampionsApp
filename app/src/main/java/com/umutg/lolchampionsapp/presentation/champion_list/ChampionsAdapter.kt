package com.umutg.lolchampionsapp.presentation.champion_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.umutg.lolchampionsapp.common.Utils
import com.umutg.lolchampionsapp.databinding.ChampionsItemBinding
import com.umutg.lolchampionsapp.domain.model.Champions


class ChampionsAdapter(private val champions: List<Champions>) :
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

                binding.name.text = this.name
                binding.title.text = this.title

                Glide.with(context)
                    .load(Utils.convertImageUrl(this.image))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.image)

            }
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = champions.size

}