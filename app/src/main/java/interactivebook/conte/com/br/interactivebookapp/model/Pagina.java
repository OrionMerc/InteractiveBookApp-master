package interactivebook.conte.com.br.interactivebookapp.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "pagina")
public class Pagina implements Serializable {

    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;

    @DatabaseField(canBeNull = false, width = 45)
    private String numPagina;

    @DatabaseField(canBeNull = false, width = 45)
    private String conteudo;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pagina previous;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pagina next;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pergunta pergunta;

    public Pagina() {
    }

    public Pagina(String conteudo, String numeroPagina) {
        this.conteudo = conteudo;
        this.numPagina = numeroPagina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(String numPagina) {
        this.numPagina = numPagina;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Pagina getPrevious() {
        return previous;
    }

    public void setPrevious(Pagina previous) {
        this.previous = previous;
    }

    public Pagina getNext() {
        return next;
    }

    public void setNext(Pagina next) {
        this.next = next;
    }
}
