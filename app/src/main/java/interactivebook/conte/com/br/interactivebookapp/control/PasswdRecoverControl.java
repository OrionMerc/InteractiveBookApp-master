package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.resource.PasswdRecoverResource;

public class PasswdRecoverControl {

    private Activity activity;
    private PasswdRecoverResource passwdRecoverResource;
    private EditText email;

    public PasswdRecoverControl(Activity activity){
        this.activity = activity;
        this.passwdRecoverResource = new PasswdRecoverResource();

        this.email = activity.findViewById(R.id.edit_text_recover_email);
    }

    public void recuperarAction(){
        String e = this.email.getText().toString();

        boolean r = passwdRecoverResource.userRecover(e);

        if(r){
            Toast.makeText(activity, "Enviado com sucesso!", Toast.LENGTH_SHORT).show();
            this.activity.finish();
        } else {
            Toast.makeText(activity, "Falha ao enviar pedido de recuperação!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void voltarAction(){
        this.activity.finish();
    }
}
