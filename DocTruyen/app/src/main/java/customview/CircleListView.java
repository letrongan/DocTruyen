package customview;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.ListView;

/**
 * Created by TieuHoan on 17/04/2017.
 */

public class CircleListView extends ListView  {

    private static final int CIRCLE_OFFSET = 500;
    private static final float DEGTORAD = 1.0f / 180.0f * (float) Math.PI;
    private static final float SCALING_RATIO = 0.001f;
    private static final float TRANSLATION_RATIO = 0.09f;


    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        Matrix m = t.getMatrix();

        m.reset();

        child.invalidate();

        final float halfHeight = child.getMeasuredHeight() * 0.5f;
        final float parentHalfHeight = getHeight() * 0.5f;
        final float y = child.getTop();
        final float rot = parentHalfHeight - halfHeight - y;

        float r = rot * 0.05f;

        final float scale = 1.0f - Math.abs(parentHalfHeight - halfHeight - y) * SCALING_RATIO;
        float dx = (float) ((-Math.cos(rot * TRANSLATION_RATIO * DEGTORAD) + 1) * CIRCLE_OFFSET);

        m.postRotate(r, 0, halfHeight);
        m.postTranslate(dx / scale, 0);
        m.postScale(scale, scale);

        return true;
    }


    public CircleListView(Context context, AttributeSet attrs, int defStyle) {
        super(context,attrs,defStyle);
        setStaticTransformationsEnabled(true);
    }
    public CircleListView(Context context, AttributeSet attrs) {
        super(context,attrs);
        setStaticTransformationsEnabled(true);
    }
    public CircleListView(Context context) {
        super(context);
        setStaticTransformationsEnabled(true);
    }
}
