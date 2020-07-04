package luv.zoey.runningapp.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {

    @TypeConverter
    fun toBitmap(bytes: ByteArray) : Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }


    // 비트맵을 DB에 저장하기 위해 ByteArray로 형을 변환해준다.
    @TypeConverter
    fun fromBitmap(bmp: Bitmap) : ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)

        return outputStream.toByteArray()
    }
}