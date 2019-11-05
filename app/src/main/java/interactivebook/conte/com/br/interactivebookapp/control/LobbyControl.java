package interactivebook.conte.com.br.interactivebookapp.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import interactivebook.conte.com.br.interactivebookapp.R;
import interactivebook.conte.com.br.interactivebookapp.model.Livro;
import interactivebook.conte.com.br.interactivebookapp.model.Usuario;
import interactivebook.conte.com.br.interactivebookapp.resource.LivroResource;

public class LobbyControl {

    private Activity activity;
    private Usuario usuario;
    private Livro livro;
    private LivroResource livroResource;

    private ArrayAdapter<Livro> livrosAdapter;
    private TextView userTextView;
    private ListView livrosListView;
    private TextView headerUserTextView;
    private TextView headerEmailTextView;


    View rootViewHeader;
    public LobbyControl(Activity activity){
        this.activity = activity;

        userTextView = this.activity.findViewById(R.id.lobby_user_text_view);
        livrosListView = this.activity.findViewById(R.id.lobby_livro_listview);

        LayoutInflater inflater = LayoutInflater.from(this.activity);
        rootViewHeader = inflater.inflate(R.layout.activity_lobby_nav_header, null);
        try {
            NavigationView nv = activity.findViewById(R.id.navView);
            headerUserTextView = nv.getHeaderView(0).findViewById(R.id.nav_header_user_textView);
            headerEmailTextView = nv.getHeaderView(0).findViewById(R.id.nav_header_email_textView);
        }catch (Exception e){
            System.out.print("Erro: ");
            System.out.println(e.toString());
        }
        livroResource = new LivroResource(this.activity);

        getUserData();
    }

    private void getUserData(){
        this.usuario = (Usuario) this.activity.getIntent().getSerializableExtra("user");

        this.userTextView.setText("Bem vindo, " + usuario.getNome() + " " + usuario.getSobrenome());
        this.headerUserTextView.setText(usuario.getNome() + " " + usuario.getSobrenome());
        this.headerEmailTextView.setText(usuario.getEmail());

        getLivroFromAPI();
    }

    private void getLivroFromAPI(){

        try {
            livrosAdapter = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_spinner_item,
                    new ArrayList<Livro>()
            );
            livrosListView.setAdapter(livrosAdapter);

            livroResource.buscaLivroPorId(1L, livrosAdapter);

        } catch (Exception e){
            Toast.makeText(activity, "Falha ao buscar livro", Toast.LENGTH_SHORT).show();
        }
    }
}
