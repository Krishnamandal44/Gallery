package enc.test.galarysample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.lang.System.load;

/**
 * Created by Admin on 29-07-2017.
 */

public class TopRecyclerAdapter extends RecyclerView.Adapter<TopRecyclerAdapter.ViewHolder>{

    private List<TopRecyclerPojo> topRecyclerPojos;
    private Context context;
    private int child;

    ImageView imageView;

    public TopRecyclerAdapter(List<TopRecyclerPojo> itemList, int child, Context context) {
        this.topRecyclerPojos = itemList;
        this.context = context;
        this.child = child;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(child,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        TopRecyclerPojo topRecyclerPojo = topRecyclerPojos.get(position);
      //  holder.textView.setText(topRecyclerPojo.getText());
        String url = topRecyclerPojo.getIcon();
//        Picasso.with(context)
//                .load(url)
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error)
//                // .getImage_url())
   //                 .resize(400,300)
//                .centerCrop()
//                .into(imageView);

   //        Picasso.with(context).load(url).into(imageView);

            Ion.with(imageView)
                    .placeholder(R.drawable.placeholder)//image when loading
                    .error(R.drawable.error)                            //image if error/ no connection/ wrong url etc
                    //uncomment this line and set imageURL with wrong URL and see error image animation
//                .animateLoad(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spin_animation))
                    //this defines animation of the successfully loaded image (animate it in)
                    .animateIn(AnimationUtils.loadAnimation(context,R.anim.anim_fade_in))
                    .resize(400,300)
                    .load(url);//Using Glide loding image
          /*  Glide.with(context)
                    .load(topRecyclerPojos.get(position).getIcon())
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .crossFade()
                    .resize(400,300)
                    .into(imageView);*/

    }

    @Override
    public int getItemCount() {
        return topRecyclerPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // TextView textView;
        LinearLayout view;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.recycler_child_image);
            view = (LinearLayout) itemView;
        }
    }
}
