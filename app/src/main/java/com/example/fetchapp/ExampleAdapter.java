package com.example.fetchapp;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends ArrayAdapter implements Filterable, Filterable2 {
    List <String> nameList;
    List<String> dummyList;
    public ExampleAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        nameList = objects;
        dummyList = objects;
    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredList = new ArrayList<>();
            if( constraint == null || constraint.length() == 0 )
                filteredList.addAll(nameList);
            else {
                String pattern = constraint.toString().toLowerCase().trim();
                for(String i : nameList) {
                    if(i.toLowerCase().contains(pattern))
                        filteredList.add(i);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dummyList.clear();
            dummyList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}