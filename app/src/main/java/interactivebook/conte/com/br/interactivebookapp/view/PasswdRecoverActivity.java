package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.PasswdRecoverControl;

public class PasswdRecoverActivity extends Activity {

    private PasswdRecoverControl passwdRecoverControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwd_recover);

        this.passwdRecoverControl = new PasswdRecoverControl(this);
    }

    public void recuperar(View view) {
        passwdRecoverControl.recuperarAction();
    }

    public void voltar(View view) {
        passwdRecoverControl.voltarAction();
    }
}
