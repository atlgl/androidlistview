package ejemplo.androidlistview;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ejemplo.androidlistview.controlador.AdapterCiudadesRecyclerView;
import ejemplo.androidlistview.modelo.Ciudades;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton btnAdd;
    private ImageButton btnEdit;
    private ImageButton btnDel;
    private List<Ciudades> ciudadesList;
    AdapterCiudadesRecyclerView adapterCiudadesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Transition exitTrans = new Explode();
        getWindow().setExitTransition(exitTrans);

        Transition reenterTrans = new Slide();
        getWindow().setReenterTransition(reenterTrans);

        ciudadesList=new ArrayList<>();
        ciudadesList.add(new Ciudades(1,"Inglaterra","Un pais con neblina",R.drawable.inglaterra));
        ciudadesList.add(new Ciudades(2,"Dubai","Un pais con dinero",R.drawable.dubai));
        ciudadesList.add(new Ciudades(3,"Paris","Un pais donde esta torre effeil",R.drawable.paris));
        ciudadesList.add(new Ciudades(4,"Tokio","Un pais donde hay tecnologia",R.drawable.tokyo));
        recyclerView=(RecyclerView) findViewById(R.id.recyclerviewciudad);

        btnAdd=(ImageButton) findViewById(R.id.btnagregar);
        btnEdit=(ImageButton) findViewById(R.id.btnmodificar);
        btnDel=(ImageButton) findViewById(R.id.btneliminar);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);


        recyclerView.setLayoutManager(linearLayout);
        adapterCiudadesRecyclerView=new AdapterCiudadesRecyclerView(ciudadesList);
        adapterCiudadesRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index=recyclerView.getChildPosition(v);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Main2Activity.this);

                Intent intent=new Intent(Main2Activity.this,DetalleCiudad.class);

                startActivity(intent,options.toBundle());
                



                Toast.makeText(getBaseContext(),"Elemento selecionado"+ciudadesList.get(index).toString(),Toast.LENGTH_SHORT).show();

            }
        });



        recyclerView.setAdapter(adapterCiudadesRecyclerView);

        //item Animator e item decoration
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ciudadesList!=null){
                    ciudadesList.add(new Ciudades(ciudadesList.size(),"Neverland","na",R.drawable.inglaterra));
                    adapterCiudadesRecyclerView.notifyItemInserted(0);

                }
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ciudadesList!=null && ciudadesList.size()>0)
                {
                    ciudadesList.remove(0);
                    adapterCiudadesRecyclerView.notifyItemRemoved(0);
                }

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

}
