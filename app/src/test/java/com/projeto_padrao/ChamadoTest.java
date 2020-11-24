package com.projeto_padrao;

import com.projeto_padrao.api.retrofit.RetrofitConfig;
import com.projeto_padrao.models.Usuario;
import com.projeto_padrao.models.chamados.Chamado;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ChamadoTest {

    private static Usuario usuarioTeste = new Usuario();
    private static Chamado chamadoTeste = new Chamado();

    @Test
    public void A_criarChamados() {

        RetrofitCallTest retrofitCallTest = new RetrofitCallTest();
        usuarioTeste = retrofitCallTest.B_login_Success();


        chamadoTeste.setTitulo("titulo");
        chamadoTeste.setDescricao("descricao");
        chamadoTeste.setImpressora(2);


        Call<Chamado> call = new RetrofitConfig().setChamadoService().criarChamado("Token " + usuarioTeste.getKey(), chamadoTeste);
        try {
            //Magic is here at .execute() instead of .enqueue()
            Response<Chamado> response = call.execute();
            Chamado chamado = response.body();

            if (response.isSuccessful()) {
                assertNotNull(chamado);
                chamadoTeste.setId(chamado.getId());
                chamadoTeste.setHorarioAbertura(chamado.getHorarioAbertura());
                chamadoTeste.setDataAbertura(chamado.getDataAbertura());
            } else {
                fail();
            }


        } catch (IOException e) {
            fail();
            e.printStackTrace();
        }


    }
    @Test
    public void A_deletarChamados() {

        RetrofitCallTest retrofitCallTest = new RetrofitCallTest();
        usuarioTeste = retrofitCallTest.B_login_Success();


        chamadoTeste.setTitulo("titulo");
        chamadoTeste.setDescricao("descricao");
        chamadoTeste.setImpressora(2);


        Call<Chamado> call = new RetrofitConfig().setChamadoService().deletarChamado("Token " + usuarioTeste.getKey(), chamadoTeste.getId() );
        try {
            //Magic is here at .execute() instead of .enqueue()
            Response<Chamado> response = call.execute();
            Chamado chamado = response.body();

            if (response.isSuccessful()) {
                assertNotNull(chamado);
                chamadoTeste.setId(chamado.getId());

                chamadoTeste.delete();

            } else {
                fail();
            }


        } catch (IOException e) {
            fail();
            e.printStackTrace();
        }


    }
    @Test
    public void A_listarChamados() {

        RetrofitCallTest retrofitCallTest = new RetrofitCallTest();
        usuarioTeste =retrofitCallTest.B_login_Success();


        Call<List<Chamado>> call = new RetrofitConfig().setChamadoService().listarChamados("Token " + usuarioTeste.getKey());
        try {
            //Magic is here at .execute() instead of .enqueue()
            Response<List<Chamado>> response = call.execute();
            List<Chamado> chamados = response.body();

            if (response.isSuccessful()){
                assertNotNull(chamados);
            }else {
                fail();
            }


        } catch (IOException e) {
            fail();
            e.printStackTrace();
        }
    }



}
