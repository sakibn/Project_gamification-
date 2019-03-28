package vcu.cmsc355.codeyourway.TutorialPages;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vcu.cmsc355.codeyourway.GameLevel.LevelSelectionActivity;
import vcu.cmsc355.codeyourway.R;

public class SelectionsTutorialActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selections);


        TextView tutorialView;
        TextView moduleID;
        Button BtContinue;


        BtContinue = (Button) findViewById(R.id.ContinueSelections);
        moduleID = findViewById(R.id.selectionsModuleID);

              BtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent levelSelection = new Intent(SelectionsTutorialActivity.this, LevelSelectionActivity.class);
                levelSelection.putExtra("moduleID",2);
                startActivity(levelSelection);
            }
        });

    }

}
