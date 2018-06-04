package ua.pt.restaurantclient.model;

public class Encomenda {
    private String id;

    private Estado estado;

    private TipoEntrega tipoEntrega;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Estado getEstado ()
    {
        return estado;
    }

    public void setEstado (Estado estado)
    {
        this.estado = estado;
    }

    public TipoEntrega getTipoEntrega ()
    {
        return tipoEntrega;
    }

    public void setTipoEntrega (TipoEntrega tipoEntrega)
    {
        this.tipoEntrega = tipoEntrega;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", estado = "+estado+", tipoEntrega = "+tipoEntrega+"]";
    }
}
