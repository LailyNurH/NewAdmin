package com.laily.newadmin_sosiofun.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.laily.newadmin_sosiofun.Adapter.EbookAdapter;
import com.laily.newadmin_sosiofun.Model.Ebook;
import com.laily.newadmin_sosiofun.R;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<Ebook> list;
    private EbookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        ebookRecycler = findViewById(R.id.rvEbook);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();
    }
    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Ebook ebook = snapshot.getValue(Ebook.class);
                    list.add(ebook);
                }
                adapter = new EbookAdapter(EbookActivity.this, list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}