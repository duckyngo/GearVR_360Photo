package kennyngo.com.myapplication;

import android.os.Bundle;
import android.view.MotionEvent;

import org.gearvrf.GVRActivity;

public class MainActivity extends GVRActivity {

    PhotoView main = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = new PhotoView();
        setMain(main, "gvr.xml");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        main.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
