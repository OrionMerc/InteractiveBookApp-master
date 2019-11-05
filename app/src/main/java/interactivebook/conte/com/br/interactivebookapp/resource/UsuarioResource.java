package interactivebook.conte.com.br.interactivebookapp.resource;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.preference.PreferenceActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import interactivebook.conte.com.br.interactivebookapp.config.ApiParams;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class UsuarioResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "/usuario";
    private AsyncHttpClient client;
    private Usuario usuario;
    private Activity activity;
    private AlertDialog dlgCarregando;

    public UsuarioResource(Activity activity){
        this.activity = activity;
        dlgCarregando = (new AlertDialog.Builder(activity)).create();
        dlgCarregando.setTitle("Aguarde");
        dlgCarregando.setMessage("Requisitando banco de dados...");
        dlgCarregando.setCanceledOnTouchOutside(false);
    }

    public void getUsuario(final ArrayAdapter<Usuario> adapterCategoria){
        dlgCarregando.show();

        client = new AsyncHttpClient();
        client.get(BASE_URL + URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);
                Usuario usuario;
                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);
                dlgCarregando.dismiss();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                dlgCarregando.dismiss();
            }
        });
    }

    public void cadastrarUsuario(Usuario u){
        StringEntity entity=null;
        try {
            Gson g = new Gson();
            entity = new StringEntity(g.toJson(u));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client = new AsyncHttpClient();
        client.post(activity.getApplicationContext(), BASE_URL + URL, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);

                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Usuario.class);
                //Toast.makeText(c, ""+usuario.getId(), Toast.LENGTH_SHORT).show();
                if(usuario != null){
                    Toast.makeText(activity, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    activity.finish();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falha ao cadastrar usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
