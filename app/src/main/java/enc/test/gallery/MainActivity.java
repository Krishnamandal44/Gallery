package enc.test.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Booking (Image Change -> Hotel,Train)
    RecyclerView recyclerView;
    ArrayList<ImageModel> data = new ArrayList<>();
    String image_url_list[]={
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/21462250_1177429255736553_2121474157746876200_n.jpg?oh=c7369bab6354f1195f74c836bdd13b16&oe=5A1BF343",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/20638774_1156531801159632_1271351887391077263_n.jpg?oh=9070325b76bf5a75847ab326e02c1534&oe=5A4ABC01",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/17522780_1069032556576224_5426157747126320975_n.jpg?oh=f785beef4ab48fc72fecab2ba1cc386e&oe=5A13A545",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/19029413_1110779005734912_3640312351322438785_n.jpg?oh=96173f7af7d92774bce43fc783753f31&oe=5A5BB809",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/17361560_1054184754727671_6055038697835157026_n.jpg?oh=11addcc822c565a5bcaa545c53dacc42&oe=5A5CDC11",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/17201013_1048083925337754_2273510670815265549_n.jpg?oh=5c37bf5517463363e2a58ff2f6d590c6&oe=5A1C84C2",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/17191335_1044190199060460_9218219103675433359_n.jpg?oh=1767fa7293a20bd743af5d2568ec50dc&oe=5A50E495",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/17022253_1039773229502157_3909538598218956946_n.jpg?oh=71865a2db109c41a24409a96eac025ae&oe=5A12C2BE",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/16831090_1036523556493791_6289022539180218821_n.jpg?oh=7a51c59296c32dc0bb931fc18f508ceb&oe=5A4814FD",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/16831090_1036523556493791_6289022539180218821_n.jpg?oh=7a51c59296c32dc0bb931fc18f508ceb&oe=5A4814FD",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/16602828_1025630907583056_2162902196222467731_n.jpg?oh=fa6b7cfc3ef52ceb5067b331c872fb90&oe=5A14B523",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/16298406_1018179154994898_3222641634734405095_n.jpg?oh=64d0be737f2c0c30e4109e4f2d3b8997&oe=5A471566",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/16114503_1013971552082325_8242437669956283526_n.jpg?oh=1d4fa03e682d3d0c957384ab097bcfdc&oe=5A4EA43D",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/15895413_1006243346188479_4898668820525080268_n.jpg?oh=f339213d3449c5be72dd0b9cb559a856&oe=5A14EB91",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/15665555_990818171064330_9005705449350310078_n.jpg?oh=e8e139e28a5967e1f3eec8e16ba9f82a&oe=5A15033C",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/15079007_963122720500542_4399020657402134647_n.jpg?oh=2b2a9a5eeb8601f298d227eafb64224a&oe=5A16D842",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/14600934_952850371527777_7704130533774951531_n.jpg?oh=c2a977cf1e10b246f69b40bb5ae72e7d&oe=5A4A71F5",
            "https://scontent.fccu3-1.fna.fbcdn.net/v/t1.0-9/14572894_940274756118672_9206100749630830483_n.jpg?oh=83321ab05895ebfb1b842cca042f382b&oe=5A1BE121",



            "https://static.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg",
            "https://www.w3schools.com/css/img_fjords.jpg",
            "http://www.qygjxz.com/data/out/8/4421389-android-wallpaper.png",
            "https://www.androidcentral.com/sites/androidcentral.com/files/styles/w550h500/public/wallpapers/dc-superhero-suits-a8o.jpg?itok=KSU3SFs-",
            "http://www.planwallpaper.com/static/images/11-sea-beach-sand-wallpaper_sf9i1b6.jpg",
            "http://www.planwallpaper.com/static/images/303836.jpg",
            "http://www.planwallpaper.com/static/images/colorful-triangles-background.jpg",
            "http://www.planwallpaper.com/static/images/i-should-buy-a-boat.jpg",
            "http://cdn.wccftech.com/wp-content/uploads/2017/02/Oreo-Two-Cookies.jpg",
            "https://www.gammerson.com/wp-content/uploads/2017/03/Google-Android-O-e1490972227545.jpg",
            "http://cdn02.androidauthority.net/wp-content/uploads/2017/08/animation-battery.gif",
            "http://fscl01.fonpit.de/userfiles/6727621/image_url_list/2016/ANDROID-M-N-O-P/AndroidPIT-android-O-Oreo-2065.jpg",
            "http://images.anandtech.com/doci/10587/Anroid_Nougat-Cover_678x452.png",
            "http://www.retrosweets.co.uk/media/catalog/product/cache/1/image_url_list/9df78eab33525d08d6e5fb8d27136e95/w/h/wheel-lollipop.jpg",
            "http://data1.ibtimes.co.in/cache-img-0-450/en/full/570675/1436615678_micromax-launch-canvas-play-android-lollipop-soon.jpg",
            "https://i.kinja-img.com/gawker-media/image_url_list/upload/s--ITmezh3R--/c_scale,fl_progressive,q_80,w_800/fshb2xuu10edhssnikxd.jpg"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < image_url_list.length; i++) {

            ImageModel imageModel = new ImageModel();
            imageModel.setName("Image " + i);
            imageModel.setUrl(image_url_list[i]);
            data.add(imageModel);

        }
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view) ;
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        GalleryAdapter adapter = new GalleryAdapter(MainActivity.this,data);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(android.view.View view, int position) {

                    Intent intent = new Intent(MainActivity.this,ZoomActivity.class);
                    // String sImage =image_url_list[position];
                    // intent.putExtra("Position_Id",sImage);
                    intent.putParcelableArrayListExtra("data",data);
                    intent.putExtra("pos", position);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);



            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

}
