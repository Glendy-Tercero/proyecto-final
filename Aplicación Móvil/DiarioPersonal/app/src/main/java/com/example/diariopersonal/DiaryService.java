package com.example.diariopersonal;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface DiaryService {
    @GET("diario/{uid}")
    Call<List<Diary>> obtenerDiario(@Path("uid") String usuarioUid);

    @GET("diario/{uid}/{fecha}")
    Call<List<Diary>> buscarDiario(@Path("uid") String usuarioUid, @Path("fecha") String fecha);

    @Multipart
    @POST("diario")
    Call<Void> guardarDiario(
            @Part("diario") RequestBody diarioJson,
            @Part MultipartBody.Part imagen
    );

    @Multipart
    @PUT("diario/{diarioKey}")
    Call<Void> editarDiario(
            @Path("diarioKey") String diarioKey,
            @Part("diario") RequestBody diarioJson,
            @Part MultipartBody.Part imagen
    );

    @DELETE("diario/{key}")
    Call<Void> eliminarDiario(@Path("key") String diarioKey);
}
