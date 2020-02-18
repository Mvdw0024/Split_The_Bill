package vandewouwer.michael.splitthebill.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import vandewouwer.michael.splitthebill.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BillFragment extends Fragment {


    private EditText inpParty;
    private EditText inpBill;
    private EditText inPtip;
    private TextView splitBill;

    public BillFragment() {
    }

    public static BillFragment newInstance() {
        return new BillFragment();
        // Required empty public constructor
    }

    public View.OnClickListener billListener = new View.OnClickListener() {
        public void onClick(View v) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String tipKey = getResources().getString(R.string.pref_et_tip);

            double bill;
            if (inpBill.getText().toString().isEmpty()) {
                bill = 0;
            } else {
                bill = Double.valueOf(inpBill.getText().toString());
            }

            int party;

            if (inpParty.getText().toString().isEmpty()) {
                party = 1;
            } else {
                party = Integer.valueOf(inpParty.getText().toString());

            }

            double tip;

            if (inPtip.getText().toString().isEmpty()) {
                tip = Double.valueOf(prefs.getString(tipKey, "1"));
            } else {
                tip = Double.valueOf(inPtip.getText().toString());
            }

            double result = ((bill + tip) / party);
            splitBill.setText(String.format("%.2f", result) + "/pers");

            Toast.makeText(getActivity(), "Bill has been split under " + party + " person(s)", Toast.LENGTH_SHORT).show();

        }

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_bill, container, false);
        Button splitBtn = rootView.findViewById(R.id.btn_splitthebill);
        splitBtn.setOnClickListener(billListener);
        inpBill = rootView.findViewById(R.id.te_Amount);
        inpParty = rootView.findViewById(R.id.et_partysize);
        inPtip = rootView.findViewById(R.id.et_tip);
        splitBill = rootView.findViewById(R.id.textView);


        return rootView;
    }


}
