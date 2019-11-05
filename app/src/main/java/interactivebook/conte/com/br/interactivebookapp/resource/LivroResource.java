package interactivebook.conte.com.br.interactivebookapp.resource;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.config.ApiParams;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class LivroResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "livro/";
    private AsyncHttpClient client;
    private Livro livro;
    private String resJSON;
    private Activity activity;
    private AlertDialog dlgCarregando;

    public LivroResource(Activity activity) {
        this.activity = activity;
        dlgCarregando = (new AlertDialog.Builder(activity)).create();
        dlgCarregando.setTitle("Aguarde");
        dlgCarregando.setMessage("Requisitando banco de dados...");
        dlgCarregando.setCanceledOnTouchOutside(false);
    }

    public void buscaLivroPorId(Long id, final ArrayAdapter<Livro> livrosAdapter){
        client = new AsyncHttpClient();

        dlgCarregando.show();

        client.get(BASE_URL + URL + id, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                resJSON = new String(bytes);
                //Usuario usuario;
                Gson gson = new Gson();
                livro = gson.fromJson(resJSON, Livro.class);
                livrosAdapter.add(livro);
                dlgCarregando.dismiss();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                livro = null;
                dlgCarregando.dismiss();
            }
        });
    }
}
