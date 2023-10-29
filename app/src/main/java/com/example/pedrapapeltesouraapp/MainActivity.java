package com.example.pedrapapeltesouraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.UriMatcherCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra(View view) {
        vereficarGanhador("pedra");

    }
    public void selecionarPapel(View view) {
        vereficarGanhador("papel");

    }
    public void selecionarTesoura(View view) {
        vereficarGanhador("tesoura");

    }
    private String gerarEscolhaAleatoriaDoApp() {

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.image_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){

            case"pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case"papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case"tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }
    private void vereficarGanhador(String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatoriaDoApp();

        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                escolhaApp =="pedra" && escolhaUsuario == "tesoura"||
                escolhaApp =="papel" && escolhaUsuario == "pedra"||
                escolhaApp =="tesoura" && escolhaUsuario == "papel"
        ){
                textoResultado.setText("você Perdeu!!");
        } else if (
                (escolhaUsuario =="pedra" && escolhaApp == "tesoura")||
                (escolhaUsuario =="papel" && escolhaApp == "pedra")||
                (escolhaUsuario =="tesoura" && escolhaApp == "papel")
        ) {
            textoResultado.setText("você Ganhou!!:)");

        }else{
            textoResultado.setText("empate)");



        }


    }


}