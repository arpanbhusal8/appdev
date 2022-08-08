package com.example.noticeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.noticeboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacefrgmnt(new home());
        binding.bottomNavigationView2.setOnItemSelectedListener(item ->
        {
            switch(item.getItemId())
            {
                case R.id.home:
                    replacefrgmnt(new home());
                    break;
                case R.id.accounting:
                    replacefrgmnt(new accounting());
                    break;
                case R.id.complaints:
                    replacefrgmnt(new complaints());
                    break;
                case R.id.contacts:
                    replacefrgmnt(new contacts());
                    break;
                case R.id.rulebook:
                    replacefrgmnt(new rulebook());
                    break;
            }
            return true;
        });

    }
    private void replacefrgmnt(Fragment frgmnt)
    {
        FragmentManager frgmntmngr=getSupportFragmentManager();
        FragmentTransaction frgmnttrnsc =frgmntmngr.beginTransaction();
        frgmnttrnsc.replace(R.id.frame,frgmnt);
        frgmnttrnsc.commit();
    }
}