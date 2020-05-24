package com.example.android.waitlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class add_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);
    }


    public void add(View view){
        EditText mNewGuestNameEditText = (EditText) this.findViewById(R.id.person_name_edit_text);
        EditText mNewPartySizeEditText = (EditText) this.findViewById(R.id.party_count_edit_text);


        if (mNewGuestNameEditText.getText().length() == 0 ||
                mNewPartySizeEditText.getText().length() == 0) {
            return;
        }
        //default party size to 1
        int partySize = 1;
        try {
            //mNewPartyCountEditText inputType="number", so this should always work
            partySize = Integer.parseInt(mNewPartySizeEditText.getText().toString());
        } catch (NumberFormatException ex) {
            Log.e("0", "Failed to parse party size text to number: " + ex.getMessage());
        }
        

        Intent intent = new Intent();
        Bundle b=new Bundle();

        b.putInt("status", 1);
        b.putInt("number", partySize);
        b.putString("name", mNewGuestNameEditText.getText().toString());
        intent.putExtras(b);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void close(View view){

        Intent intent = new Intent();
        Bundle b=new Bundle();
        b.putInt("status", 0);
        intent.putExtras(b);

        setResult(RESULT_OK,intent);
        finish();
    }
}
