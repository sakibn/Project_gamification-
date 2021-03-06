package vcu.cmsc355.codeyourway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import vcu.cmsc355.codeyourway.Model.Common;

public class BadgeActivity extends AppCompatActivity {

    String total;
    String userPicture;
    ImageView pictureView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_badge);

            TextView username = findViewById(R.id.badgeUsername);
            TextView expertise = findViewById(R.id.userLevel);
            TextView totalDescription = findViewById(R.id.badgeDescription);
            Button home = findViewById(R.id.badgeHome);
            pictureView = findViewById(R.id.userPicture);
            username.setText(Common.getCurrentUser());
            pictureView.setImageResource(R.drawable.profile);
            Bundle badgePage = getIntent().getExtras();
            expertise.setText("Professional");
            totalDescription.setText("You own 29 out of 33 Badges");

            if (badgePage != null)
            {
                total = badgePage.getString("total");
                userPicture = badgePage.getString("picture");

            }




            GridView gridview = findViewById(R.id.group);
            gridview.setAdapter(new BadgeHelper(this));

           gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Toast.makeText(getBaseContext(), "Level " + (position + 1) + " Badge", Toast.LENGTH_LONG).show();
               }
           });

           home.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(BadgeActivity.this, HomeActivity.class));
               }
           });
        }
    }