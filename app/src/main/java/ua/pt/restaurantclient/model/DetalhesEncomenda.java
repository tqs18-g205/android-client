package ua.pt.restaurantclient.model;

public class DetalhesEncomenda {
    private String id;

    private String restaurante;

    private Estado estado;

    private Pratos[] pratos;

    private Encomenda encomenda;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getRestaurante ()
    {
        return restaurante;
    }

    public void setRestaurante (String restaurante)
    {
        this.restaurante = restaurante;
    }

    public Estado getEstado ()
    {
        return estado;
    }

    public void setEstado (Estado estado)
    {
        this.estado = estado;
    }

    public Pratos[] getPratos ()
    {
        return pratos;
    }

    public void setPratos (Pratos[] pratos)
    {
        this.pratos = pratos;
    }

    public Encomenda getEncomenda ()
    {
        return encomenda;
    }

    public void setEncomenda (Encomenda encomenda)
    {
        this.encomenda = encomenda;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", restaurante = "+restaurante+", estado = "+estado+", pratos = "+pratos+", encomenda = "+encomenda+"]";
    }
}
