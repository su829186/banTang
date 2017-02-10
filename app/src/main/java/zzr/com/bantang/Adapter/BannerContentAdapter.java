package zzr.com.bantang.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import zzr.com.bantang.R;

import static zzr.com.bantang.R.id.iv_banner_img;
import static zzr.com.bantang.R.id.iv_banner_user_img;
import static zzr.com.bantang.R.id.tv_banner_content_title;
import static zzr.com.bantang.R.id.tv_banner_likes;
import static zzr.com.bantang.R.id.tv_banner_nickname;
import static zzr.com.bantang.R.id.tv_banner_time;
import static zzr.com.bantang.R.id.tv_banner_views;

/**
 * Created by Administrator on 2017/2/10.
 */

public class BannerContentAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<HashMap<String,String>> datas;

    public BannerContentAdapter(Context context, ArrayList<HashMap<String, String>> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.banner_content_list,null);
            holder.iv_banner_img= (ImageView) convertView.findViewById(iv_banner_img);
            holder.tv_banner_content_title= (TextView) convertView.findViewById(tv_banner_content_title);
            holder.tv_banner_views= (TextView) convertView.findViewById(tv_banner_views);
            holder.tv_banner_likes= (TextView) convertView.findViewById(tv_banner_likes);
            holder.iv_banner_user_img= (ImageView) convertView.findViewById(iv_banner_user_img);
            holder.tv_banner_nickname= (TextView) convertView.findViewById(tv_banner_nickname);
            holder.tv_banner_time= (TextView) convertView.findViewById(tv_banner_time);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(datas.get(position).get("path").toString()).into(holder.iv_banner_img);
        holder.tv_banner_content_title.setText(datas.get(position).get("title").toString());
        holder.tv_banner_views.setText("浏览 "+datas.get(position).get("views").toString());
        holder.tv_banner_likes.setText("喜欢 "+datas.get(position).get("praises").toString());
        Picasso.with(context).load(datas.get(position).get("avatar").toString()).into(holder.iv_banner_user_img);
        holder.tv_banner_nickname.setText(datas.get(position).get("nickname"));
        holder.tv_banner_time.setText(datas.get(position).get("time"));


        return convertView;
    }

    class ViewHolder{
        ImageView iv_banner_img;
        TextView tv_banner_content_title;
        TextView tv_banner_views;
        TextView tv_banner_likes;
        ImageView iv_banner_user_img;
        TextView tv_banner_nickname;
        TextView tv_banner_time;
    }
}
