package ua.pt.restaurantclient.model;

public class Encomenda
{
    private String total;

    private Cliente cliente;

    private TipoEntrega tipoEntrega;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Cliente getCliente ()
    {
        return cliente;
    }

    public void setCliente (Cliente cliente)
    {
        this.cliente = cliente;
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
        return "ClassPojo [total = "+total+", cliente = "+cliente+", tipoEntrega = "+tipoEntrega+"]";
    }
}