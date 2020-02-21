package com.example.konataandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //除了需要重写三个必要的方法外，还需要有这个新Adapter的构造方法与ViewHolder的类定义
    //这个ViewHolder是一个抽象的Item,说明了每个Item有哪些控件。并且这些控件也是抽象的，比如说TextView没有具体的text，ImageView没有具体的Image。这些具体内容在bind时通过set方法设置

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemText;
        TextView itemText2;
        ImageView imageView;
        //因为有继承，所以用super来初始化父级
        public ViewHolder(View view){
            super(view);
            itemText = view.findViewById(R.id.linear_item_text);
            itemText2 = view.findViewById(R.id.linear_item_text2);
            imageView = view.findViewById(R.id.linear_item_image);
        }
    }

    private Context mContext;
    public LinearAdapter(Context context){
        this.mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  //这个参数列表，是提示我们背后的源码给我们提供了哪些有用的信息可用
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //onBindViewHolder说明了每个Item具体有哪些东西，产生了具体的Item
    //上面一步是创建VH，在bind方法中可以使用holder
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).itemText.setText("五月的麦地");     //因为要使用自己定义的ViewHolder，又不能改变函数的参数列表（因为改了之后就不是override了），因此需要类型强转
        ((ViewHolder)holder).itemText2.setText("2020-2-18\n海子的诗");
        ((ViewHolder)holder).imageView.setImageResource(R.drawable.shiji);
    }
    @Override
    public int getItemCount() {
        return 25;
    }
}
