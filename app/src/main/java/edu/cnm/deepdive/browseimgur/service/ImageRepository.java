//package edu.cnm.deepdive.browseimgur.service;
//
//import android.content.Context;
//import android.os.Bundle;
//import androidx.lifecycle.LiveData;
//import edu.cnm.deepdive.browseimgur.BuildConfig;
//import edu.cnm.deepdive.browseimgur.model.Gallery;
//import edu.cnm.deepdive.browseimgur.model.Gallery.SearchResult;
//import edu.cnm.deepdive.browseimgur.model.Image;
//import io.reactivex.Single;
//import io.reactivex.functions.Function;
//import io.reactivex.schedulers.Schedulers;
//import java.util.List;
//import java.util.Map;
//
//public class ImageRepository {
//
//  private final Context context;
//  private final ImgurService service;
//  private final Bundle bundle;
//
//  public ImageRepository(Context context) {
//    this.context = context;
//    service = ImgurService.getInstance();
//    bundle = new Bundle();
//  }
//
//  public Single<Gallery.SearchResult> getSearch() {
//    return service.getSearchResult(BuildConfig.CLIENT_ID,
//        "fish AND sharks")
//        .subscribeOn(Schedulers.io());
//  }
//
////  public LiveData<Map<String, Image>> getAllImages() {
////    return bundle.getStr.selectAll();
////  }
//}
