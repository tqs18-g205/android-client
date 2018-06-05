package ua.pt.restaurantclient.model;

public class Cliente
{
    private String id;

    private Morada morada;

    private String nif;

    private String email;

    private String nome;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Morada getMorada ()
    {
        return morada;
    }

    public void setMorada (Morada morada)
    {
        this.morada = morada;
    }

    public String getNif ()
    {
        return nif;
    }

    public void setNif (String nif)
    {
        this.nif = nif;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", morada = "+morada+", nif = "+nif+", email = "+email+", nome = "+nome+"]";
    }
}