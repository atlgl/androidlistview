package ejemplo.androidlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ejemplo.androidlistview.controlador.ArrayAdapterCiudades;
import ejemplo.androidlistview.modelo.Ciudades;

public class MainActivity extends AppCompatActivity {
    ListView listaCiudades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaCiudades=(ListView) findViewById(R.id.listCiudades);

        List<Ciudades> ciudadesList=new ArrayList<>();
        ciudadesList.add(new Ciudades(1,"Inglaterra","Un pais con neblina",R.drawable.inglaterra));
        ciudadesList.add(new Ciudades(2,"Dubai","Un pais con dinero",R.drawable.dubai));
        ciudadesList.add(new Ciudades(3,"Paris","Un pais donde esta torre effeil",R.drawable.paris));
        ciudadesList.add(new Ciudades(4,"Tokio","Un pais donde hay tecnologia",R.drawable.tokyo));

        ArrayAdapterCiudades arrayAdapterCiudades=new ArrayAdapterCiudades(this,ciudadesList);
        listaCiudades.setAdapter(arrayAdapterCiudades);
        listaCiudades.setOnItemClickListener(onItemClickListener);

    }

    ListView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Ciudades ciudades= (Ciudades) listaCiudades.getItemAtPosition(position);
            Toast.makeText(getBaseContext(),ciudades.toString(),Toast.LENGTH_SHORT).show();;
        }
    };


}
