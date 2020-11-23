package com.projeto_padrao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.projeto_padrao.R;
import com.projeto_padrao.models.Aplicacao;
import com.projeto_padrao.models.Usuario;

public class StartActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        imageView=(ImageView)findViewById(R.id.img);

        Glide.with(StartActivity.this).load(R.drawable.loading_processmaker).asGif().into(imageView);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(Usuario.verificaUsuarioLogado()!=null){
                    Aplicacao.irParaChamadosActivity(StartActivity.this);
                }else {
                    Aplicacao.irParaLoginActivity(StartActivity.this);
                }
                finish();
            }
        }, 1500);
/*


 */
    }
}