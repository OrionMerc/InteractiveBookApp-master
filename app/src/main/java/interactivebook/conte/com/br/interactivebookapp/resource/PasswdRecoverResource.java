package interactivebook.conte.com.br.interactivebookapp.resource;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import interactivebook.conte.com.br.interactivebookapp.config.ApiParams;

public class PasswdRecoverResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "recover/";
    private AsyncHttpClient client;
    private boolean result;

    public boolean userRecover(String email){
        client = new AsyncHttpClient();
        result = true;

        client.get(BASE_URL + URL + email, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                result = true;
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                result = false;
            }
        });

        return result;
    }
}
