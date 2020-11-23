package com.projeto_padrao;


import com.projeto_padrao.api.retrofit.RetrofitConfig;
import com.projeto_padrao.models.Usuario;
import com.projeto_padrao.models.chamados.Chamado;
import com.projeto_padrao.models.chamados.Impressora;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListarChamadoCallTest {

    private static Usuario usuarioTeste = new Usuario();


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