package ua.pt.restaurantclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.pt.restaurantclient.R;
import ua.pt.restaurantclient.model.Encomenda;

public class EncomendaAdapter extends RecyclerView.Adapter<EncomendaAdapter.ViewHolder> {

    private Context context;
    private List<Encomenda> list;

    public EncomendaAdapter(Context context, List<Encomenda> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Encomenda encomenda = list.get(position);

        holder.textTitle.setText(encomenda.getId());
        holder.tipoEncomenda.setText("Tipo de entrega: " + String.valueOf(encomenda.getTipoEntrega().getDescricao()));
        holder.estadoEncomenda.setText("Estado: " + String.valueOf(encomenda.getEstado().getDescricao()));

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, tipoEncomenda, estadoEncomenda;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.numero_encomenda);
            tipoEncomenda = itemView.findViewById(R.id.tipo_encomenda);
            estadoEncomenda = itemView.findViewById(R.id.estado_encomenda);
        }
    }

}
