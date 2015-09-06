package vickypatel.ca.materialdesigncusomdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button simpleDialog, withoutTittleDialog, selectiveDialog;
    LinearLayout tittleLayout, contentLayout;
    TextView txtTitle, txtMessage;
    Dialog dialog;

    RecyclerView mRecycleView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    String[] emails = {"vicky.7676@yahoo.in", "jigu.patel@hotmail.com","lala@gmail.com","punit@yahoo.com"};
    int[] profileImages = {R.drawable.convo,R.drawable.jigu, R.drawable.lala,R.drawable.punit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Custom Dialogs");
        setSupportActionBar(toolbar);


        simpleDialog = (Button) findViewById(R.id.simpleDialog);
        withoutTittleDialog = (Button) findViewById(R.id.withoutTittleDialog);
        selectiveDialog = (Button) findViewById(R.id.selectiveDialog);

        simpleDialog.setOnClickListener(this);
        withoutTittleDialog.setOnClickListener(this);
        selectiveDialog.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.simpleDialog:
                initializeSimpleDialog();

                txtTitle.setText("Simple Dialog");
                txtMessage.setText("I am content of simple dialog.");
                // Display the dialog
                dialog.show();
                break;

            case R.id.withoutTittleDialog:
                initializeSimpleDialog();

                tittleLayout.setVisibility(View.GONE);
                //Remove above margin for content
                LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                llp.setMargins(0, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
                contentLayout.setLayoutParams(llp);

                txtMessage.setText("I am content without tittle.");
                // Display the dialog
                dialog.show();
                break;

            case R.id.selectiveDialog:
                initializeDialogWithSelection();
                dialog.show();
                break;

        }
    }

    public void initializeSimpleDialog() {
        //Custom dialog
        dialog = new Dialog(this);
        // hide to default title for Dialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // inflate the layout dialog_layout.xml and set it as contentView
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_dialog, null, false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        // Retrieve views from the inflated dialog layout and update their values
        tittleLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_tittle);
        txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        txtTitle.setText("Tittle");

        contentLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_content);
        txtMessage = (TextView) dialog.findViewById(R.id.txt_dialog_message);
        txtMessage.setText("Content.");

        Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the dialog
                dialog.dismiss();
            }
        });


    }

    public void initializeDialogWithSelection() {
        //Custom dialog
        dialog = new Dialog(this);
        // hide to default title for Dialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // inflate the layout dialog_layout.xml and set it as contentView
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_with_selection, null, false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

//        // Retrieve views from the inflated dialog layout and update their values
        tittleLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_tittle);
        txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);
        txtTitle.setText("Select an account");
//
//        contentLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_content);
//        txtMessage = (TextView) dialog.findViewById(R.id.txt_dialog_message);
//        txtMessage.setText("Content.");

        //Selective dialog
        mRecycleView = (RecyclerView) dialog.findViewById(R.id.selectionRecycleView);
        mAdapter = new MyAdapter(emails, profileImages);
        mRecycleView.setAdapter(mAdapter);
        mLayoutManager = new MyLinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

    }



}
