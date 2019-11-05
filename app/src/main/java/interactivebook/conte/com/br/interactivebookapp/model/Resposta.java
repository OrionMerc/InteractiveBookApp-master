package interactivebook.conte.com.br.interactivebookapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "resposta")
public class Resposta implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, width = 45)
    private String conteudo;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pagina next;

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

    public Pagina getNext() {
        return next;
    }

    public void setNext(Pagina next) {
        this.next = next;
    }
}