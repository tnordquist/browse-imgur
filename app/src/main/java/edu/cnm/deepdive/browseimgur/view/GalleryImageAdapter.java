package edu.cnm.deepdive.browseimgur.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.browseimgur.R;
import edu.cnm.deepdive.browseimgur.model.Image;
import java.util.List;

public class GalleryImageAdapter extends ArrayAdapter<Image> {

  public GalleryImageAdapter(@NonNull Context context, List<Image> imageItemArray) {
    super(context, 0, imageItemArray);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return (convertView != null && convertView.findViewById(R.id.spinner_placeholder) != null)
        ? convertView : LayoutInflater.from(getContext()).inflate(
        R.layout.item_gallery_image_placeholder, parent, false);
  }

  @Nullable
  @Override
  public View getDropDownView(int position, @Nullable View convertView,
      @NonNull ViewGroup parent) {
    if (position == 0) {
      return (convertView != null && convertView.findViewById(R.id.spinner_unselectable) != null)
           ? convertView : LayoutInflater.from(getContext()).inflate(
           R.layout.item_gallery_image_unselectable, parent, false);
    } else {
      return initView(position, convertView, parent);
    }
  }

  private View initView(int position, View convertview, ViewGroup parent) {
    if (convertview == null || convertview.findViewById(R.id.modal_image_spinner) == null) {
      convertview = LayoutInflater.from(getContext()).inflate(
          R.layout.item_gallery_image, parent, false
      );
    }
    ImageView imageView = convertview.findViewById(R.id.image_gallery_search);
    TextView titleView = convertview.findViewById(R.id.custom_title);
    TextView descriptionView = convertview.findViewById(R.id.custom_description);

    Image currentItem = getItem(position);

    if (currentItem.getUrl() != null) {
      if (position == 0) {
        Picasso.get().load(R.drawable.gallery).into(imageView);
      } else {
        Picasso.get().load(currentItem.getUrl()).into(imageView);
      }
    }
    if (currentItem.getTitle() != null) {
      titleView.setText(currentItem.getTitle());
    } else {
      titleView.setText("Untitled");

    }
    if (currentItem.getDescription() != null) {
      descriptionView.setText(currentItem.getDescription());
    } else {
      descriptionView.setText("No description");
    }

    return convertview;
  }
}