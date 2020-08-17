package com.testing.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

data class Movie(val title: String, val year: Int)

class MainFragment : Fragment() {

    private val movies = listOf(
        Movie("Killers of the Flower Moon", 2021),
        Movie("Once Upon a Time... In Hollywood", 2019),
        Movie("The Revenant", 2015),
        Movie("The Wolf of Wall Street", 2013),
        Movie("The Great Gatsby", 2013),
        Movie("Django Unchained", 2012),
        Movie("J. Edgar", 2011),
        Movie("Inception", 2010),
        Movie("Shutter Island", 2010),
        Movie("Revolutionary Road", 2008),
        Movie("Body of Lies", 2008),
        Movie("Blood Diamond", 2006),
        Movie("The Departed", 2006),
        Movie("The Aviator", 2004),
        Movie("Catch Me If You Can", 2002),
        Movie("Gangs of New York", 2002),
        Movie("Don's Plum", 2001),
        Movie("The Beach", 2000),
        Movie("Celebrity", 1998),
        Movie("The Man in the Iron Mask", 1998),
        Movie("Marvin's Room", 1996),
        Movie("Romeo + Juliet", 1996),
        Movie("Total Eclipse", 1995),
        Movie("The Quick and the Dead", 1995),
        Movie("The Basketball Diaries", 1995),
        Movie("What's Eating Gilbert Grape", 1993),
        Movie("This Boy's Life", 1993),
        Movie("Critters 3", 1991)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(movies)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}