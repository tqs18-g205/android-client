package ua.pt.restaurantclient.model;

public class Morada
{
    private String codigoPostal;

    private String id;

    private String distrito;

    private String localidade;

    private String rua;

    public String getCodigoPostal ()
    {
        return codigoPostal;
    }

    public void setCodigoPostal (String codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDistrito ()
    {
        return distrito;
    }

    public void setDistrito (String distrito)
    {
        this.distrito = distrito;
    }

    public String getLocalidade ()
    {
        return localidade;
    }

    public void setLocalidade (String localidade)
    {
        this.localidade = localidade;
    }

    public String getRua ()
    {
        return rua;
    }

    public void setRua (String rua)
    {
        this.rua = rua;
    }

    @Override
    public String toString()
    {
        return rua + " " + codigoPostal + ", " + localidade;
    }
}