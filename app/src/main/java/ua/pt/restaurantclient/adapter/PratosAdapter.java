package ua.pt.restaurantclient.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.pt.restaurantclient.OrderDetail;
import ua.pt.restaurantclient.R;
import ua.pt.restaurantclient.model.Encomenda;
import ua.pt.restaurantclient.model.EncomendaRestaurante;
import ua.pt.restaurantclient.model.Pratos;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.ViewHolder> {

    private Context context;

    private List<Pratos> list;

    public PratosAdapter(Context context, List<Pratos> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_prato, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pratos prato = list.get(position);

        holder.nome.setText(prato.getNome());
        holder.quantidade.setText("1");
        holder.preco.setText(prato.getPreco()+"€");

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nome, quantidade, preco;

        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            quantidade = itemView.findViewById(R.id.quantidade);
            preco = itemView.findViewById(R.id.preco);
        }
    }
    public void setList(List<Pratos> list) {
        this.list = list;
    }

}
