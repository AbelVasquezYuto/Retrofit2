package com.galaxy.myapplication.apirest;


import com.galaxy.myapplication.model.Cliente;

import java.util.List;

import retrofit2.*;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CrudGalaxyService {

    @GET("clientes")
    Call<Response<List<Cliente>>> obtenerTodoslosClientes();

    @POST("clientes")
    Class<Response<Void>> registrarClientes(@Body Cliente cliente);

    @PUT("clientes/{idCliente}") Call<Response<Void>> actualizarCliente(@Path("idCliente") Integer idCliente,
                                                                        @Body Cliente cliente);
    @DELETE("clientes/{idCliente}") Call<Response<Void>> eliminarCliente(@Path("idCliente") Integer idCliente);

}
