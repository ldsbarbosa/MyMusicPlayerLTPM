package com.example.mymusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ListView listView;
    List<Musica> listaMusica;
    ArrayAdapter<Musica> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.id_list_view);
        listaMusica = new ArrayList<>();
        listaMusica.add(new Musica("Into", R.raw.into));
        listaMusica.add(new Musica("Lofi", R.raw.lofi));
        listaMusica.add(new Musica("Morning", R.raw.morning));
        listaMusica.add(new Musica("TheBeat", R.raw.thebeat));
        listaMusica.add(new Musica("Pausar", -1));
        adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, listaMusica);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Musica musicaSelecionada = listaMusica.get(i);
                if(musicaSelecionada.getId() == -1){
                    mediaPlayer.stop();
                    return;
                }
                int audioId = musicaSelecionada.getId();
                //Libera os recursos do MediaPlayer
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                //Criar o MediaPlayer com a faixa da música selecionada
                mediaPlayer = MediaPlayer.create(MainActivity.this, audioId);
                //Iniciar a reprodução da musica
                mediaPlayer.start();
            }
        });
    }
}