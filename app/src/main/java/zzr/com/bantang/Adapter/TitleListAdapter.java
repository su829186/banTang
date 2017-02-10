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

/**
 * Created by Administrator on 2017/2/7.
 */

public class TitleListAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<HashMap<String,String>> datas;

    public TitleListAdapter(Context context, ArrayList<HashMap<String, String>> datas) {
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
        System.out.println("---holder=null");
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.title_list_layout,null);
            holder.iv_img= (ImageView) convertView.findViewById(R.id.imageView);
            holder.tv_author= (TextView) convertView.findViewById(R.id.tv_author);
            holder.tv_title= (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_view= (TextView) convertView.findViewById(R.id.tv_attach);
            holder.tv_like= (TextView) convertView.findViewById(R.id.tv_love);

            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        System.out.println("----settext1");

        holder.tv_title.setText(datas.get(position).get("title").toString());
        holder.tv_author.setText(datas.get(position).get("author").toString());
        holder.tv_view.setText(datas.get(position).get("views").toString());
        holder.tv_like.setText(datas.get(position).get("like").toString());

        Picasso.with(context).load(datas.get(position).get("urlpath").toString()).into(holder.iv_img);
        System.out.println("----settext2");
        return convertView;
    }

    class ViewHolder{
        ImageView iv_img;
        TextView tv_author;
        TextView tv_title;
        TextView tv_view;
        TextView tv_like;
    }
}
