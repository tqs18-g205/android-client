package ua.pt.restaurantclient;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.pt.restaurantclient.adapter.EncomendaAdapter;
import ua.pt.restaurantclient.adapter.PratosAdapter;
import ua.pt.restaurantclient.model.DetalhesEncomenda;
import ua.pt.restaurantclient.model.Encomenda;
import ua.pt.restaurantclient.model.EncomendaRestaurante;
import ua.pt.restaurantclient.model.Pratos;

public class OrderDetail extends AppCompatActivity {

    private static final String ENDPOINT = "https://tqsnutri.herokuapp.com/api/restaurantes/1/encomendas/";

    private RequestQueue requestQueue;
    private Gson gson;
    private DetalhesEncomenda encomenda;

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private List<Pratos> pratoList;
    private RecyclerView.Adapter adapter;


    private TextView nome, morada, total, estado;
    private Button preparacao, preparado;

    private String orderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);


        mList = findViewById(R.id.pratos_list);
        pratoList = new ArrayList<>();
        adapter = new PratosAdapter(getApplicationContext(),pratoList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        nome = (TextView) findViewById(R.id.nome_cliente);
        morada = (TextView) findViewById(R.id.morada_cliente);
        total = (TextView) findViewById(R.id.total_value);
        estado = (TextView) findViewById(R.id.estado_value);

        preparacao = (Button) findViewById(R.id.preparacao);
        preparado = (Button) findViewById(R.id.preparado);

        preparacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOrder("2");
            }
        });

        preparado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateOrder("3");
            }
        });

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        orderID = getIntent().getStringExtra("id");
        getOrderDetails(orderID);
    }

    private void getOrderDetails(String id) {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT+id, onDetailsLoaded, onDetailsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onDetailsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            encomenda = gson.fromJson(response, DetalhesEncomenda.class);
            nome.setText(encomenda.getEncomenda().getCliente().getNome());
            morada.setText(encomenda.getEncomenda().getCliente().getMorada().toString());
            total.setText(encomenda.getEncomenda().getTotal()+"€");
            estado.setText(encomenda.getEstado().getDescricao());
            List<Pratos> pratos = Arrays.asList(encomenda.getPratos());
            pratoList.clear();
            pratoList.addAll(pratos);
            adapter.notifyDataSetChanged();

        }
    };
    private final Response.ErrorListener onDetailsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Volley", error.toString());
        }
    };


    private final Response.Listener<String> onStatusChanged = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            getOrderDetails(orderID);

        }
    };

    private final Response.ErrorListener onStatusError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("Volley", error.toString());
        }
    };


    private void updateOrder(final String id) {

        Map<String, String> params = new HashMap();
        params.put("estado", id);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.PUT, ENDPOINT+orderID, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                getOrderDetails(orderID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(jsonRequest);

    }
}
