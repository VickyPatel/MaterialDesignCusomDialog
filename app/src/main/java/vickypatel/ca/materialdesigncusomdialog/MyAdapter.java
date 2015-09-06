package vickypatel.ca.materialdesigncusomdialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    String[] accountEmails = {};

    public MyAdapter(String[] accountEmails) {
        this.accountEmails = accountEmails;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_dialog_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.accountEmail.setText(accountEmails[position]);

    }

    @Override
    public int getItemCount() {
        return accountEmails.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView accountImage;
        TextView accountEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            accountImage = (ImageView) itemView.findViewById(R.id.accountImage);
            accountEmail = (TextView) itemView.findViewById(R.id.accountEmail);
        }
    }
}