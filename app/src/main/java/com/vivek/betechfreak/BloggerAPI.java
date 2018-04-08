package com.vivek.betechfreak;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerAPI {

    private static final String key = "AIzaSyBlMu9teQ_s7e6GQCVocEGuu3ytahWCXjQ";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/4604901800092162228/posts/";

    public static PostService postService = null;

    public static PostService getPostService() {
        if (postService == null) {

            //created
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService=retrofit.create(PostService.class);
        }
        return postService;
    }


    public interface PostService {
        @GET("?key=" + key)
        Call<PostList> getPostList();

      /*  @GET("{postId}/key="+key)
        Call<Item> getPostById(@Path("postId") String id);
*/
    }
}
