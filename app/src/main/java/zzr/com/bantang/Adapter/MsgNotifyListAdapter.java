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
 * Created by Administrator on 2017/2/8.
 */

public class MsgNotifyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<HashMap<String,String>> datas;

    public MsgNotifyListAdapter(Context context, ArrayList<HashMap<String, String>> datas) {
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
            convertView=View.inflate(context,R.layout.msg_notify_layout,null);
            holder.iv_msg_userimg= (ImageView) convertView.findViewById(R.id.iv_msg_userimg);
            holder.tv_msg_username= (TextView) convertView.findViewById(R.id.tv_msg_username);
            holder.tv_msg_content= (TextView) convertView.findViewById(R.id.tv_msg_content);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(datas.get(position).get("avatar").toString()).into(holder.iv_msg_userimg);
        holder.tv_msg_username.setText(datas.get(position).get("nickname").toString());
        holder.tv_msg_content.setText(datas.get(position).get("content").toString());
        return convertView;
    }

    class ViewHolder{
        ImageView iv_msg_userimg;
        TextView tv_msg_username;
        TextView tv_msg_content;
    }
}
