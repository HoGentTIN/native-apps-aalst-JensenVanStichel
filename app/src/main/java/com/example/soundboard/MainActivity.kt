package com.example.soundboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.soundboard.databinding.ActivityMainBinding
import com.example.soundboard.ui.main.SoundFragment
import com.example.soundboard.ui.main.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    //private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //toolbar = binding.toolbar
        //setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewPager = binding.viewpager
        setupViewPager(viewPager)

        tabLayout = binding.tabLayout
        tabLayout.setupWithViewPager(viewPager)
        //setupTabIcons();
        //makeActionOverflowMenuShown();

        /*viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                Toast.makeText(getApplicationContext(),
                    "Selected page position: " + position,
                    Toast.LENGTH_SHORT).show()
                if (!searchView.isIconified())
                {
                    //searchView.onActionViewExpanded();
                    searchView.setIconified(true)
                    searchView.setIconified(true)
                }
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                //code goes here
                Toast.makeText(getApplicationContext(),
                    "onPageScrolled",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Code goes here
                Toast.makeText(getApplicationContext(),
                    "onPageScrollStateChanged",
                    Toast.LENGTH_SHORT).show();
            }
        })*/
    }
    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(
            supportFragmentManager
        )
        adapter.addFrag(SoundFragment(), "Sound")
        adapter.addFrag(SoundFragment(), "System App")
        viewPager.adapter = adapter
    }
    /*private fun makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try
        {
            val config = ViewConfiguration.get(this)
            val menuKeyField = ViewConfiguration::class.java!!.getDeclaredField("sHasPermanentMenuKey")
            if (menuKeyField != null)
            {
                menuKeyField.setAccessible(true)
                menuKeyField.setBoolean(config, false)
            }
        }
        catch (e:Exception) {
            Log.d("", e.getLocalizedMessage())
        }
    }*/

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_icon_text_tabs, menu)
        val searchManager = getSystemService(this.SEARCH_SERVICE) as SearchManager
        val mSearchMenuItem = menu.findItem(R.id.action_search)
        searchView = menu.findItem(R.id.action_search)
            .getActionView() as SearchView
        if (mSearchMenuItem != null)
        {
            searchView = mSearchMenuItem.getActionView() as SearchView
        }
        if (searchView != null)
        {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this
                .getComponentName()))
        }
        searchView.setIconifiedByDefault(true)
        MenuItemCompat.expandActionView(mSearchMenuItem)
        val queryTextListener = object:SearchView.OnQueryTextListener() {
            fun onQueryTextChange(query:String):Boolean {
                // this is your adapter that will be filtered
                val pagerAdapter = viewPager
                    .getAdapter() as PagerAdapter
                for (i in 0 until pagerAdapter.getCount())
                {
                    val viewPagerFragment = viewPager
                        .getAdapter().instantiateItem(viewPager, i) as Fragment
                    if ((viewPagerFragment != null && viewPagerFragment.isAdded()))
                    {
                        if (viewPagerFragment is UserAppFragment)
                        {
                            chatFragment = viewPagerFragment as UserAppFragment
                            if (chatFragment != null)
                            {
                                chatFragment.beginSearch(query)
                            }
                        }
                        else if (viewPagerFragment is SystemDefaultAppFragment)
                        {
                            groupsFragment = viewPagerFragment as SystemDefaultAppFragment
                            if (groupsFragment != null)
                            {
                                groupsFragment.beginSearch(query)
                            }
                        }
                    }
                }
                return false
            }
            fun onQueryTextSubmit(query:String):Boolean {
                // Here u can get the value "query" which is entered in the
                return false
            }
        }
        searchView.setOnQueryTextListener(queryTextListener)

        return super.onCreateOptionsMenu(menu)
    }*/
}
