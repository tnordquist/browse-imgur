package edu.cnm.deepdive.browseimgur.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.browseimgur.R;
import edu.cnm.deepdive.browseimgur.model.Image;
import edu.cnm.deepdive.browseimgur.view.GalleryImageAdapter;
import java.util.List;
import java.util.Objects;

public class ImageDetailDialogFragment extends DialogFragment {

  private AlertDialog dialog;
  private View root;
  private ImageView imageView;
  private TextView title;
  private TextView description;

  private List<Image> images;
  private GalleryImageAdapter adapter;
  private Image image;

  public static ImageDetailDialogFragment newInstance(Image image) {
    ImageDetailDialogFragment fragment = new ImageDetailDialogFragment();
    Bundle args = new Bundle();
    args.putSerializable("image", image);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      image = (Image) getArguments().getSerializable("image");
    }
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    root = LayoutInflater.from(getContext())
        .inflate(R.layout.fragment_image_detail_dialog, null, false);
    imageView = root.findViewById(R.id.image_detail);
    title = root.findViewById(R.id.image_title);
    description = root.findViewById(R.id.image_description);
    if (image.getUrl() != null) {
      Picasso.get().load(image.getUrl()).into(imageView);
    }
    title.setText((image.getTitle() != null) ? image.getTitle() : "");
    description.setText((image.getDescription() != null) ? image.getDescription() : "");
    dialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()))
        .setTitle("Gallery Image")
        .setView(root)
        .create();
    return dialog;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return null;
  }

}
