package com.example.retrofitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitrecyclerview.adapter.UserAdapter;
import com.example.retrofitrecyclerview.model.User;
import com.example.retrofitrecyclerview.network.ApiClient;
import com.example.retrofitrecyclerview.network.ApiUser;
import com.example.retrofitt2.R;
import com.example.retrofitt2.adapter.MovieAdapter;
import com.example.retrofitt2.model.Movie;
import com.example.retrofitt2.network.ApiMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Movie> users;
    private RecyclerView recyclerView;
    private MovieAdapter MovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rv_movies);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        showUsers();
    }

    public void showUsers(){
        Call<List<Movie>> call = ApiMovie.get().create(ApiMovie.class).getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    Movie=response.body();
                    MovieAdapter=new Movie()Adapter(movies,getApplicationContext());
                    recyclerView.setAdapter(MovieAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }
}