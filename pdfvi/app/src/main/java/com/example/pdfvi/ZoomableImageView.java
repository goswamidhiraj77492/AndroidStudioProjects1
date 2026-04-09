package com.example.pdfvi;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.appcompat.widget.AppCompatImageView;

public class ZoomableImageView extends AppCompatImageView {

    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    private PointF start = new PointF();
    private PointF mid = new PointF();
    private float oldDist = 1f;

    private float[] m = new float[9];
    private float viewWidth, viewHeight;
    private float saveScale = 1f;
    private float minScale = 1f;
    private float maxScale = 5f;

    private ScaleGestureDetector scaleDetector;
    private GestureDetector gestureDetector;
    private OnSwipeListener onSwipeListener;

    public interface OnSwipeListener {
        void onSwipeLeft();
        void onSwipeRight();
    }

    public ZoomableImageView(Context context) {
        super(context);
        init(context);
    }

    public ZoomableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        super.setClickable(true);
        scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
        gestureDetector = new GestureDetector(context, new GestureListener());
        matrix = new Matrix();
        setImageMatrix(matrix);
        setScaleType(ScaleType.MATRIX);
    }

    public void setOnSwipeListener(OnSwipeListener listener) {
        this.onSwipeListener = listener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        viewHeight = MeasureSpec.getSize(heightMeasureSpec);
        
        // Center image initially
        if (saveScale == 1f) {
            fitToScreen();
        }
    }

    private void fitToScreen() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)
            return;

        int bmWidth = drawable.getIntrinsicWidth();
        int bmHeight = drawable.getIntrinsicHeight();

        float scaleX = viewWidth / bmWidth;
        float scaleY = viewHeight / bmHeight;
        float scale = Math.min(scaleX, scaleY);
        matrix.setScale(scale, scale);

        // Center the image
        float redundantYSpace = viewHeight - (scale * bmHeight);
        float redundantXSpace = viewWidth - (scale * bmWidth);
        redundantYSpace /= 2;
        redundantXSpace /= 2;

        matrix.postTranslate(redundantXSpace, redundantYSpace);
        saveScale = 1f;
        setImageMatrix(matrix);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);

        PointF curr = new PointF(event.getX(), event.getY());

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                savedMatrix.set(matrix);
                start.set(curr);
                mode = DRAG;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                performClick();
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    float deltaX = curr.x - start.x;
                    float deltaY = curr.y - start.y;
                    matrix.set(savedMatrix);
                    matrix.postTranslate(deltaX, deltaY);
                    fixTranslation();
                }
                break;
        }

        setImageMatrix(matrix);
        return true;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    private void fixTranslation() {
        matrix.getValues(m);
        float transX = m[Matrix.MTRANS_X];
        float transY = m[Matrix.MTRANS_Y];

        Drawable drawable = getDrawable();
        if (drawable == null) return;
        float fixTransX = getFixTrans(transX, viewWidth, drawable.getIntrinsicWidth() * saveScale);
        float fixTransY = getFixTrans(transY, viewHeight, drawable.getIntrinsicHeight() * saveScale);

        if (fixTransX != 0 || fixTransY != 0)
            matrix.postTranslate(fixTransX, fixTransY);
    }

    private float getFixTrans(float trans, float viewSize, float contentSize) {
        float minTrans, maxTrans;

        if (contentSize <= viewSize) {
            minTrans = 0;
            maxTrans = viewSize - contentSize;
        } else {
            minTrans = viewSize - contentSize;
            maxTrans = 0;
        }

        if (trans < minTrans) return -trans + minTrans;
        if (trans > maxTrans) return -trans + maxTrans;
        return 0;
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float mScaleFactor = detector.getScaleFactor();
            float origScale = saveScale;
            saveScale *= mScaleFactor;
            if (saveScale > maxScale) {
                saveScale = maxScale;
                mScaleFactor = maxScale / origScale;
            } else if (saveScale < minScale) {
                saveScale = minScale;
                mScaleFactor = minScale / origScale;
            }

            if (viewWidth > getDrawable().getIntrinsicWidth() * saveScale || viewHeight > getDrawable().getIntrinsicHeight() * saveScale)
                matrix.postScale(mScaleFactor, mScaleFactor, viewWidth / 2, viewHeight / 2);
            else
                matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY());

            fixTranslation();
            return true;
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (saveScale > 1.1f) return false; // Don't swipe while zoomed
            
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();
            
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > 100 && Math.abs(velocityX) > 100) {
                    if (diffX > 0) {
                        if (onSwipeListener != null) onSwipeListener.onSwipeRight();
                    } else {
                        if (onSwipeListener != null) onSwipeListener.onSwipeLeft();
                    }
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (saveScale > 1f) {
                fitToScreen();
            } else {
                matrix.postScale(2f, 2f, e.getX(), e.getY());
                saveScale = 2f;
                fixTranslation();
            }
            setImageMatrix(matrix);
            return true;
        }
    }
    
    public void resetZoom() {
        saveScale = 1f;
        fitToScreen();
    }
}
