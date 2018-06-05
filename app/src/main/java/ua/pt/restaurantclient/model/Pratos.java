package ua.pt.restaurantclient.model;

public class Pratos
{
    private String id;

    private String preco;

    private String imagem;

    private String nome;

    private String calorias;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPreco ()
    {
        return preco;
    }

    public void setPreco (String preco)
    {
        this.preco = preco;
    }

    public String getImagem ()
    {
        return imagem;
    }

    public void setImagem (String imagem)
    {
        this.imagem = imagem;
    }

    public String getNome ()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getCalorias ()
    {
        return calorias;
    }

    public void setCalorias (String calorias)
    {
        this.calorias = calorias;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", preco = "+preco+", imagem = "+imagem+", nome = "+nome+", calorias = "+calorias+"]";
    }
}

