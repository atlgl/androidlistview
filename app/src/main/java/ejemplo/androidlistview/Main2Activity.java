package ejemplo.androidlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ejemplo.androidlistview.controlador.AdapterCiudadesRecyclerView;
import ejemplo.androidlistview.modelo.Ciudades;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Ciudades> ciudadesList=new ArrayList<>();
        ciudadesList.add(new Ciudades(1,"Inglaterra","Un pais con neblina",R.drawable.inglaterra));
        ciudadesList.add(new Ciudades(2,"Dubai","Un pais con dinero",R.drawable.dubai));
        ciudadesList.add(new Ciudades(3,"Paris","Un pais donde esta torre effeil",R.drawable.paris));
        ciudadesList.add(new Ciudades(4,"Tokio","Un pais donde hay tecnologia",R.drawable.tokyo));
        recyclerView=(RecyclerView) findViewById(R.id.recyclerviewciudad);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);


        recyclerView.setLayoutManager(linearLayout);
        final AdapterCiudadesRecyclerView adapterCiudadesRecyclerView=new AdapterCiudadesRecyclerView(ciudadesList);
        adapterCiudadesRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Elemento selecionado"+recyclerView.getChildPosition(v),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapterCiudadesRecyclerView);

    }
}
