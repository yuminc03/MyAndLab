package kr.hs.emirim.s2019w20.myandlab.ch09canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import kr.hs.emirim.s2019w20.myandlab.R

class PainterActivity : AppCompatActivity() {

    companion object{// static
        const val LINE = 100//구분하기 위함
        const val CIRCLE = 200//구분하기 위함
        const val RECTANGLE = 300
        const val COLOR = 400
        const val COLOR_RED = 500
        const val COLOR_BLUE = 600
        lateinit var contentView : View

        var curShape = LINE
        var curColor = Color.RED
        const val TAG = "페인터액티비티"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView = MyGraphicView(this)
        setContentView(contentView)
        title = resources.getString(R.string.painter_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, LINE, 0, resources.getString(R.string.draw_line))
        menu.add(0, CIRCLE, 0, resources.getString(R.string.draw_circle))
        menu.add(0, RECTANGLE, 0, resources.getString(R.string.draw_Rectangle))

        val sMenu : SubMenu = menu.addSubMenu(getString(R.string.change_color))
        sMenu.add(0, COLOR_RED, 0, getString((R.string.red)))
        sMenu.add(0, COLOR_BLUE, 0, getString((R.string.blue)))

//        var sMenu : SubMenu = menu.addSubMenu(getString(R.string.change_color))
//        sMenu.add(0, COLOR_RED, 0, getString((R.string.red))
//        sMenu.add(0, COLOR_BLUE, 0, getString((R.string.blue))

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when(item.itemId){
            LINE ->{
                curShape = LINE
                Toast.makeText(this, resources.getString(R.string.draw_line)
                        + " " + resources.getString(R.string.mode), Toast.LENGTH_SHORT).show()
                return true
            }
            CIRCLE -> {
                curShape = CIRCLE
                Toast.makeText(this, resources.getString(R.string.draw_circle)
                    + " " + resources.getString(R.string.mode), Toast.LENGTH_SHORT).show()
                return true
            }
            RECTANGLE -> {
                curShape = RECTANGLE
                Toast.makeText(this, resources.getString(R.string.draw_Rectangle)
                        + " " + resources.getString(R.string.mode), Toast.LENGTH_SHORT).show()
                return true
            }
            COLOR_RED ->{
                curColor = Color.RED
                contentView.invalidate()
            }
            COLOR_BLUE ->{
                curColor = Color.BLUE
                contentView.invalidate()
            }

        }
        return false
    }

    private class MyGraphicView(context: Context): View(context){
        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1

        override fun onTouchEvent(event: MotionEvent): Boolean {
            super.onTouchEvent(event)
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                    Log.d(TAG, "ACTION_DOWN startX: $startX/startY:$startY")
                }
                MotionEvent.ACTION_MOVE->{
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    Log.d(TAG, "ACTION_MOVE startX: $startX/startY:$startY")
                    this.invalidate()
                }
                MotionEvent.ACTION_UP ->{
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    Log.d(TAG, "ACTION_UP startX: $startX/startY:$startY")
                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val curPaint = Paint()
            curPaint.isAntiAlias = true
            curPaint.strokeWidth = 1f
            curPaint.textSize = 12f
            curPaint.style = Paint.Style.FILL_AND_STROKE
            curPaint.color = curColor
            canvas.drawRect(10f, 10f, 110f, 110f,  curPaint)

            curPaint.color = Color.BLACK
            when(curShape){
                LINE ->{
                    canvas.drawText(
                        resources.getString(R.string.mode)
                                + ":"
                                + resources.getString(R.string.draw_line),
                    130f, 10f, curPaint)
                    contentView.invalidate()
                }
                CIRCLE ->{
                    canvas.drawText(
                        resources.getString(R.string.mode)
                                + ":"
                                + resources.getString(R.string.draw_circle),
                        130f, 10f, curPaint)
                        contentView.invalidate()
                }
                RECTANGLE ->{
                    canvas.drawText(
                        resources.getString(R.string.mode)
                                + ":"
                                + resources.getString(R.string.draw_Rectangle),
                        130f, 10f, curPaint)
                        contentView.invalidate()
                }
            }

            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = curColor
            when(curShape){
                LINE -> canvas.drawLine(startX.toFloat(), startY.toFloat(),
                    stopX.toFloat(), stopY.toFloat(), paint)
                CIRCLE->{
                    var radius = Math.sqrt(
                        Math.pow((stopX - startY).toDouble(), 2.0)
                            + Math.pow((stopY - startX).toDouble(), 2.0))
                    canvas.drawCircle(startX.toFloat(), startY.toFloat(),
                    radius.toFloat(), paint)
                }
                RECTANGLE->{
                    canvas.drawRect(startX.toFloat(), startY.toFloat(),
                    stopX.toFloat(), stopY.toFloat(), paint)
                }
            }
        }
    }

}