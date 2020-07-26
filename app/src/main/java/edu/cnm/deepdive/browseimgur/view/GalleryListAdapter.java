package edu.cnm.deepdive.browseimgur.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.browseimgur.R;
import edu.cnm.deepdive.browseimgur.model.Gallery;
import edu.cnm.deepdive.browseimgur.model.Image;
import java.util.ArrayList;
import java.util.List;

public class GalleryListAdapter extends
    RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {

  private final Context context;
  private final List<Gallery> galleries;
  private final OnItemSelectedHelper onItemSelectedHelper;

  public GalleryListAdapter(Context context, List<Gallery> galleries,
      OnItemSelectedHelper onItemSelectedHelper) {
    super();
    this.context = context;
    this.galleries = galleries;
    this.onItemSelectedHelper = onItemSelectedHelper;
  }

  @NonNull
  @Override
  public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_gallery_search, parent, false);
    return new GalleryViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return galleries.size();
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder implements OnItemSelectedListener {

    private final TextView title;
    private final TextView description;
    private final Spinner imageSpinner;

    private Gallery gallery;
    public List<Image> withIconList = new ArrayList<>();
    String imageUrl = "" + R.drawable.gallery;
    private final Image galleryIcon = new Image(imageUrl);
    private boolean handleSelection;

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.gallery_title);
      description = itemView.findViewById(R.id.gallery_description);
      imageSpinner = itemView.findViewById(R.id.gallery_search_spinner);
    }

    private void bind(int position) {
      gallery = galleries.get(position);
      withIconList.clear();
      withIconList.add(galleryIcon);
      withIconList.addAll(gallery.getImages());
      title.setText(gallery.getTitle());
      description.setText(gallery.getDescription());
      GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(context,
          withIconList);
      imageSpinner.setAdapter(galleryImageAdapter);
//      handleSelection = false;
      imageSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      if (position > 0) {
        onItemSelectedHelper.onSelected(gallery, gallery.getImages().get(position-1));
      }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
  }

  public interface OnItemSelectedHelper {

    void onSelected(Gallery gallery, Image image);
  }

}
