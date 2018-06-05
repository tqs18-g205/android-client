package ua.pt.restaurantclient.model;

public class Estado {
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
        return "Estado [id = "+id+", descricao = "+descricao+"]";
    }
}
