package interactivebook.conte.com.br.interactivebookapp.dao;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import interactivebook.conte.com.br.interactivebookapp.model.Usuario;

public class UsuarioDao {

    private Dao<Usuario, Integer> usuarioDao;
    private MyORMLiteHelper helper;

    public UsuarioDao(MyORMLiteHelper helper) {
        this.helper = helper;
    }

    public Dao<Usuario, Integer> getProdutoDao() throws SQLException {
        if(usuarioDao == null){
            usuarioDao = helper.getDao(Usuario.class);
        }
        return usuarioDao;
    }
}
