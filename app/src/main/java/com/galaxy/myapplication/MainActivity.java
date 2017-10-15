package com.galaxy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.galaxy.myapplication.apirest.CrudGalaxyService;
import com.galaxy.myapplication.apirest.Response;
import com.galaxy.myapplication.apirest.RetrofitUtil;
import com.galaxy.myapplication.model.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrudGalaxyService service = RetrofitUtil.getInstance().create(CrudGalaxyService.class);

        Call<Response<List<Cliente>>> responseCall = service.obtenerTodoslosClientes();

        responseCall.enqueue(new Callback<Response<List<Cliente>>>() {
            @Override
            public void onResponse(Call<Response<List<Cliente>>> call, retrofit2.Response<Response<List<Cliente>>> response) {
                if (response.isSuccessful()){
                    Response<List<Cliente>> respuestaServicio = response.body();
                    if (respuestaServicio.status){
                        List<Cliente> listaClientes = respuestaServicio.body.data;

                        for (Cliente cliente: listaClientes){
                            Log.i("CLIENTE",cliente.getName()+cliente.getLastName());
                        }

                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Ocurrio un erroe al obtener los clientes", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response<List<Cliente>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
