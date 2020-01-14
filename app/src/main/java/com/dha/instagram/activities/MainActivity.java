package com.dha.instagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.dha.instagram.models.PostModel;
import com.dha.instagram.R;
import com.dha.instagram.models.StoryModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmNav;
//    Fragment selectedFragment = null;

    public static List<PostModel> listPosts = new ArrayList<>();
    public static List<StoryModel> listStories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNav = findViewById(R.id.nav_view);

        getSupportActionBar().hide();

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_add, R.id.navigation_liked, R.id.navigation_profile
        ).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(btmNav, navController);


        listPosts.add(new PostModel("1","Amir Khan", "Looking damn handsome", R.drawable.post5, R.drawable.post7));
        listPosts.add(new PostModel("2","Sharukh Khan", "Game On", R.drawable.post2, R.drawable.post8));
        listPosts.add(new PostModel("3","Sharukh Khan", "die heart fan", R.drawable.post, R.drawable.profilepic));
        listPosts.add(new PostModel("4","Amir Khan", "handsome", R.drawable.profilepic2, R.drawable.profilepic2));


        listStories.add(new StoryModel("1","Tom Cruise", R.drawable.post1, 0));
        listStories.add(new StoryModel("Tom Cruise", R.drawable.post3));
        listStories.add(new StoryModel("1","Tomcruisefan", R.drawable.post1, 0));
        listStories.add(new StoryModel("Amir Khan", R.drawable.post7));

    }




}
