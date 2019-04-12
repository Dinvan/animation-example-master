package com.example.alla.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: SimpleAdapter? = null


    private var layoutManager2: LinearLayoutManager? = null
    private var adapter2: SimpleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = SimpleAdapter(layoutManager)
        recyclerView.adapter = adapter


        //Set for second recyclerView
        layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView2.layoutManager = layoutManager2
        adapter2 = SimpleAdapter(layoutManager2)
        recyclerView2.adapter = adapter2


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val wrapContentLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0F)
        val matchParentLayoutParmas = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
        when (item?.itemId) {
            R.id.change_layout -> {
                if (layoutManager?.orientation == LinearLayoutManager.VERTICAL) {
                    layoutManager?.orientation = LinearLayoutManager.HORIZONTAL
                    layoutManager2?.orientation = LinearLayoutManager.VERTICAL
                    item.title = "list"


                    recyclerView.layoutParams = wrapContentLayoutParams
                    recyclerView2.layoutParams=matchParentLayoutParmas;

                } else {
                    layoutManager?.orientation = LinearLayoutManager.VERTICAL
                    layoutManager2?.orientation = LinearLayoutManager.HORIZONTAL
                    item.title = "grid"
                    recyclerView.layoutParams =matchParentLayoutParmas
                    recyclerView2.layoutParams= wrapContentLayoutParams;
                }
                adapter?.notifyItemRangeChanged(0, adapter?.itemCount ?: 0)
                adapter2?.notifyItemRangeChanged(0, adapter2?.itemCount ?: 0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
