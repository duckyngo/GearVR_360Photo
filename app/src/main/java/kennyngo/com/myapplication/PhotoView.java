package kennyngo.com.myapplication;

import android.view.MotionEvent;

import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMain;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRTexture;
import org.gearvrf.scene_objects.GVRSphereSceneObject;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * Created by DavidNgo on 12/24/2016.
 */

public class PhotoView extends GVRMain {

    private int[] m360Image = {R.raw.image_1, R.raw.image_2, R.raw.image_3, R.raw.image_4, R.raw.image_5,
            R.raw.image_6, R.raw.image_7, R.raw.image_8, R.raw.image_9, R.raw.image_10, R.raw.image_11,
            R.raw.image_12, R.raw.image_13, R.raw.image_14,R.raw.image_15, R.raw.image_16, R.raw.image_17,
            R.raw.image_18, R.raw.image_19};

    private int currentImage = 0;
    GVRScene scene;
    ArrayList<GVRSphereSceneObject> objects = null;

    @Override
    public void onInit(GVRContext gvrContext) throws Throwable {
         scene = gvrContext.getMainScene();

        objects = new ArrayList<>();

        for (int i = 0; i < m360Image.length; i++){
            objects.add(i, createObject(gvrContext, i));
        }

        scene.addSceneObject(objects.get(currentImage));
    }

    @Override
    public void onStep() {

    }

    private GVRSphereSceneObject createObject(GVRContext gvrContext, int index){
        Future<GVRTexture> textureFuture = gvrContext.loadFutureTexture(new GVRAndroidResource(gvrContext, m360Image[index]));
        return (new GVRSphereSceneObject(gvrContext, 72, 144, false, textureFuture));
    }

    public void onTouchEvent(MotionEvent event){
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                if(scene != null){
                    currentImage++;
                    if(currentImage > m360Image.length - 1)
                        currentImage = 0;
                    scene.removeAllSceneObjects();
                    scene.addSceneObject(objects.get(currentImage));
                }
        }
    }
}
