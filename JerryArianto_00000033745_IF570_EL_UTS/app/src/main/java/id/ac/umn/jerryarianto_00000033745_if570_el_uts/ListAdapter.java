package id.ac.umn.jerryarianto_00000033745_if570_el_uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Sound> listSound;

    public ListAdapter(Context context,ArrayList<Sound> listSound) {
        this.listSound = listSound;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_sfx, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Sound sound = listSound.get(position);
        holder.tv_title.setText(sound.getTitle());
        holder.tv_desc.setText(sound.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(holder.itemView.getContext(), DetailActivity.class);
                detail.putExtra(DetailActivity.EXTRA_TITLE, sound.getTitle().toString());
                detail.putExtra(DetailActivity.EXTRA_DESC, sound.getDescription().toString());
                detail.putExtra(DetailActivity.EXTRA_URI, sound.getSoundUri().toString());
                holder.itemView.getContext().startActivity(detail);
            }
        });
        holder.btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSound.size();
    }
    public void delete(int pos){
        listSound.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos, listSound.size());
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_img;
        TextView tv_title, tv_desc;
        ImageButton btn_img;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv_img = itemView.findViewById(R.id.item_photo);
            tv_title = itemView.findViewById(R.id.item_title);
            tv_desc = itemView.findViewById(R.id.item_desc);
            btn_img = itemView.findViewById(R.id.item_delete);
        }
    }
}
