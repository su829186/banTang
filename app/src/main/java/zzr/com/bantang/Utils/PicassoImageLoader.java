package zzr.com.bantang.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017/2/7.
 */

public class PicassoImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        if(path instanceof String){
            Picasso.with(context)
                    .load((String)path)
                    .into(imageView);
            System.out.println("---"+path.toString());
        }else if(path instanceof Integer){
            Picasso.with(context)
                    .load((int)path)
                    .into(imageView);

        }
    }
}
