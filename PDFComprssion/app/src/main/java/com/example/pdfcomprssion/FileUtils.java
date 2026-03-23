package com.example.pdfcomprssion;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

public class FileUtils {
    public static String getpath(Context context, Uri uri){
        String[] projection = {MediaStore.Files.FileColumns.DATA};
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        return null;
    }
}
