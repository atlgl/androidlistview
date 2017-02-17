package ejemplo.androidlistview.controlador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ejemplo.androidlistview.R;
import ejemplo.androidlistview.modelo.Ciudades;

/**
 * Created by Angelus on 17/02/2017.
 */

public class AdapterCiudadesRecyclerView extends RecyclerView.Adapter<AdapterCiudadesRecyclerView.CiudadViewHolder> implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if(onClickListener!=null)
            onClickListener.onClick(v);

    }

    public static class CiudadViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        public CiudadViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            visitas = (TextView) itemView.findViewById(R.id.visitas);
        }
    }

    private List<Ciudades> ciudades;

    public AdapterCiudadesRecyclerView(List<Ciudades> ciudades) {
        this.ciudades = ciudades;
    }

    private View.OnClickListener onClickListener;
    @Override
    public CiudadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_ciudad,parent,false);
        view.setOnClickListener(this);
        return new CiudadViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(CiudadViewHolder holder, int position) {
        holder.imagen.setImageResource(ciudades.get(position).getFoto());
        holder.nombre.setText(ciudades.get(position).getNombre());
        holder.visitas.setText(ciudades.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }
}
