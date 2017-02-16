package ejemplo.androidlistview.controlador;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ejemplo.androidlistview.R;
import ejemplo.androidlistview.modelo.Ciudades;

/**
 * Created by Angelus on 15/02/2017.
 */

public class ArrayAdapterCiudades extends ArrayAdapter<Ciudades> {
    List<Ciudades> ciudadesList;
    Activity activity;

    public ArrayAdapterCiudades(Activity context,List<Ciudades> ciudadesList) {
        super(context, R.layout.item_ciudad,ciudadesList );

        this.activity=context;
        this.ciudadesList=ciudadesList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.item_ciudad,null);
        ImageView imageView= (ImageView) view.findViewById(R.id.imgCiudad);
        TextView txtciudad=(TextView) view.findViewById(R.id.txtCiudadNombre);
        TextView txtdesc=(TextView) view.findViewById(R.id.txtCiudaddesc);

        imageView.setImageResource(ciudadesList.get(position).getFoto());
        txtciudad.setText(ciudadesList.get(position).getNombre());
        txtdesc.setText(ciudadesList.get(position).getDescripcion());
        return view;
    }
}
