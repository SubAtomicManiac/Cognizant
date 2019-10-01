package com.example.cognizantchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cognizantchallenge.R
import com.example.cognizantchallenge.dataclass.Album
import com.example.cognizantchallenge.ui.AlbumsAdapter.AlbumViewHolder
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumsAdapter(val albums: MutableList<Album>):RecyclerView.Adapter<AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_album,parent,false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.albumTitle.text = album.title

    }


    class AlbumViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var albumTitle = itemView.tv_album_title
    }
}