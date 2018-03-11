package com.juborajsarker.locationfinder.ApiService;

import com.juborajsarker.locationfinder.java_class.ModelPlace;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


/**
 * Created by jubor on 3/8/2018.
 */

public interface Api   {

    String BASE_URL = "https://maps.googleapis.com/maps/api/place/search/";

   // String REST_URL = "=false&key=AIzaSyCyKugNDY5CdTwYmpcYSZ1xcI0jhkQRQ70";




    @GET
    Call<ModelPlace> getResults(@Url String url);

}
