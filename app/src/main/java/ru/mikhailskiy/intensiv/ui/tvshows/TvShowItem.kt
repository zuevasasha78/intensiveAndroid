package ru.mikhailskiy.intensiv.ui.tvshows

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_tv_show.*
import ru.mikhailskiy.intensiv.R
import ru.mikhailskiy.intensiv.data.Movie

class TvShowItem(
    private val content: Movie, //todo пока  Movie потом будет обхект для сериалов
    private val onClick: (movie: Movie) -> Unit
) : Item() {

    override fun getLayout(): Int = R.layout.item_tv_show

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.tv_show_name.text = content.title
        viewHolder.tv_show_rating.rating = content.rating

        viewHolder.tv_content.setOnClickListener {
            onClick.invoke(content)
        }

        Picasso.get()
            .load("https://m.media-amazon.com/images/M/MV5BYTk3MDljOWQtNGI2My00OTEzLTlhYjQtOTQ4ODM2MzUwY2IwXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_.jpg")
            .into(viewHolder.tv_show_image)
    }
}