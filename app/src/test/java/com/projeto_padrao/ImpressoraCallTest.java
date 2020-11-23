package com.projeto_padrao;


import com.projeto_padrao.api.retrofit.RetrofitConfig;
import com.projeto_padrao.models.Usuario;
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
public class ImpressoraCallTest {

    private static Usuario usuarioTeste = new Usuario();


    @Test
    public void A_listarImpressoras() {

        RetrofitCallTest retrofitCallTest = new RetrofitCallTest();
        usuarioTeste =retrofitCallTest.B_login_Success();


        Call<List<Impressora>> call = new RetrofitConfig().setImpressoraService().listarImpressoras("Token " + usuarioTeste.getKey());

        try {
            //Magic is here at .execute() instead of .enqueue()
            Response<List<Impressora>> response = call.execute();
            List<Impressora> impressoras = response.body();

            if (response.isSuccessful()){
                assertNotNull(impressoras);
            }else {
                fail();
            }


        } catch (IOException e) {
            fail();
            e.printStackTrace();
        }
    }
}