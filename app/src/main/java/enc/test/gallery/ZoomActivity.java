package enc.test.gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by pc41 on 29-08-2017.
 */

public class ZoomActivity extends AppCompatActivity {



    String image;
    public ArrayList<ImageModel> data = new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    int pos;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
       /* PhotoView photoView=new PhotoView(this);
        photoView.setMaximumScale(16f);
        setContentView(photoView);*/
        data = getIntent().getParcelableArrayListExtra("data");
        pos = getIntent().getIntExtra("pos", 0);
        setTitle(data.get(pos).getName());
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), data);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());

        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(pos);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //noinspection ConstantConditions
                setTitle(data.get(position).getName());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//       // image=getIntent().getExtras().getString("Position_Id");
//        //  Picasso.with(ImageZoom.this).load(image_url_list).into(photoView);
//   /*     Ion.with(photoView)
//                .placeholder(R.drawable.placeholder)//image_url_list when loading
//                .error(R.drawable.error)                            //image_url_list if error/ no connection/ wrong url etc
//                //uncomment this line and set imageURL with wrong URL and see error image_url_list animation
////                .animateLoad(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spin_animation))
//                //this defines animation of the successfully loaded image_url_list (animate it in)
//                .animateIn(AnimationUtils.loadAnimation(ZoomActivity.this,R.anim.anim_fade_in))
//                .load(image);*/
///*
//        Picasso.with(ZoomActivity.this)
//                .load(image)
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error)
//                // .getImage_url())
//                         .resize(400,300)
//                .centerCrop()
//                .into(photoView);*/
//
//        /*  Glide.with(ImageZoom.this)
//                    .load(image_url_list)
//                    .thumbnail(0.5f)
//                    .placeholder(R.drawable.placeholder)
//                    .error(R.drawable.error)
//                    .crossFade()
//                    .resize(400,300)
//                    .into(photoView);*/

    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter{
        public ArrayList<ImageModel> data = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<ImageModel> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position, data.get(position).getName(), data.get(position).getUrl());
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return data.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data.get(position).getName();
        }
    }/**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        String name, url;
        int pos;
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMG_TITLE = "image_title";
        private static final String ARG_IMG_URL = "image_url";

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            this.pos = args.getInt(ARG_SECTION_NUMBER);
            this.name = args.getString(ARG_IMG_TITLE);
            this.url = args.getString(ARG_IMG_URL);
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber, String name, String url) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            args.putString(ARG_IMG_TITLE, name);
            args.putString(ARG_IMG_URL, url);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public void onStart() {
            super.onStart();

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            PhotoView photoView=new PhotoView(getActivity());
            photoView.setMaximumScale(16f);
            View rootView = photoView;

//            final ImageView imageView = (ImageView) rootView.findViewById(R.id.detail_image);

            Glide.with(getActivity()).load(url).thumbnail(0.1f).into(photoView);

            return rootView;
        }

    }


}
