package interactivebook.conte.com.br.interactivebookapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "livro")
public class Livro implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, width = 45)
    private String nome;

    @DatabaseField(canBeNull = false, width = 45)
    private String autor;

    private List<Pagina> paginas;

    @ForeignCollectionField(eager = true)
    private Collection<Pagina> paginasCollection;

    public Long getId() {
        return id;
    }

    public List<Pagina> getLista(){
        return new ArrayList<>(paginas);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

    public Collection<Pagina> getPaginasCollection() {
        return paginasCollection;
    }

    public void setPaginasCollection(Collection<Pagina> paginasCollection) {
        this.paginasCollection = paginasCollection;
    }

    @Override
    public String toString() {
        return "Livro: " +  this.nome;
    }
}
