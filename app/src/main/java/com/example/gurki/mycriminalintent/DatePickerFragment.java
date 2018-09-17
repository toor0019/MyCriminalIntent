package com.example.gurki.mycriminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment {
    public static final String ARG_DATE="date";
    public DatePicker mDatePicker;
    @Override
    public Dialog onCreateDialog(Bundle bundle){
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.crime_date_picker,null);
        Date date = (Date) getArguments().getSerializable(ARG_DATE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date);
        mDatePicker.init(year, month, day, null);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,null).create();
    }
    public DialogFragment newInstance(Date date){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_DATE,date);
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(bundle);
        return  datePickerFragment;

    }


}
