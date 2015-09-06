package vickypatel.ca.materialdesigncusomdialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    String[] accountEmails = {};
    int[] profileImages = {};
    private  static  final int TYPE_CONTENT= 0;
    private  static  final  int TYPE_ACTIONS = 1;



    public MyAdapter(String[] accountEmails, int[] profileImages) {
        this.accountEmails = accountEmails;
        this.profileImages = profileImages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dialog_row,parent,false);
        return new ViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(holder.holderId == TYPE_CONTENT){
            holder.accountEmail.setText(accountEmails[position]);
            holder.accountImage.setImageResource(profileImages[position]);
        }else  if(holder.holderId == TYPE_ACTIONS){
            holder.accountEmail.setText("Add Accounts");
            holder.accountImage.setImageResource(R.drawable.ic_action);
        }


    }

    @Override
    public int getItemCount() {
        return accountEmails.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == accountEmails.length){
            return TYPE_ACTIONS;
        }else  {
            return TYPE_CONTENT;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView accountImage;
        TextView accountEmail;
        int holderId = 0;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if(viewType == TYPE_CONTENT){
                holderId = TYPE_CONTENT;
            }else  if(viewType == TYPE_ACTIONS) {
                holderId = TYPE_ACTIONS;
            }
            accountImage = (ImageView) itemView.findViewById(R.id.accountImage);
            accountEmail = (TextView) itemView.findViewById(R.id.accountEmail);
        }
    }
}