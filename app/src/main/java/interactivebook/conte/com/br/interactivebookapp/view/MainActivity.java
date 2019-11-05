package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.MainControl;

public class MainActivity extends Activity {

    private MainControl mainControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainControl = new MainControl(this);
    }

    public void entrar(View view){
        mainControl.userValidator();
    }

    public void cadastrese(View view){
        mainControl.cadastrarAction();
    }

    public void recuperarSenha(View view){
        mainControl.recuperarAction();
    }
}
