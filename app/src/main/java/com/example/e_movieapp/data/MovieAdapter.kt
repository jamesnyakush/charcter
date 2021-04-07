package com.example.e_movieapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_movieapp.R

abstract class MovieAdapter (var Movielist: List<UserMovie>, var movieItemClickListener: MovieItemClickListener) :
    RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_display, parent, false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Movielist.size
    }

//    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
//        holder.rowView.edTitle.text = Movielist[position].title
//        holder.rowView.edYear.text =Movielist[position].year
//        holder.rowView.edRate.text = Movielist[position].rate
//        holder.rowView.edReview.text =Movielist[position].review
//        holder.rowView.edDirector.text = Movielist[position].director
//        holder.rowView.edActors.text = Movielist[position].actors
//
//        holder.rowView.btnSave.setOnClickListener {
//            movieItemClickListener.onItemClick(Movielist[position])
//        }
//    }

    class MoviesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}