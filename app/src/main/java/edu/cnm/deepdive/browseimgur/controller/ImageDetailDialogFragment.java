package edu.cnm.deepdive.browseimgur.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
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
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ImageDetailDialogFragment extends DialogFragment {

  private AlertDialog dialog;
  private View root;
  private TextView title;
  private TextView description;
  private TextView imageId;
  private TextView imageUrl;
  private TextView imageDateTime;
  private TextView imageType;
  private TextView imageWidth;
  private TextView imageHeight;
  private TextView imageViews;
  private TextView imageBandWidth;

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
    ImageView imageView = root.findViewById(R.id.image_detail);
//    title = root.findViewById(R.id.image_title);
    description = root.findViewById(R.id.image_description);
    imageId = root.findViewById(R.id.image_id);
    imageUrl = root.findViewById(R.id.image_url);
    imageDateTime = root.findViewById(R.id.image_datetime);
    imageType = root.findViewById(R.id.image_type);
    imageWidth = root.findViewById(R.id.image_width);
    imageHeight = root.findViewById(R.id.image_height);
    imageViews = root.findViewById(R.id.image_views);
    imageBandWidth = root.findViewById(R.id.image_bandwidth);

    if (image.getUrl() != null) {
      Picasso.get().load(image.getUrl()).into(imageView);
    }
//    title.setText((image.getTitle() != null) ? image.getTitle() : "Title Not Available");
    description
        .setText((image.getDescription() != null) ? image.getDescription() : "Description N/A");
    imageId.setText((image.getImageId() != null) ? "Id: " + image.getImageId() : "Image Id N/A");
    imageUrl.setText((image.getUrl() != null) ? "Image Url: " + image.getUrl() : "Url N/A");
    imageDateTime.setText(
        (image.getImageDateTime() != null) ? "Submitted: " + (convertTime(image.getImageDateTime()))
            : "DateTime N/A");
    imageType.setText((image.getType() != null) ? "Type of Image: " + image.getType() : "Image Type N/A");
    imageWidth
        .setText((image.getWidth() != null) ? "Width: " + (image.getWidth()) : "Image Width N/A");
    imageHeight.setText(
        (image.getDescription() != null) ? "Height: " + (image.getHeight()) : "Image Height N/A");
    imageViews.setText(
        (image.getViews() != null) ? "Views: " + (image.getViews()) : "Number of Views N/A");
    imageBandWidth.setText(
        (image.getBandwidth() != null) ? "Bandwidth: " + (image.getBandwidth()) : "Bandwidth N/A");
    dialog = new AlertDialog.Builder(Objects.requireNonNull(getContext()))
        .setTitle((image.getTitle() != null) ? image.getTitle() : "Untitled")
        .setView(root)
        .setPositiveButton(R.string.close_image_detail_dialog, (dlg, which) -> {})
        .create();
    return dialog;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return null;
  }

  /**
   * Source: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
   * @param epoch
   * @return String epoch form converted to date and time
   */
  private String convertTime(long epoch) {
//    String date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss z")
//        .format(new java.util.Date(epoch * 1000));
    return new java.text.SimpleDateFormat("MMMM-dd-yyyy hh:mm aa z")
        .format(new java.util.Date(epoch * 1000));
  }
}
