

package css.cis3334.heartratetracker;

        import android.app.Activity;
        import android.content.Context;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;
    private HeartRateList hrList;
    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }
    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);

        HeartRate hr = hrList.getHeartRate(position);

        TextView txtPulse = (TextView) view.findViewById(R.id.textPulse);
        txtPulse.setText(hr.getPulse().toString());
        TextView txtRange = view.findViewById(R.id.textRange);
        txtRange.setText(hr.getRangeName());
        if (hr.getRangeName().equals("Resting")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorReg));
        } else if (hr.getRangeName().equals("Moderate")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorReg));
        } else if (hr.getRangeName().equals("Endurance")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorGood));
        } else if (hr.getRangeName().equals("Aerobic")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorGood));
        } else if (hr.getRangeName().equals("Anaerobic")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorGood));
        } else if (hr.getRangeName().equals("Bad")) {
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.colorBad));
        }
        TextView textDescription = view.findViewById(R.id.textDescription);
        textDescription.setText(hr.getRangeDescrtiption());

        return (view);
    }}


