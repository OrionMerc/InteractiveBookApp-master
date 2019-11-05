package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.os.Bundle;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.LobbyControl;

public class LobbyActivity extends Activity {

    private LobbyControl lobbyControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        this.lobbyControl = new LobbyControl(this);
    }
}
