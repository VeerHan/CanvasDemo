package com.leohan.canvasdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Leo on 16/3/8.
 */
public class CustomView extends View {

    private Paint paint;

    private int x;
    private int y;

    public CustomView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        x = getMeasuredWidth();
        y = getMeasuredWidth();

        //画最外面的圆
        canvas.drawCircle(x / 2, y / 2, x / 2, paint);

        //画刻度
        paint.setColor(Color.BLUE);
        canvas.drawLine(x / 2, y / 8, x / 2, 0, paint);

        canvas.save();

        for (int i = 0; i < 3; i++) {
            canvas.rotate(30, x / 2, y / 2);
            canvas.drawLine(x / 2, y / 8, x / 2, 0, paint);
        }


        canvas.restore();
        //canvas.rotate(-90, x / 2, y / 2);
        paint.setStrokeWidth(10);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(x / 2, y / 2, x / 2, y / 4, paint);
    }
}
