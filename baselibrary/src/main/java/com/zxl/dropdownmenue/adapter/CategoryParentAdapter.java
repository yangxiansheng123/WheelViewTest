package com.zxl.dropdownmenue.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zxl.dropdownmenue.R;
import com.zxl.dropdownmenue.bean.ArtRightClassificationBean;

import java.util.List;

/**
 * Created by imahe001 on 2015/9/29.
 */
public class CategoryParentAdapter extends BaseAdapter {


    private List<ArtRightClassificationBean.DataBean> listData;
    private Context context;
    private LayoutInflater inflater;
    private int selectionPosition;

    public void setListData(List<ArtRightClassificationBean.DataBean> listData) {
        this.listData = listData;
    }

    public CategoryParentAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size() > 0 ? listData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
//        return goodsClassifyAllInfos.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectionPosition(int selectionPosition) {
        this.selectionPosition = selectionPosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.base_item_category_pattern, null);
            holder.tvClassify = (TextView) convertView.findViewById(R.id.tv_classify);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvClassify.setText(listData.get(position).getCat_name());

        if (position == selectionPosition) {
            convertView.setBackgroundColor(Color.WHITE);
            holder.tvClassify.setTextColor(context.getResources().getColor(R.color.un_press_color));
        } else {
            holder.tvClassify.setTextColor(Color.BLACK);
            convertView.setBackgroundColor(Color.argb(0x0, 0xf5, 0xf5, 0xf5));
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvClassify;
    }
}
