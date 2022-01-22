package com.babulgamit.sohoj_namaz_sikkha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout_id);
        imageView=findViewById(R.id.menu_id);

        navigationView =findViewById(R.id.navigationView_id);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavController navController= Navigation.findNavController(this,R.id.navigation_host_fragment);
        NavigationUI.setupWithNavController(navigationView,navController);

        final TextView textView=findViewById(R.id.tital_Textview_id);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                textView.setText(destination.getLabel());
            }
        });


        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.home_main_id,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.home_main_id,new HomeFragment()).commit();

                } else

                if (id == R.id.nav_feedback) {

                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.home_main_id,new Feedback_Fragment()).commit();
                }
                else
               if (id == R.id.nav_contact_us) {

                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.home_main_id,new Contact_Us()).commit();


                } else

                if (id == R.id.nav_update) {

                    Toast.makeText(MainActivity.this, "Rate is clicked", Toast.LENGTH_SHORT).show();


                } else

                if (id == R.id.nav_rate) {
                    Toast.makeText(MainActivity.this, "Rate is clicked", Toast.LENGTH_SHORT).show();

                } else
                if (id == R.id.nav_setting) {

                    Toast.makeText(MainActivity.this, "No Setting at this time", Toast.LENGTH_SHORT).show();

                } else



                if (id == R.id.nav_share) {

                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String subject="Android Application.";
                    String body="This is very Useful to learn C program.\n com.example.com.sharemenuoption";

                    intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                    intent.putExtra(Intent.EXTRA_TEXT,body);

                    startActivity(Intent.createChooser(intent,"Share with"));                } else

                if (id == R.id.nav_rate) {

                    Toast.makeText(MainActivity.this, "rate is Clicked", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }


        });

    }
}
