package interactivebook.conte.com.br.interactivebookapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.control.CadastrarControl;

public class CadastrarActivity extends Activity {

    private CadastrarControl cadastrarControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        cadastrarControl = new CadastrarControl(this);
    }

    public void cancelar(View view) {
        cadastrarControl.cancelarAction();
    }

    public void cadastrar(View view) {
        cadastrarControl.cadastrarAction();
    }
}
