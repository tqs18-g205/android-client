package ua.pt.restaurantclient.model;

public class TipoEntrega {
    private String id;
    private String descricao;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDescricao ()
    {
        return descricao;
    }

    public void setDescricao (String descricao)
    {
        this.descricao = descricao;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", descricao = "+descricao+"]";
    }
}
