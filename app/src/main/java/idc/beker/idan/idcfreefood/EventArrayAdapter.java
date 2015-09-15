package idc.beker.idan.idcfreefood;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import idc.beker.idan.idcfreefood.data.FoodEvent;

/**
 * Created by User on 12/09/2015.
 */
public class EventArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] foodEvents;
    private final Integer[] imageId;

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     */
    public EventArrayAdapter(Activity context, String[] foodEvents, Integer[] imageId) {

        super(context, R.layout.event_row, foodEvents);
        this.context = context;
        this.foodEvents = foodEvents;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
                //---print the index of the row to examine--
                //       Log.d("CustomArrayAdapter",String.valueOf(position));
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.event_row, null, true);

        //---get a reference to all the views on the xml layout--
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtEvent);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        //---customize the content of each row based on position--
        txtTitle.setText(foodEvents[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }


    }
