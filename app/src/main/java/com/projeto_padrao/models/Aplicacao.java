package com.projeto_padrao.models;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.projeto_padrao.activities.chamados.ChamadoDetalheActivity;
import com.projeto_padrao.activities.chamados.CriarChamadoActivity;
import com.projeto_padrao.activities.chamados.ChamadosActivity;
import com.projeto_padrao.activities.autenticacao.LoginActivity;
import com.projeto_padrao.activities.autenticacao.RegisterActivity;
import com.projeto_padrao.activities.usuario.ListarUsuariosActivity;
import com.projeto_padrao.activities.usuario.UsuarioDetalheActivity;

import java.net.InetAddress;


public class Aplicacao {

    private Context context;
    private Class<?> activityDestino;



    public Aplicacao(Context context, Class<?> activityDestino) {
        this.context = context;
        this.activityDestino = activityDestino;
    }


    public Aplicacao(Context context) {
        this.context = context;
    }

    public static void irParaListarUsuariosActivity(Context context) {
        Intent intent = new Intent(context, ListarUsuariosActivity.class);
        context.startActivity(intent);

    }



    public static void irParaChamadoDetalheActivity(Context context, Long id) {
        Intent intent = new Intent(context, ChamadoDetalheActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", id);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public static void irParaListarLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void irParaAppActivity(Context context) {
        Intent intent = new Intent(context, ChamadosActivity.class);
        context.startActivity(intent);
    }

    public static void irParaRegisterActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    public static void irParaLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    
    public static void irParaUsuarioDetalheActivity(Context context, Long id) {
        Intent intent = new Intent(context, UsuarioDetalheActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", id);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public static void irParaChamadosActivity(Context context) {
        Intent intent = new Intent(context, ChamadosActivity.class);
        context.startActivity(intent);
    



}

public static void irParaCriarChamadoActivity(Context context){
        Intent intent = new Intent(context, CriarChamadoActivity.class);
        context.startActivity(intent);

}





    public static void fecharApp(Context context) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(homeIntent);
    }

    public static void aguardar(int time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }



}
