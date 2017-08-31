package enc.test.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Admin on 29-07-2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private ArrayList<ImageListPojo> mArrayList;
    private Context context;

    public ImageAdapter(Context context, ArrayList<ImageListPojo> mArrayList) {
        this.mArrayList =  mArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Using Picasso loading image_url_list
        /*Picasso.with(context)
                .load(mArrayList.get(position).getImage_url())
                .resize(240, 120)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_pic)
                .into(holder.img);*/

        //Using Ion loading image_url_list
        Ion.with(holder.img)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .animateIn(AnimationUtils.loadAnimation(context, R.anim.anim_fade_in))
                .load(mArrayList.get(position).getImage_url());

        //Using Glide loding image_url_list
           /* Glide.with(context)
                    .load(mArrayList.get(position).getImage_url())
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.placeholder)
                    .crossFade()
                    .into(holder.img);*/

    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(View view) {
            super(view);

            img = (ImageView)view.findViewById(R.id.recycler_child_image);
        }
    }

}