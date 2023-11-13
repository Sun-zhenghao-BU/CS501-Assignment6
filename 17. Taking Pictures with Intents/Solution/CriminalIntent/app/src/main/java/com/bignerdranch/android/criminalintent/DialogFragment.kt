package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.squareup.picasso.Picasso
import java.io.File


class ZoomedPhotoDialogFragment : DialogFragment() {

    override fun onCreateView (inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
        val view = inflater.inflate(R.layout.fragment_zoomed_photo, container, false)
        val imageView : ImageView = view.findViewById(R.id.zoomedImageView)

        // Load the image into the ImageView
        val photoPath = arguments?.getString("photoPath")
        val photoFile = File(photoPath)
        Log.d("ZoomedPhotoDialog", "Photo path: $photoPath")

        if (photoFile.exists()) {
            // Load the image using your preferred method
            // Example: Use Glide or Picasso libraries to load images efficiently
            Picasso.get().load(photoFile).into(imageView)
        } else {
            Log.d("ZoomedPhotoDialog", "File does not exist")
        }
        return view
    }

    companion object {
        fun newInstance(photoPath: String): ZoomedPhotoDialogFragment {
            val args = Bundle().apply {
                putString("photoPath", photoPath)
            }
            return ZoomedPhotoDialogFragment().apply {
                arguments = args
            }
        }
    }
}