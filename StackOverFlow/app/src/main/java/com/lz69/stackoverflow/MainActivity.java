package com.lz69.stackoverflow;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.lz69.stackoverflow.view.DragView;
import com.lz69.stackoverflow.view.ListView_1;
import com.lz69.stackoverflow.view.TextView_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lvListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView_1 tvTip = (TextView_1) findViewById(R.id.tvTip);
        lvListView = (ListView_1)findViewById(R.id.lvListView);
        final ObjectAnimator anim4 = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.rotate_four);
        anim4.setTarget(tvTip);
        anim4.setInterpolator(new LinearInterpolator());
        anim4.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim4.start();
                    }
                }, 3000);
            }
        });
        anim4.start();
        SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.item_list_test, new String[] { "data"},
                new int[] { R.id.tvData});
        lvListView.setAdapter(adapter);

        TextView tvAppName = (TextView) findViewById(R.id.tvAppName);
        float x = tvAppName.getX();
        float y = tvAppName.getY();
        Log.i("zoulilang", "onCreate()");

//        DragView dragView = (DragView) findViewById(R.id.dvDragView);
//        dragView.startScroll(0, 0, -500, -1000);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", "data0");
        list.add(map);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("data", "data1");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("data", "data2");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("data", "data3");
        list.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("data", "data4");
        list.add(map4);

        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("data", "data5");
        list.add(map5);

        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("data", "data6");
        list.add(map6);

        return list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("zoulilang", "onResume()");
    }
}
