package ua.pt.restaurantclient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.pt.restaurantclient.adapter.EncomendaAdapter;
import ua.pt.restaurantclient.model.Encomenda;

public class OrderList extends AppCompatActivity {

    private static final String ENDPOINT = "https://tqsnutri.herokuapp.com/api/restaurantes/1/encomendas";
    private RequestQueue requestQueue;
    private Gson gson;

    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Encomenda> orderList;
    private RecyclerView.Adapter adapter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        mList = findViewById(R.id.order_list);
        orderList = new ArrayList<>();
        adapter = new EncomendaAdapter(getApplicationContext(),orderList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        fetchOrders();
    }

    private void fetchOrders() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onOrdersLoaded, onOrdersError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onOrdersLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            List<Encomenda> orders = Arrays.asList(gson.fromJson(response, Encomenda[].class));
            orderList.addAll(orders);
            adapter.notifyDataSetChanged();
            progressDialog.dismiss();
        }
    };
        private final Response.ErrorListener onOrdersError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        };
}
