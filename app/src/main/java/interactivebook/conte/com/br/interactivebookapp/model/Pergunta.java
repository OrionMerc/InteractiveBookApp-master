package interactivebook.conte.com.br.interactivebookapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@DatabaseTable(tableName = "pergunta")
public class Pergunta implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, width = 45)
    private String conteudo;

    private List<Resposta> respostas;

    @ForeignCollectionField(eager = true)
    private Collection<Resposta> respostasCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Collection<Resposta> getRespostasCollection() {
        return respostasCollection;
    }

    public void setRespostasCollection(Collection<Resposta> respostasCollection) {
        this.respostasCollection = respostasCollection;
    }
}
