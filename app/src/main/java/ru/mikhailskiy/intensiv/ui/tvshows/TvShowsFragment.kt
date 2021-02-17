package ru.mikhailskiy.intensiv.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.tv_shows_fragment.*
import ru.mikhailskiy.intensiv.R
import ru.mikhailskiy.intensiv.data.MockRepository

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TvShowsFragment : Fragment() {

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tv_shows_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Добавляем recyclerView
        tv_show_recycler_view.layoutManager = LinearLayoutManager(context)
        tv_show_recycler_view.adapter = adapter.apply { addAll(listOf()) }

        // Используя Мок-репозиторий получаем фэйковый список фильмов
        tv_show_recycler_view.adapter = adapter.apply {
            addAll(
                listOf(
                    TvShowItem(
                        MockRepository.getMovies()[0], {}),
                    TvShowItem(
                        MockRepository.getMovies()[0], {})
                )
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TvShowsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}