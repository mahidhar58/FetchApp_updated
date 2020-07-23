package com.example.fetchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.ListView;
import android.widget.SearchView;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Filterable {

    SearchView sv;
    ListView lv;
    ExampleAdapter adapter;
    List<String> nameList = new ArrayList<>();
    String[] name = {"Stefan","Damon","Elena","Jeremy","Bonnie","Matt","Katherine","Elijah","Niklaus","Rebekah","Kol","Finn","Micheal","Esther","Tyler","Mason","Caroline","Elizabeth","Carol","Richard","Alaric","Jenna","Hayley","Josette","Malachai","Penelope","Luke","Logan","Harper","Cade","Seline","Lilian","Nora","Valerie","Lorenzo","Rayna","Freya","Marcel","Joshua","Davina","Timothy","Hope","Genevieve","Jackson","Oliver","Aiden","Dahlia","Aurora","Tristan","Lucien","Vincent","Caleb","Mary","Lucifer","Chloe","Cain","Adam","Jacob","Amy","Boyle","Rosa","Raymond","Kevin","Terrance","Regina","Jonas","Martha","Sophie","Rachel","Ross","Joey","Chandler","Phoebe","Monica","Janice","Drake","Alyssa","Arthur","Camielle","Ella","Madison","Shawn","Guster","Juliet","Lassiter","Henry","Karen","Anthony","Chris","Stark","Steve","Scott","Bruce","Peter","Pepper","Natalie","Carter","Denver","Nick","Noah","Leonard","Penny","Sheldon","Howard","Rajesh","Bernadette"};


   @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv = (SearchView) findViewById(R.id.search);
        lv = (ListView) findViewById(R.id.list);
        for(String n : name)
            nameList.add(n);
        adapter = new ExampleAdapter(this,android.R.layout.simple_list_item_1,nameList);
        lv.setAdapter(adapter);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


}