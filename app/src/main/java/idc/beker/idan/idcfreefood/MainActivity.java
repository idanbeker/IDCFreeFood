package idc.beker.idan.idcfreefood;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import idc.beker.idan.idcfreefood.data.FoodEvent;
import idc.beker.idan.idcfreefood.services.FoodEventsService;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    final static FoodEventsService foodEventsService = new FoodEventsService();


    ListView mEventListView;
    FoodEvent[] foodEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleFile();
        refreshList();
        setupList();


    }

    private void handleFile() {
    }

    /**dsd
     * Refreshes the data on the list. #IdanBeker
     */
    private void refreshList() {
        foodEvents = foodEventsService.refreshEvents(null);
    }


    /**
     * Sets up the listView. #IdanBeker
     */
    private void setupList() {
        String[] eventInfo = new String[foodEvents.length];
        Integer[] imgInfo = new Integer[foodEvents.length];

        for(int i = 0 ; i < foodEvents.length ; i++)
        {
            eventInfo[i] = foodEvents[i].toString();

            switch (foodEvents[i].getEventId()){
                case 1: imgInfo[i] = R.drawable.coffee;
                    break;
                case 2 : imgInfo[i] = R.drawable.sandwiches;
                    break;
                case 3 :imgInfo[i] = R.drawable.special;
                    break;
                default: imgInfo[i] = R.drawable.def_icon;
            }

        }


        mEventListView = (ListView) findViewById(R.id.eventListView);
        EventArrayAdapter aa = new EventArrayAdapter(this ,eventInfo,imgInfo);
        mEventListView.setAdapter(aa);
        mEventListView.setOnItemClickListener(this);
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

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p/>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You have selected " + foodEvents[position].toString(),    Toast.LENGTH_SHORT).show();

    }
}
