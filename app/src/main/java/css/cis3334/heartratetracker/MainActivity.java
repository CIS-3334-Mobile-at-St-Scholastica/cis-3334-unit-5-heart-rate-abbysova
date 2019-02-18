package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<HeartRate> HeartRateAdapter;
    HeartRateList heartRateList;
    // The list of heart rate objects
    ListView ListViewwHeartRates;
    TextView textHR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();
        ListViewwHeartRates= findViewById(R.id.HeartRate);
        textHR = findViewById(R.id.textView);
        HeartRateAdapter= new HeartRateAdapter(this,R.layout.heart_rate_row, R.id.textPulse, heartRateList);
        HeartRateAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        ListViewwHeartRates.setAdapter(HeartRateAdapter);
        ListViewwHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
               HeartRate hr = (HeartRate) parent.getItemAtPosition(postion);
                textHR.setText("You've selected: " + hr.toString());
            }
        }
    }
}
